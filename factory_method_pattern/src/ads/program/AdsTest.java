package ads.program;

import ads.entities.Advertisement;
import ads.generation.AdGenerator;

public class AdsTest
{
    public static void main(String[] args)
    {
        AdGenerator adgenerator = new CaliforniaAds();
        
        for (Advertisement ad : adgenerator.getAllAds())
        {
            System.out.println(ad);
        }
    }
}



