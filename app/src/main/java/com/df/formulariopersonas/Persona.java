package com.df.formulariopersonas;

public class Persona {
    String Nombre;
    String Apellido;
    String Cargo;
    String Email;
    int Edad;
    double Salario;

    public Persona(String nombre, String apellido, String cargo, String email, int edad, double salario) {
        Nombre = nombre;
        Apellido = apellido;
        Cargo = cargo;
        Email = email;
        Edad = edad;
        Salario = salario;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double salario) {
        Salario = salario;
    }
    @Override
    public String toString() {
        return
                "Nombre=" + Nombre +"\n"+
                "Apellido=" + Apellido + "\n" +
                "Cargo=" + Cargo + "\n" +
                "Email=" + Email + "\n" +
                "Edad=" + Edad + "\n" +
                "Salario=" + Salario;

    }
}
