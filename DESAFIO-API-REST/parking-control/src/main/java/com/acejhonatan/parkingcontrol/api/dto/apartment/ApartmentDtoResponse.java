package com.acejhonatan.parkingcontrol.api.dto.apartment;

import com.acejhonatan.parkingcontrol.api.dto.owner.OwnerDtoResponse;
import com.acejhonatan.parkingcontrol.core.util.GetterUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ApartmentDtoResponse implements GetterUtil<Long>, Serializable {

    private static final long serialVersionUID = 6442755643665436014L;

    private final Long id;
    private final String number;
    private final OwnerDtoResponse owner;
}
