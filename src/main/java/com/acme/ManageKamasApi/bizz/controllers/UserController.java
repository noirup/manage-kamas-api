package com.acme.ManageKamasApi.bizz.controllers;

import com.acme.ManageKamasApi.bizz.dto.JwtTokenResponse;
import com.acme.ManageKamasApi.bizz.dto.JwtUserDetails;
import com.acme.ManageKamasApi.bizz.dto.UserDto;
import com.acme.ManageKamasApi.dal.dao.IUserService;
import com.acme.ManageKamasApi.exceptions.AuthenticationException;
import com.acme.ManageKamasApi.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * User Controller.
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDto authenticationRequest)
            throws AuthenticationException {

        authenticate(authenticationRequest.getLogin(), authenticationRequest.getPassword());

        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getLogin());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenResponse(token));
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({ AuthenticationException.class })
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {

        UserDto newUser = userService.registerNewUser(user);

        return Objects.nonNull(newUser) ? createAuthenticationToken(newUser) : ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    /**
     * Get the users.
     * @return the list of users
     */
    @GetMapping("get_users")
    public List<UserDto> getUsers() {
        return userService.findAll();
    }
}
