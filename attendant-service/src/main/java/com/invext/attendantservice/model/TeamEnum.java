package com.invext.attendantservice.model;

import lombok.Getter;

@Getter
public enum TeamEnum {
    CARD("Card"),
    LOAN("Loan"),
    OTHER("Other");

    private final String description;

   TeamEnum(String description) {
        this.description = description;
    }

    public static TeamEnum fromString(String value) {
        for (TeamEnum team : TeamEnum.values()) {
            if (team.getDescription().equalsIgnoreCase(value)) {
                return team;
            }
        }
        throw new IllegalArgumentException("Invalid category value: " + value);
    }
}
