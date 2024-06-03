package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FoodModelDTO {

    private String foodName;

    private float grams;

    private float calories;
}
