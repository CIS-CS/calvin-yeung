
/**
 * Implements the Factory pattern for creating TichetMachine objects.
 * We need a way of indicating that an invalid value has been passed to the constructor,
 * but constructors do not return anything, thus, we can use a Factory class to manage this.
 * 
 * @author MHayes 
 * @version 2015-11-08
 */
public class TicketFactory
{
    public TicketMachine getTicketMachine(int cost)
    {
        if (cost > 0) 
        {
            return new TicketMachine(cost);
        }
        else
        {
            return null;
        }
    }
}
