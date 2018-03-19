package com.myapp.RESTService_Messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myapp.RESTService_Messanger.database.DatabaseClass;
import com.myapp.RESTService_Messanger.model.Message;
import com.myapp.RESTService_Messanger.model.Profile;

public class ProfileService {

	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("kiranbs", new Profile(1L,"kiranbs","text1","kiran"));
		profiles.put("shilpabs", new Profile(2L,"shilpabs","text2","kiran"));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	
}
