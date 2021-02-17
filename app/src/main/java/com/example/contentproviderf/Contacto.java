package com.example.contentproviderf;

public class Contacto {
    private int id;
    private String Nomnbre,apellido,telefono;

    public Contacto(int id, String nomnbre, String apellido, String telefono) {
        this.id = id;
        Nomnbre = nomnbre;
        this.apellido = apellido;
        this.telefono = telefono;
    }
    public Contacto(String nomnbre, String apellido, String telefono) {
        Nomnbre = nomnbre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomnbre() {
        return Nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        Nomnbre = nomnbre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
