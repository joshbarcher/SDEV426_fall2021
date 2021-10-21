package stocks.observers;

//this interface describes classes that observe
//interesting behaviors in other classes
public interface IObserver
{
    void update(Object[] arguments);
}
