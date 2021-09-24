package builder;

import model.ThemeParkRide;

public class ThemeParkRideBuilder
{
    private String name;
    private double price;
    private int lineLength;

    public ThemeParkRideBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    public ThemeParkRideBuilder setPrice(double price)
    {
        this.price = price;
        return this;
    }

    public ThemeParkRideBuilder setLineLength(int lineLength)
    {
        this.lineLength = lineLength;
        return this;
    }

    public ThemeParkRide createThemeParkRide()
    {
        return new ThemeParkRide(name, price, lineLength);
    }
}