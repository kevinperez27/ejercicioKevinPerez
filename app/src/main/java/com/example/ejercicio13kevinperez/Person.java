package com.example.ejercicio13kevinperez;

public class Person {
    private String nombre;
    private String apellidos;
    private int edad;
    private String correo;
    private String direccion;

    public Person(String nombre, String apellidos, int edad, String correo, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }
}
