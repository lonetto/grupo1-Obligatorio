package entities;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.RFC4180Parser;
import com.opencsv.exceptions.CsvValidationException;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayListImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyHash;
import com.opencsv.CSVReaderBuilder;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;

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
    private MyArrayList<String> drivers = new MyArrayListImpl<>(21);
    private long idUsers = 1;
    private long idHashtag = 1;


    public void leerCSV(String path) throws CsvValidationException, IOException, OutOfMemoryError {

        String[] line;
        int i= 0; RFC4180Parser rfc4180Parser = new RFC4180Parser();
        CSVParserBuilder csvParserBuilder = new CSVParserBuilder();
        csvParserBuilder.withSeparator(',').withQuoteChar('"');

        FileReader filereader = new FileReader(path);
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .withCSVParser(rfc4180Parser)
                .build();

        while ((line = csvReader.readNext()) != null) {
            agregarTodo(line);
        }
    }

    public void cargarPilotos() {
        try {
            File file = new File("sources/drivers.txt");
            Scanner scanner = new Scanner(file);

            // Mientras haya una siguiente línea en el archivo, agregar la línea (nombre del piloto) a la lista
            while (scanner.hasNextLine()) {
                String pilot = scanner.nextLine();
                drivers.add(pilot);
            }
            // Cerrar el escáner para liberar recursos
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }


    public void agregarTodo(String[] line) {
        try {
            long tweet_id = Long.parseLong(line[0]);
            String user_name = line[1];
            String user_location = line[2];
            String user_description = line[3];
            //Las siguientes 3 lineas son para parsear las fechas desde tipo String a tipo Date
            String dateString = line[4];
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date user_created = format.parse(dateString);
            double user_followers = Double.parseDouble(line[5]);
            double user_friends = Double.parseDouble(line[6]);
            double user_favourites = Double.parseDouble(line[7]);
            boolean user_verified = Boolean.parseBoolean(line[8]);
            String dateString1 = line[9];
            Date date = format.parse(dateString1);
            String text = line[10];
            //Las siguientes 4 lineas son para parsear los hashtags de Array a tipo string por separado
            String hashtag = line[11];
            if (!hashtag.isEmpty()) {
                hashtag = hashtag.substring(1, hashtag.length() - 1);
                hashtag = hashtag.replace("'", " ");
                String[] hashtags = hashtag.split(",");
                for (String element : hashtags) { //hacemos un for each
                    agregarHashtag(element);
                }
            }
            String source = line[12];
            boolean is_retweet = Boolean.parseBoolean(line[13]);
            //Agregar las funciones
            User user = agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            agregarTweet(tweet_id, date, text, source, is_retweet, user);
        } catch (Exception e){
            //Hay ciertas linea que no tienen el formato correcto, como la 199943, por lo que no se pueden parsear, se las ignora ya que son muy pocas.
        }
    }

    //Cambie lo de idUser e hice que lo retornara
    public User agregarUser(String user_name, String user_location, String user_description, Date user_created, double user_followers, double user_friends, double user_favourites, boolean user_verified) {
        User user1 = existeUser(user_name);
        if(user1 == null){
            user1 = new User(idUsers, user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            hashUsers.put(user_name, user1);
            idUsers++;
        }
        return user1;
    }

    public User existeUser(String user_name){
        return (hashUsers.get(user_name));
    }

    public void agregarTweet(long tweet_id, Date date, String content, String source, boolean is_retweet, User user) {
        Tweet tweet;
        if (!existeTweet(tweet_id)) {
            tweet = new Tweet(tweet_id, date, content, source, is_retweet, user);
            hashTweets.put(tweet_id, tweet);
            user.addTweet(tweet);
        }
    }

    public boolean existeTweet(long tweet_id){
        return (hashTweets.get(tweet_id)!= null);
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

    //Report 1
    public MyArrayList<Tweet> obtenerPilotosMasMencionadosEnTweetsPorMesYAño(int mes, int año) {

        //Creo un arraylist en el cual estaran los tweets filtrados
        MyArrayList<Tweet> tweetsFiltrados = new MyArrayListImpl<>(20000);

        for(int i = 0; i < hashTweets.size(); i++){
            Tweet tweet = hashTweets.get(hashTweets.getListaDeKeys().get(i));
            int tweetMes = tweet.getDate().getMonth() + 1;  // Se suma 1 ya que los meses en Date van de 0 a 11

            if (tweetMes == mes && tweet.getDate().getYear() + 1900 == año) {


            }
        }
        return tweetsFiltrados;
    }



    //Report 2
    public MyArrayList<User> lista15UsuariosConMasTweets() {

        MyArrayList<User> usuariosTop15Tweets = new MyArrayListImpl<>(15);

        for(int i = 0; i < hashUsers.size(); i++) {
            //Busco la cantidad de tweets de cada usuario en la lista hashUsers
            String userKey = hashUsers.keyListaKeys(i);
            User user = hashUsers.get(userKey);
            int cantidadTweets = user.tweets.size();

            //Si la lista esta vacia
            if(usuariosTop15Tweets.size() == 0) {
                usuariosTop15Tweets.add(user);
            } else if (usuariosTop15Tweets.size() < 15) {
                usuariosTop15Tweets.add(user);
                usuariosTop15Tweets.sort(Comparator.comparing(User::getCountTweets).reversed());
            } else {
                User minTweetsUser = usuariosTop15Tweets.get(0); // comienza asumiendo que el primer usuario tiene los tweets mínimos
                for (int k = 1; k < usuariosTop15Tweets.size(); k++) {
                    User currentUser = usuariosTop15Tweets.get(k); // obtén el usuario actual
                    if (currentUser.tweets.size() < minTweetsUser.tweets.size()) {
                        minTweetsUser = currentUser;
                    }
                }
                if (cantidadTweets > minTweetsUser.tweets.size()) { // Solo si el nuevo usuario tiene más tweets que el de menos en la lista actual
                    usuariosTop15Tweets.delete(minTweetsUser);
                    usuariosTop15Tweets.add(user);
                    usuariosTop15Tweets.sort(Comparator.comparing(User::getCountTweets).reversed()); // Ordena la lista en orden descendente de tweets
                }
            }
        }
        return usuariosTop15Tweets;
    }



    //Report 5
    public MyArrayList<User> lista7UsuariosConMasFavoritos(){

        MyArrayList<User> usuariosTop7Favoritos = new MyArrayListImpl<>(7);

        for (int i = 0; i < hashUsers.size(); i++) {
            //Busco los favoritos de cada usuario en la lista hashUsers
            String userKey = hashUsers.keyListaKeys(i);
            User user = hashUsers.get(userKey);
            double favoritos = user.getFavourites();

            //Si la lista esta vacia
            if (usuariosTop7Favoritos.size() == 0) {
                usuariosTop7Favoritos.add(user);
            } else if (usuariosTop7Favoritos.size() < 7) {
                usuariosTop7Favoritos.add(user);
                usuariosTop7Favoritos.sort(Comparator.comparing(User::getFavourites).reversed()); // Ordena la lista en orden descendente de favoritos
            } else {
                User minFavUser = usuariosTop7Favoritos.get(0); // comienza asumiendo que el primer usuario tiene los favoritos mínimos
                for (int k = 1; k < usuariosTop7Favoritos.size(); k++) {
                    User currentUser = usuariosTop7Favoritos.get(k); // obtén el usuario actual
                    if (currentUser.getFavourites() < minFavUser.getFavourites()) {
                        minFavUser = currentUser;
                    }
                }
                if (favoritos > minFavUser.getFavourites()) { // Solo si el nuevo usuario tiene más favoritos que el de menos en la lista actual
                    usuariosTop7Favoritos.delete(minFavUser);
                    usuariosTop7Favoritos.add(user);
                    usuariosTop7Favoritos.sort(Comparator.comparing(User::getFavourites).reversed()); // Ordena la lista en orden descendente de favoritos
                }
            }
        }
        return usuariosTop7Favoritos;
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
    public MyArrayList<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(MyArrayList<String> drivers) {
        this.drivers = drivers;
    }

}
