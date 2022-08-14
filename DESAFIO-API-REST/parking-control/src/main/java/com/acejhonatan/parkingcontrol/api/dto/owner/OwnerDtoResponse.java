package com.acejhonatan.parkingcontrol.api.dto.owner;

import com.acejhonatan.parkingcontrol.core.util.GetterUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class OwnerDtoResponse implements GetterUtil<Long>, Serializable {

    private static final long serialVersionUID = 317505260322255453L;

    private Long id;
    private String name;
    private String document;
}
