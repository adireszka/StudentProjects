package com.hogwart.gradebook.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")

public class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NonNull
        @Column(name = "name", nullable = false)
        private String name;

        @NonNull
        @Column(name = "species", nullable = false)
        private String species;

        @NonNull
        @Column(name = "gender", nullable = false)
        private String gender;

        @NonNull
        @Column(name = "house", nullable = false)
        private String house;

        @NonNull
        @Column(name = "date_of_birth", nullable = false)
        private String dateOfBirth;

        @NonNull
        @Column(name = "wizard", nullable = false)
        private Boolean wizard;

        @NonNull
        @Column(name = "ancestry", nullable = false)
        private String ancestry;

        @NonNull
        @Column(name = "patronus", nullable = false)
        private String patronus;

        @NonNull
        @Column(name = "hogwarts_student", nullable = false)
        private boolean hogwartsStudent;

        @NonNull
        @Column(name = "hogwarts_staff", nullable = false)
        private boolean hogwartsStaff;

        @NonNull
        @Column(name = "image", length = 1000)
        private String image;
    }