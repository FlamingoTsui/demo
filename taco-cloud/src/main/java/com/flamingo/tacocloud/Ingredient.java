package com.flamingo.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author flamingo
 * @create 8/28/21 4:26 PM
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
