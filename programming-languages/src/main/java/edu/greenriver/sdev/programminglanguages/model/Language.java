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
public class Language implements Comparable<Language>
{
    //surrogate key
    @Id //this is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //this is auto-increment
    private int languageId;

    private String name;
    private int ranking;
    private boolean looselyTyped;

    @Override
    public int compareTo(Language other)
    {
        //order languages by rank
        return this.ranking - other.ranking;
    }
}
