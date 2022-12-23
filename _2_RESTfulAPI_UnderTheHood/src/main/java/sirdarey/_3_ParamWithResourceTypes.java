package sirdarey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/singleton")
//@Singleton //Uncomment this if you want to see a CRASH....
public class _3_ParamWithResourceTypes {
	
	//To Demonstrate that class level variables cannot be used within a SINGLETON class
	
	@PathParam("path") String pathParam;
	@QueryParam("query") String queryParam;
	
	@GET
	@Path("/{path}")
	@Produces(MediaType.TEXT_PLAIN)
	public String paramOnResourceTypes () {  //The SINGLETON annotation on the class has to be commented out, else, an error occurs
		return "The value of pathParam is: "+pathParam
				+"\nThe value of QueryParam is " +queryParam;
	}
	
}
