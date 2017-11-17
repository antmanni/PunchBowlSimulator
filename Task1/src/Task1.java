import java.util.ArrayList;
import java.util.List;


//Task1 Punch Bowl Simulation.
//Command line arguments
//0 : amount of guests
//1 : amount of portions
//2 : time to take a drink from the bowl
public class Task1
{
    
    public Task1() {
    	
    }    
        
    public static void main(String[] args) {
        Bowl bowl = new Bowl(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[0]));
    	Servant servant = new Servant(bowl, "servant");
        List<Guest> guests = new ArrayList<Guest>();
        
        
        //Add every guest to the list.
        for (int n = 1; n <= Integer.parseInt(args[0]) ; n++)
        {
        	guests.add(new Guest(n, bowl, "guest"));
        }
        
        //Start the threads.
        servant.start();

    	for (Guest g : guests) {
    		g.start();
    	}
                       

        }
}
	


