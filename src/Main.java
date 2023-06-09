import entities.*;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;
import uy.edu.um.prog2.adt.tads.Hash.MyHash;
import uy.edu.um.prog2.adt.tads.Heap.MyHeap;
import uy.edu.um.prog2.adt.tads.Heap.MyHeapImpl;
import uy.edu.um.prog2.adt.tads.Heap.exceptions.EmptyHeapException;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;
import com.opencsv.exceptions.CsvValidationException;;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws CsvValidationException, IOException, ParseException, EmptyHeapException {
        long inicio = System.currentTimeMillis();
        System.out.println("CARGANDO DATOS...");
        SistemaCentral manager = new SistemaCentral();
        manager.leerCSV("sources/f1_dataset.csv");
        System.out.println("DATOS CARGADOS CORRECTAMENTE");
        manager.cargarPilotos();
        long fin = System.currentTimeMillis();
        System.out.println("Duracion de carga: " + (fin-inicio) + " milisegundos");
        showMenu(manager);
    }


    public static void showMenu(SistemaCentral manager) throws ParseException, EmptyHeapException {
        boolean mostrarMenu = true;
        int numeroIngresado;
        while(mostrarMenu) {
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Binvenidos a la Base de Datos de tweets sobre Formula 1");
            System.out.println("");
            System.out.println("1) Para listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes, presione 1");
            System.out.println("2) Para listar los 15 usuarios con mas tweets, presione 2");
            System.out.println("3) Para ver la cantidad de hashtags distintos para un dia dado, presione 3");
            System.out.println("4) Para ver el hashtag más usado para un día dado, sin tener en cuenta #f1, presione 4");
            System.out.println("5) Para listar el top 7 de cuentas con más favoritos, presione 5");
            System.out.println("6) Para ver la cantidad de tweets con una palabra o frase específicos, presione 6");
            System.out.println("7) Para cerrar el programa, presione 7");
            System.out.println("");
            System.out.println("Ingrese la opcion deseada: ");

            try {
                numeroIngresado = Integer.parseInt(sc.nextLine());
            } catch (Exception e ){
                numeroIngresado = 0;
            }

            if (numeroIngresado == 1){
                report1(manager);

            }
            else if (numeroIngresado == 2){
                report2(manager);
            }
            else if (numeroIngresado == 3){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Por favor, ingresa la fecha en el formato YYYY-MM-DD");
                String inputDate = scanner.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                date = formatter.parse(inputDate);
                System.out.println("Fecha ingresada: "+date+ " anio: " + date.getYear() +" mes: "+ date.getMonth() + " dia: "+ date.getDay());
                int res = report3(manager, date);
                System.out.println("La cantidad de hashtags distintos usados el " + date +" es: "+ res );
            }
            else if (numeroIngresado == 4){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Por favor, ingresa la fecha en el formato YYYY-MM-DD");
                String inputDate = scanner.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = null;
                date = formatter.parse(inputDate);
                System.out.println("La fecha ingresada es: " + date);
                String mostUsedHashtag = report4(date, manager);
                System.out.println("El hashtag más usado para la fecha ingresada es: " + mostUsedHashtag);
            }
            else if (numeroIngresado == 5){
                report5(manager);
            }
            else if (numeroIngresado == 6){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese la frase o palabra que desea buscar:");
                String frase = scanner.nextLine();

                report6(manager, frase);
            }
            else if (numeroIngresado == 7){
                mostrarMenu = false;
                System.out.println("Fin del programa.");
            }
            else{
                System.out.println("Ingrese un número adecuado.");
            }

        }

    }



    public static void report1 (SistemaCentral manager) {

        //Permito ingresar los parametros de mes y año en la forma que se especifica en la letra
        System.out.println("10 pilotos mas mencionados en un determinado mes");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el año (2021 o 2022) para el que desea cosnultar: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el mes (1 - 12) para el que desea consultar: ");
        int mes = Integer.parseInt(sc.nextLine());
        if(!(año == 2021 || año == 2022) || mes > 12 || mes < 1){
            System.out.println("El año y/o mes ingresado es incorrecto");
            return;
        }

        MyArrayList<Driver> x = manager.obtenerPilotos10MasMencionadosEnTweetsPorMesYAño(mes, año);
        for(int i = 0; i < (x.size() - 10); i++){
            System.out.println("En el puesto numero " + (i+1) + ":");
            System.out.println("-->Piloto: " + x.get(i).getName());
            System.out.println("-->Menciones en tweets: " + x.get(i).getMencionesEnRangoFecha());
        }

    }
    public static void report2(SistemaCentral manager) throws EmptyHeapException {
        long inicio = System.currentTimeMillis();
        MyArrayList<User> x = manager.lista15UsuariosConMasTweets();
        for(int i = 0; i < x.size(); i++){
            System.out.println("En el puesto numero " + (i + 1) + ":");
            System.out.println("-->Usuario: " + x.get(i).getName());
            System.out.println("-->Tweets: " + x.get(i).tweets.size());
            System.out.println("-->Verificado: " + x.get(i).isVerified());
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion de la consulta: " + (fin-inicio) + "milisegundos");
    }

    public static int report3(SistemaCentral manager, Date fecha) {
        MyHash<String,HashTag> hashtagsunicos = new MyClosedHashImpl();
        for(int i=0; i<manager.getHashTweets().size();i++){
            long keytweet = manager.getHashTweets().getListaDeKeys().get(i);
            Tweet tweet = manager.getHashTweets().get(keytweet);
            Date date = tweet.getDate();
            if (date.getYear() == fecha.getYear() && date.getMonth() == fecha.getMonth() && date.getDay() == fecha.getDay()){
                for(int j=0; j<tweet.getHashtags().size();j++){
                    HashTag hashtag = tweet.getHashtags().get(j);
                    if(hashtagsunicos.get(hashtag.getText())==null){
                        hashtagsunicos.put(hashtag.getText(), hashtag);
                    }
                }
            }
        }
        return hashtagsunicos.size();
    }


    public static String report4(Date date, SistemaCentral manager) {
        long inicio = System.currentTimeMillis();
        int count = 0;
        int maxCount = 0;
        HashTag mostUsed = null;
        for (int i = 0; i < manager.getHashHashtag().size(); i++) {
            HashTag hashtag = manager.getHashHashtag().get(manager.getHashHashtag().getListaDeKeys().get(i));
            if (hashtag.getText().strip().toUpperCase().contains("F1")) {
                for (int j = 0; j < hashtag.getTweets().size(); j++) {
                    if (hashtag.getTweets().get(j).checkDate(date)) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    mostUsed = hashtag;
                }
            }
        }
        // Asegurarse de que mostUsed no es null antes de intentar acceder a su método getText
        if (mostUsed == null) {
            long fin = System.currentTimeMillis();
            System.out.println("Tiempo de ejecucion de la consulta: " + (fin-inicio) + "milisegundos");
            return "No se encontró un hashtag más usado para la fecha dada";
        } else {
            long fin = System.currentTimeMillis();
            System.out.println("");
            System.out.println("Tiempo de ejecucion de la consulta: " + (fin-inicio) + "milisegundos");
            return mostUsed.getText();
        }
    }


    public static void report5 (SistemaCentral manager) {
        long inicio = System.currentTimeMillis();
        MyArrayList<User> x = manager.lista7UsuariosConMasFavoritos();
        for(int i = 0; i < x.size(); i++){
            System.out.println("En el puesto numero " + (i+1) + ":");
            System.out.println("-->Usuario: " + x.get(i).getName());
            System.out.println("-->Favoritos: " + x.get(i).getFavourites());
        }
        long fin = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Tiempo de ejecucion de la consulta: " + (fin-inicio) + "milisegundos");
    }



    public static void report6(SistemaCentral manager, String frase) {
        long inicio = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < manager.getHashTweets().size(); i++) {
            Tweet tweet = manager.getHashTweets().get(manager.getHashTweets().getListaDeKeys().get(i));
            if (tweet.getContent().toUpperCase().contains(frase.toUpperCase())) {
                count++;
            }
        }
        System.out.println("La cantidad de tweets con la frase \"" + frase + "\" es: " + count);
        long fin = System.currentTimeMillis();
        System.out.println("");
        System.out.println("Tiempo de ejecucion de la consulta: " + (fin-inicio) + "milisegundos");
    }
}
