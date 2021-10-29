package ads.generation;

public class LasVegasAdGenerator extends AdGenerator
{
    //this method is a factory method that is responsible
    //for creating objects of a certain type (the parent
    //class will use those objects)
    @Override
    public IRegionalGenerator getGenerator()
    {
        return new LasVegasAds();
    }
}
