package ads.program;

import ads.generation.LasVegasAdGenerator;

public class AdsTest
{
    public static void main(String[] args)
    {
        LasVegasAdGenerator ads = new LasVegasAdGenerator();

        //show 10 ads
        for (int i = 1; i <= 10; i++)
        {
            System.out.println(ads.showAd());
        }
    }
}



