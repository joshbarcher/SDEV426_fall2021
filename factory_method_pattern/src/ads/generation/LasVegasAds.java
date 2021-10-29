package ads.generation;

import ads.entities.Advertisement;

import java.util.List;

public class LasVegasAds implements IRegionalGenerator
{
    @Override
    public List<Advertisement> getAppropriateAds()
    {
        return List.of(
            new Advertisement("Visit the Taj Majal!"),
            new Advertisement("Gamble away your fortunes!"),
            new Advertisement("Visit the main highway!"),
            new Advertisement("The desert awaits!")
        );
    }
}
