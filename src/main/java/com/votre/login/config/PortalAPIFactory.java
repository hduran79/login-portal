package com.votre.login.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ibm.portal.portlet.service.PortletServiceHome;
import com.ibm.portal.portlet.service.PortletServiceUnavailableException;
import com.ibm.portal.portlet.service.login.LoginHome;
import com.ibm.portal.um.PumaController;
import com.ibm.portal.um.PumaHome;
import com.ibm.portal.um.PumaLocator;

@ApplicationScoped
public class PortalAPIFactory {
	
	@Produces
	@ApplicationScoped
	public Context context() throws NamingException{
		return new InitialContext();
	}
	
	@Produces
	@ApplicationScoped
	public PortletServiceHome portletServiceHome(Context ctx) throws NamingException{
		return (PortletServiceHome) ctx.lookup(LoginHome.JNDI_NAME);
	}
	
	@Produces
	@ApplicationScoped
	public LoginHome loginHome(PortletServiceHome psh) throws PortletServiceUnavailableException{
		return (LoginHome) psh.getPortletService(LoginHome.class);
	}
	
	@Produces
	@ApplicationScoped
	public PumaHome pumaHome(Context ctx) throws NamingException{
		return (PumaHome) ctx.lookup(PumaHome.JNDI_NAME);
	}
	
	@Produces
	@ApplicationScoped
	public PumaController pumaController(PumaHome ph){
		return ph.getController();
	}
	
	@Produces
	@ApplicationScoped
	public PumaLocator pumaLocator(PumaHome ph){
		return ph.getLocator();
	}

}
