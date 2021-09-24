package model;

public class ThemeParkRide
{
    private String name;
    private double price;
    private int lineLength;

    public ThemeParkRide(String name, double price, int lineLength)
    {
        this.name = name;
        this.price = price;
        this.lineLength = lineLength;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getLineLength()
    {
        return lineLength;
    }

    public void setLineLength(int lineLength)
    {
        this.lineLength = lineLength;
    }

    @Override
    public String toString()
    {
        return "ThemeParkRide{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", lineLength=" + lineLength +
                '}';
    }
}
