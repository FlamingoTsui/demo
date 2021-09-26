package com.flamingo.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author flamingo
 * @create 8/28/21 4:46 PM
 */
@Data
@RequiredArgsConstructor
public class Taco {

    private String name;

    private List<String> ingredients;
}
