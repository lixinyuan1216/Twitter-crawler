/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twitter;

import com.entity.Tweet;
import java.util.ArrayList;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author lxy
 */
public class Data {

    public Data() {
        NewJerseyClient client = new NewJerseyClient();
    }

    public ArrayList<Tweet> getAllData() {

        NewJerseyClient client = new NewJerseyClient();
        GenericType<ArrayList<Tweet>> genericType = new GenericType<ArrayList<Tweet>>() {
        };
        Response res = client.findAll_JSON(Response.class);
        return res.readEntity(genericType);
    }

    public boolean findData(String id) {

        NewJerseyClient client = new NewJerseyClient();
        GenericType<ArrayList<Tweet>> genericType = new GenericType<ArrayList<Tweet>>() {
        };
        Response res = client.find_JSON(Response.class, id);
        return res.readEntity(genericType)==null ;
    }
}
