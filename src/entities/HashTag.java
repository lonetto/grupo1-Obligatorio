package entities;


import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;

public class HashTag {

    private long id;
    private String text;
    private MyLinkedList<Tweet> tweets;

    public HashTag(long id, String text) {
        this.id = id;
        this.text = text;
        this.tweets = tweets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MyLinkedList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(MyLinkedList<Tweet> tweets) {
        this.tweets = tweets;
    }
}
