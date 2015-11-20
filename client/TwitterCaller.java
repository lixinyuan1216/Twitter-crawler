/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitter;

import com.entity.Tweet;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 *
 * @author lxy
 */
public class TwitterCaller {

    public TwitterCaller() {
        TwitterCaller caller;
    }

    public static final String CONSUMER_KEY = "NtpYG50e1QI1DYwYlQIHuNQy6";
    public static final String CONSUMER_SECRET = "Oi9ZqER5YZpa6u44ES3knSnu3bvuO7GGOm9uNiHQZNnrHvA3k9";
    public static final String OAUTH_TOKEN = "1888372604-6VoeROvkSghPM1vtjpOOGFxOxxnMeo1D9FjiuY6";
    public static final String OAUTH_TOKEN_SECRET = "2mtZmO0jvormfAlW7JNVSyvoLTLHfo06i7LItLl0bO4iV";

    public String TwitterResponse(String query, String city) throws Exception {
        OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(OAUTH_TOKEN, OAUTH_TOKEN_SECRET);
        query = query.replaceAll(" ", "%20");
        Map cityList = new HashMap();
        cityList.put("Chicago", "41.850029,-87.650047");
        cityList.put("Houston", "29.763281,-95.363274");
        cityList.put("Los Angeles", "34.052231,-118.243683");
        cityList.put("New York", "40.7142672,-74.005966");
        cityList.put("San Francisco", "37.774929,-122.419418");
        String cityGeo = cityList.get(city).toString();
        String URL = "https://api.twitter.com/1.1/search/tweets.json?q=" + query + "&count=500" + "&geocode=" + cityGeo + ",50mi";
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        RestConnection conn = new RestConnection(consumer.sign(URL), pathParams, queryParams);
        RestResponse response = conn.get();
        return response.getDataAsString();
    }

    public ArrayList<Tweet> parser(String query, String city) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(TwitterResponse(query, city));
            JSONArray jsonArray = json.getJSONArray("statuses");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tweet tweet = new Tweet();
                tweet.setTweetId(jsonObject.getString("id"));
                tweet.setTweetText(jsonObject.getString("text"));
                tweet.setCreatedAt(jsonObject.getString("created_at"));
                tweet.setCreatedUser(jsonObject.getJSONObject("user").getString("name"));
                tweets.add(tweet);
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        return tweets;
    }
}
