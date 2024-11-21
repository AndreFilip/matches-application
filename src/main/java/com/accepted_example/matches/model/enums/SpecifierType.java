package com.accepted_example.matches.model.enums;

import lombok.Getter;

@Getter
public enum SpecifierType {
    HOME("1"),
    DRAW("X"),
    GUEST("2");

    private final String code;

    SpecifierType(String code) {
        this.code = code;
    }
}
