package entities;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Calendar;
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
    private MyHash<String, HashTag> hashHashtag = new MyClosedHashImpl<>(50000);
    private MyHash<Long, Driver> hashDrivers = new MyClosedHashImpl<>(21);
    private long idUsers = 1;
    private long idHashtag = 1;
    private long idDriver = 1;


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
                String pilotName = scanner.nextLine();

                // Crea una nueva instancia del piloto con su id y nombre
                Driver pilot = new Driver(idDriver, pilotName);

                // Almacena el piloto en el mapa con su id como clave
                hashDrivers.put(idDriver, pilot);

                // Incrementa el idDriver para el siguiente piloto
                idDriver++;
            }

            // Cerrar el escáner para liberar recursos
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

        //System.out.println(hashDrivers.size());
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
            String source = line[12];
            boolean is_retweet = Boolean.parseBoolean(line[13]);

            //Agregar las funciones
            User user = agregarUser(user_name, user_location, user_description, user_created, user_followers, user_friends, user_favourites, user_verified);
            Tweet tweet = agregarTweet(tweet_id, date, text, source, is_retweet, user);
            if (!hashtag.isEmpty()) {
                hashtag = hashtag.substring(1, hashtag.length() - 1);
                hashtag = hashtag.replace("'", "");
                String[] hashtags = hashtag.split(",");
                for (String element : hashtags) { //hacemos un for each
                    agregarHashtag(element);
                    HashTag hashtag1 = new HashTag(idHashtag, element);
                    tweet.addHashTag(hashtag1);
                }
            }
        } catch (Exception e){
            //Algunas lineas estan mal redactadas, por lo que no se pueden parsear asi que se ignoran ya que son muy pocas
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

    public Tweet agregarTweet(long tweet_id, Date date, String content, String source, boolean is_retweet, User user) {
        Tweet tweet;
        if (!existeTweet(tweet_id)) {
            tweet = new Tweet(tweet_id, date, content, source, is_retweet, user);
            hashTweets.put(tweet_id, tweet);
            user.addTweet(tweet);
        }
        return hashTweets.get(tweet_id);
    }

    public boolean existeTweet(long tweet_id){
        return (hashTweets.get(tweet_id)!= null);
    }

    public void agregarHashtag(String text){
        HashTag hashtag1 = existeHashtag(text);
        if(hashtag1 == null){
            hashtag1 = new HashTag(idHashtag, text);
            hashHashtag.put(text, hashtag1);
            idHashtag++;
        }
    }

    public HashTag existeHashtag(String nombreHashtag){
        return (hashHashtag.get(nombreHashtag));
    }

    //Report 1
    public MyArrayList<Driver> obtenerPilotos10MasMencionadosEnTweetsPorMesYAño(int mes, int año) {

        // Restablecer las menciones para cada piloto antes de comenzar el conteo
        for(int l = 0; l < hashDrivers.size(); l++ ) {
            Long driverKey = hashDrivers.keyListaKeys(l);
            Driver driver = hashDrivers.get(driverKey);
            driver.resetMencionesEnRangoFecha();
        }

        MyArrayList<Driver> pilotosMasMencionados = new MyArrayListImpl<>(21);

        //String fechaString= año + "-" + mes + "-01";
        //System.out.println(fechaString);

        // Crear una instancia de Calendar
        Calendar calendar = Calendar.getInstance();

        // Establecer el año, mes y día del objeto Calendar.
        calendar.set(año, (mes + 1), 1);
        // Convertir el objeto Calendar a un objeto Date
        Date date = calendar.getTime();

        //Creo un arraylist en el cual estaran los tweets filtrados
        MyLinkedList<Tweet> tweetsFiltrados = new MyLinkedListImpl<>();

        for(int i = 0; i < hashTweets.size(); i++){
            Long tweetKey = hashTweets.keyListaKeys(i);
            Tweet tweet = hashTweets.get(tweetKey);
            Date fechaTweet = tweet.getDate();

            Calendar cal2 = Calendar.getInstance();
            calendar.setTime(date);
            cal2.setTime(fechaTweet);
            if( ( calendar.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) ) && ( calendar.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) ) {
                tweetsFiltrados.add(tweet);
            }
        }

        for(int j = 0; j < hashDrivers.size(); j++ ) {
            Long driverKey = hashDrivers.keyListaKeys(j);
            Driver driver = hashDrivers.get(driverKey);
            String nombrePiloto = driver.getName();


            for(int k = 0; k < tweetsFiltrados.size(); k++ ){
                Tweet tweet = tweetsFiltrados.get(k);
                if(tweet.getContent().contains(nombrePiloto)){
                    driver.setMencionesEnRangoFecha(driver.getMencionesEnRangoFecha() + 1);
                }
            }

            pilotosMasMencionados.add(driver);
        }

        pilotosMasMencionados.sort((d1, d2) -> Integer.compare(d2.getMencionesEnRangoFecha(), d1.getMencionesEnRangoFecha()));

        return pilotosMasMencionados;
    }
    public void agregarTweetsEnHashtag(){
    /*
    for(int k = 0; k< hashHashtag.size(); k++){
        String hashtagKey = hashHashtag.keyListaKeys(k);
        HashTag hashtag = hashHashtag.get(hashtagKey);
        hashtag.
    }

     */


        for(int j = 0; j< hashHashtag.size(); j++) {
            String hashtagKey = hashHashtag.keyListaKeys(j);
            HashTag hashtag = hashHashtag.get(hashtagKey);
            String nombreHashtag = hashtag.getText();

            for (int i = 0; i < hashTweets.size(); i++) {
                Long tweetsKey = hashTweets.keyListaKeys(i);
                Tweet tweet = hashTweets.get(tweetsKey);

                if(tweet.getContent().contains(nombreHashtag)) {
                    hashtag.addTweet(tweet);
                }
            }
        }
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

    public MyHash<String, HashTag> getHashHashtag() {
        return hashHashtag;
    }

    public void setHashHashtag(MyHash<String, HashTag> hashHashtag) {
        this.hashHashtag = hashHashtag;
    }

    public MyHash<Long, Driver> getHashDrivers() {
        return hashDrivers;
    }

    public void setHashDrivers(MyHash<Long, Driver> hashDrivers) {
        this.hashDrivers = hashDrivers;
    }
}
