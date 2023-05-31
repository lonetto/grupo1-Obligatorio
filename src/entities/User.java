package entities;

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
    }

    public User( String name, String location, String description, Date created, long followers, long friends, long favourites, boolean verified) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.created = created;
        this.followers = followers;
        this.friends = friends;
        this.favourites = favourites;
        this.verified = verified;
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
}
