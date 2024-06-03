package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UsersFoodModelDTO {

    private int id;

    private String usersFoodName;

    private float usersGrams;

    private float calories;
}
