package com.myapp.RESTService_Messanger.resources;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import com.myapp.RESTService_Messanger.model.*;
import com.myapp.RESTService_Messanger.service.MessageService;
import com.myapp.RESTService_Messanger.service.ProfileService;


@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getMessage(@PathParam("profileName") String name){
		return profileService.getProfile(name);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String name, Profile profile){
		profile.setProfileName(name);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public Profile deleteProfile(@PathParam("profileName") String name){
		return profileService.deleteProfile(name);
	}
}
