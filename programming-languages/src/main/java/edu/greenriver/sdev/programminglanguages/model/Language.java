package edu.greenriver.sdev.programminglanguages.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //this marks the class as a Hibernate Entity (a table will be created to store Language objects)
public class Language
{
    //surrogate key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    private String name;
    private int ranking;
    private boolean looselyTyped;
}
