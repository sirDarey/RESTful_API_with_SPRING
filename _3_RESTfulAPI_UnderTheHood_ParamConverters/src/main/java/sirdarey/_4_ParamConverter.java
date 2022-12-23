package sirdarey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/paramConverter")
public class _4_ParamConverter {

	//Demonstrating Param Converter
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String demo (@QueryParam("code") Currency currency) {
		return "\n"+currency;
	}

}
