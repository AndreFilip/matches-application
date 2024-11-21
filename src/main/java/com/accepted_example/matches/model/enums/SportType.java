package com.accepted_example.matches.model.enums;

import lombok.Getter;

@Getter
public enum SportType {
    FOOTBALL(Short.valueOf("1")),
    BASKETBALL(Short.valueOf("2"));

    private final Short code;

    SportType(Short code) {
        this.code = code;
    }
}
