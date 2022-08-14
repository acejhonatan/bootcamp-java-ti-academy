package com.acejhonatan.parkingcontrol.api.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.time.LocalDateTime.now;

@Getter
@Setter
@JsonInclude(NON_NULL)
public class Error {

    private Integer status;
    private LocalDateTime dateTime = now();
    private String title;
    private List<Field> fields;

    public static class Field {

        private final String name;
        private final String message;

        public Field(String name, String message) {
            this.name = name;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public String getMessage() {
            return message;
        }
    }
}
