import entities.SistemaCentral;
import com.opencsv.exceptions.CsvValidationException;;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws CsvValidationException, IOException, ParseException {
        long inicio = System.currentTimeMillis();
        System.out.println("CARGANDO DATOS...");
        SistemaCentral manager = new SistemaCentral();
        manager.leerCSV("sources/f1_dataset_test.csv");
        System.out.println("DATOS CARGADOS CORRECTAMENTE");
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
        showMenu(manager);
    }


    public static void showMenu(SistemaCentral manager) throws ParseException {
        boolean mostrarMenu = true;
        int numeroIngresado;
        while(mostrarMenu) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1) Para listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes, presione 1");
            System.out.println("2) Para listar los 15 usuarios con mas tweets, presione 2");
            System.out.println("3) Para ver la cantidad de hashtags distintos para un dia dado, presione 3");
            System.out.println("4) Para ver el hashtag más usado para un día dado, sin tener en cuenta #f1, presione 4");
            System.out.println("5) Para listar el top 7 de cuentas con más favoritos, presione 5");
            System.out.println("6) Para ver la cantidad de tweets con una palabra o frase específicos, presione 6");
            System.out.println("7) Para cerrar el programa, presione 7");
            System.out.println("");

            try {
                numeroIngresado = Integer.parseInt(sc.nextLine());
            } catch (Exception e ){
                numeroIngresado = 0;
            }

            if (numeroIngresado == 1){

            }
            else if (numeroIngresado == 2){

            }
            else if (numeroIngresado == 3){

            }
            else if (numeroIngresado == 4){

            }
            else if (numeroIngresado == 5){

            }
            else if (numeroIngresado == 6){

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

    public static void report1 () {

    }


    public static void report2 () {

    }


    public static void report3 () {

    }


    public static void report4() {

    }


    public static void report5 () {

    }


    public static void report6() {

    }


}
