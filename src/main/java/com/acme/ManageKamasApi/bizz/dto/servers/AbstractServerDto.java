package com.acme.ManageKamasApi.bizz.dto.servers;

import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.io.Serializable;

public abstract class AbstractServerDto implements Serializable {
    @Getter
    @Setter
    @Id
    @Nullable
    private long id;
    @Getter
    @Setter
    @Nullable
    private String serverName;
}
