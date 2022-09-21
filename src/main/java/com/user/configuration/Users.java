package com.user.configuration;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    private Integer id;
    private String name;
}
