package org.sturrock.example;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.xml.bind.JAXBException;

import org.jboss.logging.Logger;

@Path("/")
public class Controller {

	@Inject
	private Logger log;

	public Controller() throws IOException, JAXBException {
	}

	@GET
	@Path("/hello/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFile(@Context HttpHeaders headers, @Context HttpServletResponse httpServletResponse,
			@DefaultValue("Mr Nobody") @QueryParam("name") String name) {

		log.debug("/hello/" + name);

		Hello person = new Hello(name);
		ResponseBuilder ok = Response.ok();
		ok = ok.type(MediaType.APPLICATION_JSON);
		ok = ok.entity(person);
		return ok.build();
	}
}
