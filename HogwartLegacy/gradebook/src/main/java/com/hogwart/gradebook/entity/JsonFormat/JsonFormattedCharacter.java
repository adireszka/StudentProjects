package com.hogwart.gradebook.entity.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.hogwart.gradebook.entity.Wand;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class JsonFormattedCharacter {
    public String id;
    public String name;
    public List<String> alternate_names;
    public String species;
    public String gender;
    public String house;
    public String dateOfBirth;
    public Integer yearOfBirth;
    public Boolean wizard;
    public String ancestry;
    public String eyeColour;
    public String hairColour;
    public Wand wand;
    public String patronus;
    public Boolean hogwartsStudent;
    public Boolean hogwartsStaff;
    public String actor;
    public List<String> alternate_actors;
    public Boolean alive;
    public String image;
}
