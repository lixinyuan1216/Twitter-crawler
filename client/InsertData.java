/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitter;

/**
 *
 * @author lxy
 */
import com.entity.Tweet;

public class InsertData {

    public static void main(String[] args) throws Exception {
        NewJerseyClient client = new NewJerseyClient();
        TwitterCaller caller = new TwitterCaller();
        String[] cityList = {"Chicago", "Houston", "Los Angeles", "New York", "San Francisco"};
        for (String s : cityList) {
            for (Tweet t : caller.parser("spoonie", s)) {
                if (checkRedundance(t)) {
                    t.setCreatedLocation(s);
                    client.create_JSON(t);
                }
            }
            for (Tweet t : caller.parser("fibromyalgia", s)) {
                if (checkRedundance(t)) {
                    t.setCreatedLocation(s);
                    client.create_JSON(t);
                }
            }
            for (Tweet t : caller.parser("fibro", s)) {
                if (checkRedundance(t)) {
                    t.setCreatedLocation(s);
                    client.create_JSON(t);
                }
            }
        }
    }

    public static boolean checkRedundance(Tweet t) {
        Data data = new Data();
        return data.findData(t.getTweetId());
    }
}
