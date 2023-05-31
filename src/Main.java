import entities.SistemaCentral;
import com.opencsv.exceptions.CsvValidationException;;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws CsvValidationException, IOException, ParseException {
        long inicio = System.currentTimeMillis();
        System.out.println("CARGANDO DATOS...");
        SistemaCentral manager = new SistemaCentral();
        manager.leerCSV("beer_dataset_full.csv");
        System.out.println("DATOS CARGADOS CORRECTAMENTE");
        long fin = System.currentTimeMillis();
        System.out.println(fin-inicio + " milisegundos");
        showMenu(manager);
    }


    public static void showMenu(SistemaCentral manager){

    }

}
