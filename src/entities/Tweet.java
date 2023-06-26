package entities;

import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;

import java.util.Date;

public class Tweet {

    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private Date date;
    private User user;
    private MyLinkedList<HashTag> hashtags;
    public Tweet(long id, Date date, String content, String source, boolean isRetweet, User user) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.user = user;
        this.hashtags = new MyLinkedListImpl<>();
    }
    //Agregamos funcion para consultas 3 y 4
    public boolean checkDate(Date date){
        return this.date.getDay() == date.getDay() && this.date.getMonth() == date.getMonth() && this.date.getYear() == date.getYear();
    }
    public void addHashTag(HashTag hashTag){
        hashtags.add(hashTag);
    }
    public MyLinkedList<HashTag> getHashtags(){
        return hashtags;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }

    public void setRetweet(boolean retweet) {
        isRetweet = retweet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
