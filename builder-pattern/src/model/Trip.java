package model;

import java.time.LocalDate;
import java.util.Arrays;

public class Trip
{
    private String destination;
    private int milesToDest;
    private String methodOfTravel;
    private String[] reservations;
    private double budget;
    private LocalDate starting;
    private LocalDate ending;

    public Trip(String destination, int milesToDest, String methodOfTravel,
                String[] reservations, double budget, LocalDate starting,
                LocalDate ending)
    {
        this.destination = destination;
        this.milesToDest = milesToDest;
        this.methodOfTravel = methodOfTravel;
        this.reservations = reservations;
        this.budget = budget;
        this.starting = starting;
        this.ending = ending;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public int getMilesToDest()
    {
        return milesToDest;
    }

    public void setMilesToDest(int milesToDest)
    {
        this.milesToDest = milesToDest;
    }

    public String getMethodOfTravel()
    {
        return methodOfTravel;
    }

    public void setMethodOfTravel(String methodOfTravel)
    {
        this.methodOfTravel = methodOfTravel;
    }

    public String[] getReservations()
    {
        return reservations;
    }

    public void setReservations(String[] reservations)
    {
        this.reservations = reservations;
    }

    public double getBudget()
    {
        return budget;
    }

    public void setBudget(double budget)
    {
        this.budget = budget;
    }

    public LocalDate getStarting()
    {
        return starting;
    }

    public void setStarting(LocalDate starting)
    {
        this.starting = starting;
    }

    public LocalDate getEnding()
    {
        return ending;
    }

    public void setEnding(LocalDate ending)
    {
        this.ending = ending;
    }

    @Override
    public String toString()
    {
        return "Trip{" +
                "destination='" + destination + '\'' +
                ", milesToDest=" + milesToDest +
                ", methodOfTravel='" + methodOfTravel + '\'' +
                ", reservations=" + Arrays.toString(reservations) +
                ", budget=" + budget +
                ", starting=" + starting +
                ", ending=" + ending +
                '}';
    }
}
