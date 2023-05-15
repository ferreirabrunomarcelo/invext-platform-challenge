package com.invext.attendantservice.model;

import lombok.Getter;

@Getter
public enum CategoryEnum {
    CARD("Card"),
    LOAN("Loan"),
    OTHER("Other");

    private final String description;

    CategoryEnum(String description) {
        this.description = description;
    }

    public static CategoryEnum fromString(String value) {
        for (CategoryEnum category : CategoryEnum.values()) {
            if (category.getDescription().equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid category value: " + value);
    }
}
