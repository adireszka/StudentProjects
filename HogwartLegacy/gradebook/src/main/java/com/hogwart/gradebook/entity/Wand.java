package com.hogwart.gradebook.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Wand {

    private String wood;
    private String core;
    private Integer length;
}
