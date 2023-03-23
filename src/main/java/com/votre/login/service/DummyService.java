package com.votre.login.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;

@Path("dummy")
public class DummyService {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
    public String getDummy() {
		return "Hola Mundo !!!";
	}
        

}
