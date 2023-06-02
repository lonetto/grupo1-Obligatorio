package entities;


import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;

public class HashTag {

    private long id;
    private String text;
    private MyLinkedList<Tweet> tweets;

    public HashTag(long id, String text) {
        this.id = id;
        this.text = text;
        this.tweets =  new MyLinkedListImpl<>();
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
