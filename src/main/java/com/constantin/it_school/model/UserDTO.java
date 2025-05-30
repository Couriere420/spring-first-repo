package com.constantin.it_school.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id
        , String name
        , String email
        , Integer age) {
}
