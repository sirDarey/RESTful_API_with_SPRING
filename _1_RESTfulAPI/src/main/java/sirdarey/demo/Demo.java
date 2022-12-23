package sirdarey.demo;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/")
public class Demo {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String homePage() {
		return "\n Welcome To My RESTFul API Homepage";
	}
	
	@GET
	@Path("/usefulAnnotations")
	@Produces(MediaType.TEXT_PLAIN)
	public String usefulAnnotations(@HeaderParam("customHeader") String headerValue,
			@CookieParam("customCookie") String cookieValue) {
		
		String cookie = (cookieValue == null)? "No cookies available" : cookieValue;
		return "Custom Header value is: "+headerValue +"\nCustom Cookie value is: "+cookie;
	}
	
	@Context
	private UriInfo uriInfo;
	
	@Context
	private ServletContext servletContext;
	
	@GET
	@Path("/context")
	@Produces(MediaType.TEXT_PLAIN)
	public String contextAnnotation (@Context HttpHeaders headers) {
		
		return "Absoule Path Info: " +uriInfo.getAbsolutePath().toString()
				+"\n\nContext Path : "+servletContext.getContextPath()
				+"\n\nHTTP Headers list: " +headers.getRequestHeaders().keySet().toString()
				+"\n\nCustom Header value is: "+headers.getRequestHeader("customHeader");
	}
	
	@GET
	@Path("/exception")
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public String exception(@HeaderParam("customHeader") String headerValue) {
		if (headerValue == null) {
			//This will call the Generic Exception Mapper since we don't have a 
			//custom exception mapper for runtimeException
			
			//throw new RuntimeException(); 
			
			throw new NotFoundException(); // The proper NotFoundException mapper is called since we made a provision for it
		}
		return "Custom Header value is: "+headerValue;
	}
}
