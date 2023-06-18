package entities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyHash;

import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SistemaCentral {

    //Mock para ver si funciona la lectura de datos
    //String[] csvsample = {"1","name","user_location","user_description","2022-03-27 18:23:26","1","1","1" , "1" ,"2022-03-27 18:23:26","text", "['F1Finale', 'F1', 'AbuDabhiGP']", "comoestas", "flor", "holi"};

    private MyHash<String, User> hashUsers = new MyClosedHashImpl<>(20000);
    private MyHash<Long, Tweet> hashTweets = new MyClosedHashImpl<>(200000);
    private MyHash<Long, HashTag> hashHashtag = new MyClosedHashImpl<>(50000);
    private long idUsers = 1;
    private long idHashtag = 1;


    public void leerCSV(String path) throws CsvValidationException, IOException, OutOfMemoryError {
        CSVReader csvReader = new CSVReader(new FileReader(path));

        String[] line;
        while ((line = csvReader.readNext()) != null) {
            //String[] line = csvsample;
            agregarTodo(line);
        }
    }



    public void agregarTodo(String[] line) {
        int noVacios = 0;
        for(int i=0; i<14; i++){
            if(!line[i].isEmpty()){
                noVacios++;
            }
        }
        if (noVacios == 14){
            try {
                long tweet_id = Long.parseLong(line[0]);
                String user_name = line[1];
                String user_location = line[2];
                String user_description = line[3];
                //Las siguientes 3 lineas son para parsear las fechas desde tipo String a tipo Date
                String dateString = line[4];
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date user_created = format.parse(dateString);
                long user_followers = Long.parseLong(line[5]);
                long user_friends = Long.parseLong(line[6]);
                long user_favourites = Long.parseLong(line[7]);
                boolean user_verified = Boolean.parseBoolean(line[8]);
                String dateString1 = line[9];
                Date date = format.parse(dateString1);
                String text = line[10];
                //Las siguientes 4 lineas son para parsear los hashtags de Array a tipo string por separado
                String hashtag = line[11];
                hashtag = hashtag.substring(1, hashtag.length() - 1);
                hashtag = hashtag.replace("'", " ");
                String[] hashtags = hashtag.split(",");
                for (String element : hashtags) { //hacemos un for each
                    agregarHashtag(element);                }
                String source = line[12];
                boolean is_retweet = Boolean.parseBoolean(line[13]);

                //Agregar las funciones
                User user = agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
                agregarTweet(tweet_id, date, text, source, is_retweet, user);
                agregarHashtag(hashtag);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
                //No agregar nada
            }

        }

    }

    //Cambie lo de idUser e hice que lo retornara
    public User agregarUser(String user_name, String user_location, String user_description, Date user_created, long user_followers, long user_friends, long user_favourites, boolean user_verified) {
        User user1 = existeUser(user_name);
        if(user1 != null){
            user1 = new User(idUsers, user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            hashUsers.put(user_name, user1);
            idUsers++;
        }
        return user1;
    }

    public User existeUser(String user_name){
        return (hashUsers.get(user_name));
    }

    public Tweet agregarTweet(long tweet_id, Date date, String content, String source, boolean is_retweet, User user) {
        Tweet tweet = existeTweet(tweet_id);
        if (tweet != null){
            tweet = new Tweet(tweet_id, date, content, source, is_retweet, user);
            hashTweets.put(tweet_id, tweet);
            user.addTweet(tweet);
        }
        return tweet;
    }

    public Tweet existeTweet(long tweet_id){
        return hashTweets.get(tweet_id);
    }

    public void agregarHashtag(String text){
        HashTag hashtag1;
        if(!existeHashtag(idHashtag)){
            hashtag1 = new HashTag(idHashtag, text);
            hashHashtag.put(idHashtag, hashtag1);
            idHashtag++;
        }
    }

    public boolean existeHashtag(Long idHashtag){
        return (hashHashtag.get(idHashtag)!= null);
    }


    public MyHash<String, User> getHashUsers() {
        return hashUsers;
    }

    public void setHashUsers(MyHash<String, User> hashUsers) {
        this.hashUsers = hashUsers;
    }

    public MyHash<Long, Tweet> getHashTweets() {
        return hashTweets;
    }

    public void setHashTweets(MyHash<Long, Tweet> hashTweets) {
        this.hashTweets = hashTweets;
    }

    public MyHash<Long, HashTag> getHashHashtag() {
        return hashHashtag;
    }

    public void setHashHashtag(MyHash<Long, HashTag> hashHashtag) {
        this.hashHashtag = hashHashtag;
    }
}
