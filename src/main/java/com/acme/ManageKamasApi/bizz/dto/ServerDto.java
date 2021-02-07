package com.acme.ManageKamasApi.bizz.dto;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ServerDto implements Serializable {

    @Getter
    @Setter
    @Id
    @Nullable
    private long id;
    @Getter
    @Setter
    @Nullable
    private List<UserDto> User;
    @Getter
    @Setter
    @Nullable
    private String serverName;
}
