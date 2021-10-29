package ads.entities;

public class Advertisement
{
    private String message;

    public Advertisement(String message)
    {
        this.message = message;
    }
    
    public String toString()
    {
        return "Advertisement: " + message;
    }
}

