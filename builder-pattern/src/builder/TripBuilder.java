package builder;

import model.Trip;

import java.time.LocalDate;

/**
 * This class is a builder for the Trip class. It makes
 * it easier to create a Trip object as well as supporting
 * different construction methods.
 */
public class TripBuilder
{
    //the builder has the same fields as the product class (Trip class)
    private String destination;
    private int milesToDest;
    private String methodOfTravel;
    private String[] reservations;
    private double budget;
    private LocalDate starting;
    private LocalDate ending;

    //we need to make it easy to create a Builder
    public TripBuilder()
    {
        //do nothing...
    }

    //setters for each field that can be called in any order
    //key technique: each method returns the Builder object

    public TripBuilder destination(String destination)
    {
        this.destination = destination;
        return this;
    }

    public TripBuilder milesToDest(int milesToDest)
    {
        this.milesToDest = milesToDest;
        return this;
    }

    public TripBuilder methodOfTravel(String methodOfTravel)
    {
        this.methodOfTravel = methodOfTravel;
        return this;
    }

    public TripBuilder reservations(String[] reservations)
    {
        this.reservations = reservations;
        return this;
    }

    public TripBuilder budget(double budget)
    {
        this.budget = budget;
        return this;
    }

    public TripBuilder starting(LocalDate starting)
    {
        this.starting = starting;
        return this;
    }

    public TripBuilder ending(LocalDate ending)
    {
        this.ending = ending;
        return this;
    }

    //the job of the builder is to assemble a Product (Trip) object
    //we can have one or multiple methods here

    public Trip assembleAll()
    {
        //here we have to know what the constructor for the Product
        //looks like
        return new Trip(destination, milesToDest, methodOfTravel,
                reservations, budget, starting, ending);
    }

    public Trip assembleImminentTrip()
    {
        return new Trip(destination, milesToDest, methodOfTravel,
                reservations, budget, LocalDate.now(), null);
    }

    public Trip assembleVagueTrip()
    {
        return new Trip(destination, 0, "",
                        null, 0, null, null);
    }

    public Trip defaultTrip()
    {
        return new Trip("New York", 0, "Flying",
                new String[] {}, 3000, null, null);
    }
}
