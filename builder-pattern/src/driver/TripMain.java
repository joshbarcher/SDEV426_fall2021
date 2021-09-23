package driver;

import builder.TripBuilder;
import model.Trip;

import java.time.LocalDate;

public class TripMain
{
    public static void main(String[] args)
    {
        //boo on this....
        Trip floridaTrip = new Trip("Florida", 2000, "Flying",
                new String[] {"Hotel Reservation", "Restaurant Reservation",
                              "Disney World Reservation"},
                4000.0, LocalDate.of(2021, 12, 15), LocalDate.of(2021, 12, 24));
        System.out.println(floridaTrip);

        //this is better....
        Trip campingTrip = new TripBuilder()
            .budget(1500)
            .destination("Eastern WA")
            .methodOfTravel("Driving")
            .milesToDest(200)
            .reservations(new String[] {"HOA Grounds"})
            .starting(LocalDate.of(2022, 4, 25))
            .ending(LocalDate.of(2022, 4, 29))
            .assembleAll();
        System.out.println(campingTrip);

        Trip lotrTrip = new TripBuilder()
                .methodOfTravel("Flying")
                .destination("New Zealand")
                .budget(3000)
                .assembleAll();
        System.out.println(lotrTrip);

        Trip goingSomewhere = new TripBuilder().defaultTrip();
        System.out.println(goingSomewhere);
        goingSomewhere.setStarting(LocalDate.now());
    }
}
