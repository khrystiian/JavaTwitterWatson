package tweets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ContentItem;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;
import com.ibm.watson.developer_cloud.util.GsonSingleton;

public class Watson {
 
	public void getWatson() throws FileNotFoundException{
		
		JsonParser parser = new JsonParser();
		 
		PersonalityInsights service = new PersonalityInsights();
		service.setUsernameAndPassword("1174b3f3-3585-496a-bd30-42f8e5479939", "aiAKt4pwmPaV");
		service.setEndPoint("https://gateway.watsonplatform.net/personality-insights/api");
		 GetTweets gt = new GetTweets();
		 String text = gt.getAllTweets();
		 
		 Profile profile = service.getProfile(text).execute();
	        JsonObject json = parser.parse(profile.toString()).getAsJsonObject();
	        
	        System.out.println(json);
		 
	}
}
