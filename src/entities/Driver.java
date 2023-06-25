package entities;

public class Driver {

    private long id;
    private String name;
    private int mencionesEnRangoFecha = 0;

    public Driver(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMencionesEnRangoFecha() {
        return mencionesEnRangoFecha;
    }

    public void setMencionesEnRangoFecha(int mencionesEnRangoFecha) {
        this.mencionesEnRangoFecha = mencionesEnRangoFecha;
    }

    public void resetMencionesEnRangoFecha() {
        this.mencionesEnRangoFecha=0;
    }
}