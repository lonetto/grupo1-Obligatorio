package entities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class SistemaCentral {


    public void leerCSV(String path) throws CsvValidationException, IOException, OutOfMemoryError {
        //int x = 0;
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String[] line;
        while((line = csvReader.readNext()) != null){
            agregarTodo(line);
        }
    }


    public void agregarTodo(String[] line){

        }
    }

