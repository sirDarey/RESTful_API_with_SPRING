package sirdarey.showroom.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import sirdarey.showroom.model.ErrorPayload;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorPayload error = new ErrorPayload(500, "Header Not Found; Generic Exception Called");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(error).build();
	}

	
}
