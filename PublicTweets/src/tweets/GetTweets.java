package tweets;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTweets {
	
	public String getAllTweets(){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

	    cb.setDebugEnabled(true)
	      .setOAuthConsumerKey("qcNC6qskrxDBACl8sXwYYpf5u")
	      .setOAuthConsumerSecret("Tdho8AZXIMGcftiVR7BWrDai4MDl9ebaYir1PII3L9caFNu9DI")
	      .setOAuthAccessToken("1583551296-6U5HVGnD3J6dNrkfPYRvP8SNOP2AxaRyhjbL2tH")
	      .setOAuthAccessTokenSecret("BwHS78eb9ySLnCzpJpVpRimzkkRzpxLxfotcTJ01LEe6s");

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    Paging paging = new Paging(1,700);
	    List<Status> statuses = null;
	    String tweets_list = "";
		try {
			
			statuses = twitter.getUserTimeline("@Arsenal", paging);
			for (Status status : statuses) {
				if(status.getRetweetedStatus() == null)
				tweets_list += status.getText();
			}
			tweets_list = tweets_list.replaceAll("\\S+://\\S+", "").replaceAll("@", "").replaceAll("#", "");
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets_list;
	}
     
}
