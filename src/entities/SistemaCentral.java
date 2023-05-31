package entities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyHash;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;


public class SistemaCentral {

    private MyHash<String, User> hashUsers = new MyClosedHashImpl<>(20000);
    private MyHash<Long, Tweet> hashTweets = new MyClosedHashImpl<>(200000);
    private MyHash<String, HashTag> hashHashtag = new MyClosedHashImpl<>(50000);


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
                //Date user_created = line[4];
                long user_followers = Long.parseLong(line[5]);
                long user_friends = Long.parseLong(line[6]);
                long user_favourites = Long.parseLong(line[7]);
                boolean user_verified = Boolean.parseBoolean(line[8]);
                //Date date = line[9];
                String text = line[10];
                //Hashtags resolverlo
                String source = line[12];
                boolean is_retweet = Boolean.parseBoolean(line[13]);
                //Agregar las funciones
                agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified); //Arreglar el usercreated. Esta bien esta funcion, es decir, agregar los paramentros restantes de user y a su vez sacar en el cosntructor el parametro id?
                //Para agregar tweet uso el constructor que ya hay en tweet o creo un nuevo constructor al cual tambien le agrego la variable date de cuando fue creado el tweet?
                //Para agregar un hashtag, creo un nuevo constructor sin el parametro id o en el parametro id tambien debo poner el tweet_id??


            }catch (Exception e){
                //no agregar nada
            }

        }

    }


    public void agregarUser(String user_name, String user_location, String user_description, Date user_created, long user_followers, long user_friends, long user_favourites, boolean user_verified) {
        User user1;
        if(!existeUser(user_name)){
            user1 = new User(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            hashUsers.put(user_name, user1);
        }
    }

    public boolean existeUser(String username){
        return (hashUsers.get(username)!=null);
    }

    public void agregarTweet(long tweet_id) {

    }

    public boolean existeTweet(){

        return false;
    }

    public void agregarHashtag(){

    }

    public boolean existeHashtag(){

        return false;
    }



}
