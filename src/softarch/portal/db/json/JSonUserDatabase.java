package softarch.portal.db.json;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import softarch.portal.data.CheapSubscription;
import softarch.portal.data.ExpensiveSubscription;
import softarch.portal.data.FreeSubscription;
import softarch.portal.data.UserProfile;

/**
 * The class to operate JSON database.
 * @author Chunxiang Yan
 */

public class JSonUserDatabase extends JSonDatabase{
	
	Path FreeSubscriptionPath, CheapSubscriptionPath, ExpensiveSubscriptionPath;
	String dbPath;
	
	/**
	 * Creates a new user database.
	 */
	public JSonUserDatabase() {
		super();
		dbPath = "/Users/Chauncey/Documents/2nd_Semester/Software_Architectures_-_Document/Software_Architectures_-_Document_-_Assignments/web_portal/JSonDB/";
		FreeSubscriptionPath = Paths.get(dbPath + "FreeSubscription.js");
		CheapSubscriptionPath = Paths.get(dbPath + "CheapSubscription.js");
		ExpensiveSubscriptionPath = Paths.get(dbPath + "ExpensiveSubscription.js");
	}
	
	/**
	 * Inserts a new user profile into the user database.
	 */
	public void insert(UserProfile user){
		String jsonUser = gson.toJson(user); 
		System.out.print(user.subscriptionType);
		switch (user.subscriptionType) {
		case "Free":
			JSONWrite(jsonUser, FreeSubscriptionPath);
			break;
		case "Cheap":
			JSONWrite(jsonUser, CheapSubscriptionPath);
			break;
		case "Expensive":
			JSONWrite(jsonUser, ExpensiveSubscriptionPath);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Function to find an user.  
	 */
	public UserProfile findUser(String username) {
		JsonParser parser = new JsonParser();
		JsonArray jArray;
		JsonObject jObj;

		if (!JSONRead(FreeSubscriptionPath).isEmpty()){
		//Check the FreeSubscriptionTable
			if (parser.parse(JSONRead(FreeSubscriptionPath)).isJsonArray()){
				jArray = (parser.parse(JSONRead(FreeSubscriptionPath))).getAsJsonArray();
				for (JsonElement obj : jArray){
					 FreeSubscription user = gson.fromJson(obj, FreeSubscription.class);
					 if (username == user.getUsername()){
						 return user;
					 }
				}
			} else {
				jObj = (parser.parse(JSONRead(FreeSubscriptionPath))).getAsJsonObject();
				FreeSubscription user = gson.fromJson(jObj, FreeSubscription.class);
				if (user.getUsername().equals(username)){
					return user;
				}
			}
		}
		
		if (!JSONRead(CheapSubscriptionPath).isEmpty()){
			//Check the CheapSubscriptionTable
			if (parser.parse(JSONRead(CheapSubscriptionPath)).isJsonArray()){
				jArray = (parser.parse(JSONRead(CheapSubscriptionPath))).getAsJsonArray();
				for (JsonElement obj : jArray){
					 CheapSubscription user = gson.fromJson(obj, CheapSubscription.class);
					 if (username == user.getUsername()){
						 return user;
					 }
				}
			} else {
				jObj = (parser.parse(JSONRead(CheapSubscriptionPath))).getAsJsonObject();
				CheapSubscription user = gson.fromJson(jObj, CheapSubscription.class);
				if (user.getUsername().equals(username)){
					 return user;
				}
			}
		}
		
		if (!JSONRead(ExpensiveSubscriptionPath).isEmpty()){
			//Check the ExpensiveSubscriptionTable
			if (parser.parse(JSONRead(ExpensiveSubscriptionPath)).isJsonArray()){
				jArray = (parser.parse(JSONRead(ExpensiveSubscriptionPath))).getAsJsonArray();
				for (JsonElement obj : jArray){
					 ExpensiveSubscription user = gson.fromJson(obj, ExpensiveSubscription.class);
					 if (username == user.getUsername()){
						 return user;
					 }
				}
			} else {
				jObj = (parser.parse(JSONRead(ExpensiveSubscriptionPath))).getAsJsonObject();
				ExpensiveSubscription user = gson.fromJson(jObj, ExpensiveSubscription.class);
				if (user.getUsername().equals(username)){
					 return user;
				}
			}
		}
		return null;
	}
	
	/**
	 * To assert if an user exists or not 
	 */
}