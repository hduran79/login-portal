package com.votre.login.service;

import javax.inject.Inject;
import javax.portlet.PortletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.portal.portlet.service.PortletServiceHome;
import com.ibm.portal.portlet.service.login.LoginHome;
import com.ibm.portal.um.PumaController;
import com.ibm.portal.um.PumaHome;
import com.ibm.portal.um.PumaLocator;
import com.votre.login.config.LOGINPortlet;

@Path("dummy")
public class DummyService {

	private static final Logger LOG = LoggerFactory.getLogger(LOGINPortlet.class);

	@Inject
	PortletServiceHome psh;

	@Inject
	LoginHome loginHome;

	@Inject
	PumaHome pumaHome;

	@Inject
	PumaLocator pumaLocator;

	@Inject
	PumaController pumaController;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDummy() throws PortletException {
		LOG.info("**Service: Entrando al servicio dummy");

		LOG.info(psh.toString());
		LOG.info("LoginHome Cargado");
		LOG.info(loginHome.toString());
		LOG.info("PumaHome Cargado");
		LOG.info(pumaHome.toString());
		LOG.info(pumaController.toString());
		LOG.info(pumaLocator.toString());

		LOG.info("Dependencias principales cargadas");
		
		return "Hola Mundo !!";
	}

}
