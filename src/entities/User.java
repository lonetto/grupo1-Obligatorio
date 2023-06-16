package entities;

import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;

import java.util.Date;

public class User {

    private long id;
    private String name;
    private String location;
    private String description;
    private Date created;
    private long followers;
    private long friends;
    private long favourites;
    private boolean verified;
    private int countTweets;
    public MyLinkedList<Tweet> tweets;


    public User(long id, String name, String location, String description, Date created, long followers, long friends, long favourites, boolean verified) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.created = created;
        this.followers = followers;
        this.friends = friends;
        this.favourites = favourites;
        this.verified = verified;
        this.countTweets = 0;
        this.tweets = new MyLinkedListImpl<>();
    }

    /*
    public User(String name, String location, String description, Date created, long followers, long friends, long favourites, boolean verified) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.created = created;
        this.followers = followers;
        this.friends = friends;
        this.favourites = favourites;
        this.verified = verified;
    }

     */
    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
        this.countTweets++;
    }
    public int getCountTweets() {
        return countTweets;
    }

    public void setCountTweets(int countTweets) {
        this.countTweets = countTweets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
    }

    public long getFriends() {
        return friends;
    }

    public void setFriends(long friends) {
        this.friends = friends;
    }

    public long getFavourites() {
        return favourites;
    }

    public void setFavourites(long favourites) {
        this.favourites = favourites;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
