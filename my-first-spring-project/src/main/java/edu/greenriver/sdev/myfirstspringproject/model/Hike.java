package edu.greenriver.sdev.myfirstspringproject.model;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Hike
{
    private String location;
    private double miles;
    private int difficulty; //1-5 stars
    private boolean favorited;

}
