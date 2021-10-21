package stocks.observables;

import stocks.observers.IObserver;

import java.util.ArrayList;
import java.util.List;

//this is the class that will "do something" interesting that
//other classes may want to know about
public abstract class Observable
{
    private List<IObserver> observers;

    public Observable()
    {
        observers = new ArrayList<>();
    }

    //add a new observer if it is not already in the list
    public void addObserver(IObserver observer)
    {
        if (!observers.contains(observer))
        {
            observers.add(observer);
        }
        else
        {
            throw new IllegalArgumentException("Observer already present!");
        }
    }

    //this method will pass values to all observers
    public void notify(Object... arguments)
    {
        for (IObserver observer : observers)
        {
            observer.update(arguments);
        }
    }
}











