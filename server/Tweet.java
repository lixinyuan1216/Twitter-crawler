/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tweetentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lxy
 */
@Entity
@Table(name = "TWEET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tweet.findAll", query = "SELECT t FROM Tweet t"),
    @NamedQuery(name = "Tweet.findByTweetId", query = "SELECT t FROM Tweet t WHERE t.tweetId = :tweetId"),
    @NamedQuery(name = "Tweet.findByTweetText", query = "SELECT t FROM Tweet t WHERE t.tweetText = :tweetText"),
    @NamedQuery(name = "Tweet.findByCreatedAt", query = "SELECT t FROM Tweet t WHERE t.createdAt = :createdAt"),
    @NamedQuery(name = "Tweet.findByCreatedUser", query = "SELECT t FROM Tweet t WHERE t.createdUser = :createdUser"),
    @NamedQuery(name = "Tweet.findByCreatedLocation", query = "SELECT t FROM Tweet t WHERE t.createdLocation = :createdLocation")})
public class Tweet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "TWEET_ID")
    private String tweetId;
    @Size(max = 255)
    @Column(name = "TWEET_TEXT")
    private String tweetText;
    @Size(max = 255)
    @Column(name = "CREATED_AT")
    private String createdAt;
    @Size(max = 255)
    @Column(name = "CREATED_USER")
    private String createdUser;
    @Size(max = 255)
    @Column(name = "CREATED_LOCATION")
    private String createdLocation;

    public Tweet() {
    }

    public Tweet(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetId() {
        return tweetId;
    }

    public void setTweetId(String tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getCreatedLocation() {
        return createdLocation;
    }

    public void setCreatedLocation(String createdLocation) {
        this.createdLocation = createdLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tweetId != null ? tweetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tweet)) {
            return false;
        }
        Tweet other = (Tweet) object;
        if ((this.tweetId == null && other.tweetId != null) || (this.tweetId != null && !this.tweetId.equals(other.tweetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tweetentity.Tweet[ tweetId=" + tweetId + " ]";
    }
    
}
