package edu.greenriver.sdev.myfirstspringproject.model;

public class Hike
{
    private String location;
    private double miles;
    private int difficulty; //1-5 stars
    private boolean favorited;

    public Hike(String location, double miles, int difficulty, boolean favorited)
    {
        this.location = location;
        this.miles = miles;
        this.difficulty = difficulty;
        this.favorited = favorited;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public double getMiles()
    {
        return miles;
    }

    public void setMiles(double miles)
    {
        this.miles = miles;
    }

    public int getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public boolean isFavorited()
    {
        return favorited;
    }

    public void setFavorited(boolean favorited)
    {
        this.favorited = favorited;
    }

    @Override
    public String toString()
    {
        return "Hike{" +
                "location='" + location + '\'' +
                ", miles=" + miles +
                ", difficulty=" + difficulty +
                ", favorited=" + favorited +
                '}';
    }
}
