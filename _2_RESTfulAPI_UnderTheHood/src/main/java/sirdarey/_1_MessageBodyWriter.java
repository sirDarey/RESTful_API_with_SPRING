package sirdarey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mbw")
public class _1_MessageBodyWriter {

	//Demonstrating Message Body Writer
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Name demo () {
		return new Name("John", "Doe");
	}

}
