package sirdarey;

import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/singleton")
@Singleton
public class _2_ResourceTypes_Singleton {

	//To demonstrate "@Singleton"
	/***** 
	 * 
	 * We have two types of resource - 
	 * 
	 * 1. The Usual resource type of object creation where object are created when called and then, die once they
	 * 		finish execution
	 * 
	 * 2. The SINGLETON resource type which makes objects stay in the memory until the server is restarted.
	 * 		They have a longer life span
	 * ****/
	
	
	
	private int x = 1;   //The experiment variable
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String resourceTypes () {
		return "The value of x is: "+ (++x);  
		
		//With the Singleton annotation, x keeps increasing every time
		//the browser is refreshed, even if another browser is opened, the value continues from the one 
		//in the previous browser 
		
		//Without the singleton annotation, this will be IMPOSSIBLE because x will remain the same after every refresh
	}
	
}
