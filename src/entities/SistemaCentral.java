package entities;

//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyHash;

import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SistemaCentral {

    String[] csvsample = {"1","name","user_location","user_description","2022-03-27 18:23:26","1","1","1" , "1" ,"2022-03-27 18:23:26","text", "['F1Finale', 'F1', 'AbuDabhiGP']", "comoestas", "flor", "holi"};


    private MyHash<String, User> hashUsers = new MyClosedHashImpl<>(20000);
    private MyHash<Long, Tweet> hashTweets = new MyClosedHashImpl<>(200000);
    private MyHash<Long, HashTag> hashHashtag = new MyClosedHashImpl<>(50000);
    private long idUsers = 1;
    private long idHashtag = 1;


    public void leerCSV(String path) throws IOException, OutOfMemoryError { //CsvValidationException
        //CSVReader csvReader = new CSVReader(new FileReader(path));

        //String[] line;
        //while ((line = csvReader.readNext()) != null) {
            String[] line = csvsample;
            agregarTodo(line);
        //}
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
                //Las siguientes 3 lineas son para parsear las fechas desde tipo String a tipo Date
                String dateString1 = line[9];
                //No podriamos usar el format de la linea 49?
                Date date = format.parse(dateString1);
                String text = line[10];
                //Hashtag resolver porque es un arraylist
                String hashtag = line[11];
                hashtag = hashtag.substring(1, hashtag.length() - 1);
                hashtag = hashtag.replace("'", " ");
                String[] hashtags = hashtag.split(",");
                //Me queda recorrer los splits y guardarlos por separado
                for (String element : hashtags) { //hacemos un for each
                    agregarHashtag(element);                }
                String source = line[12];
                boolean is_retweet = Boolean.parseBoolean(line[13]);

                //Agregar las funciones
                agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
                //Nos queda agregar el user, no?
                agregarTweet(tweet_id, date, text, source, is_retweet);
                agregarHashtag(hashtag);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
                //No agregar nada
            }

        }

    }

    //Cambie lo de idUser
    public void agregarUser(String user_name, String user_location, String user_description, Date user_created, long user_followers, long user_friends, long user_favourites, boolean user_verified) {
        User user1;
        if(!existeUser(user_name)){
            user1 = new User(idUsers, user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            hashUsers.put(user_name, user1);
            idUsers++;
        }
    }

    //Capaz estaria bueno que retornara el user
    public boolean existeUser(String user_name){
        return (hashUsers.get(user_name)!=null);
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

    public boolean existeHashtag(Long idHashtag){
        return (hashHashtag.get(idHashtag)!= null);
    }
}
