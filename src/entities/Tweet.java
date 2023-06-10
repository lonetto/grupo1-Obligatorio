package entities;

import java.util.Date;

public class Tweet {

    private long id;
    private String content;
    private String source;
    private boolean isRetweet;
    private Date date;
    private User user;

    public Tweet(long id, Date date, String content, String source, boolean isRetweet, User user) {
        this.id = id;
        this.date = date;
        this.content = content;
        this.source = source;
        this.isRetweet = isRetweet;
        this.user = user;
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
