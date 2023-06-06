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

    private MyHash<Long, User> hashUsers = new MyClosedHashImpl<>(20000);
    private MyHash<Long, Tweet> hashTweets = new MyClosedHashImpl<>(200000);
    private MyHash<Long, HashTag> hashHashtag = new MyClosedHashImpl<>(50000);
    private long idUsers = 1;
    private long idHashtag = 1;


    public void leerCSV(String path) throws CsvValidationException, IOException, OutOfMemoryError {
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        while ((line = csvReader.readNext()) != null) {
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
                SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy HH:mm:ss");
                Date user_created = format.parse(dateString);
                long user_followers = Long.parseLong(line[5]);
                long user_friends = Long.parseLong(line[6]);
                long user_favourites = Long.parseLong(line[7]);
                boolean user_verified = Boolean.parseBoolean(line[8]);
                //Las siguientes 3 lineas son para parsear las fechas desde tipo String a tipo Date
                String dateString1 = line[9];
                SimpleDateFormat format1 =  new SimpleDateFormat("M/d/yyyy HH:mm:ss");
                Date date = format1.parse(dateString1);
                String text = line[10];
                //Hashtag resolver porque es un arraylist
                String source = line[12];
                boolean is_retweet = Boolean.parseBoolean(line[13]);
                //Agregar las funciones
                agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
                agregarTweet(tweet_id, date, text, source, is_retweet);
                agregarHashtag();


            }catch (Exception e){
                //no agregar nada
            }

        }

    }


    public void agregarUser(String user_name, String user_location, String user_description, Date user_created, long user_followers, long user_friends, long user_favourites, boolean user_verified) {
        User user1;
        if(!existeUser(idUsers)){
            user1 = new User(idUsers, user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            hashUsers.put(idUsers, user1);
            idUsers++;
        }
    }

    public boolean existeUser(Long idUsers){
        return (hashUsers.get(idUsers)!=null);
    }

    public void agregarTweet(long tweet_id, Date date, String content, String source, boolean is_retweet) {

    }

    public boolean existeTweet(){

        return false;
    }

    public void agregarHashtag(String text){
        HashTag hashtag1;
        if(!existeHashtag(idHashtag)){
            hashtag1 = new HashTag(idHashtag, text);
            hashHashtag.put(idHashtag, hashtag1);
            idHashtag++;
        }
    }

    public boolean existeHashtag(Long idHashtag){ return (hashHashtag.get(idHashtag)!= null); }

}
