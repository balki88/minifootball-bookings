package com.futsall.user;

import java.io.Serializable;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

public class UserAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6648894461890377076L;
	
	private static final String LOGIN_PAGE_ID = "login.xhtml";
	
	private String username;

	/**
	 * Checks if the user has been logged in
	 * 
	 * @param event the event on which the check is performed
	 */
	public void checkUserLoggedIn(ComponentSystemEvent event)
	{
		if (!isUserInSystem())
		{
			// the user is not logged in - do not grant access
			FacesContext context = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler handler =
					(ConfigurableNavigationHandler) context.getApplication()
							.getNavigationHandler();
			handler.performNavigation(LOGIN_PAGE_ID);
		}
	}
	
	/**
	 * Gets greeting to be displayed
	 * 
	 * @return the greeting to be displayed
	 */
	public String getGreeting() {
		if(!isUserInSystem()) {
			return "";
		} else {
			return "Welcome "+username;
		}
	}
	
	public boolean isUserInSystem() {
		return (null!=username);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
