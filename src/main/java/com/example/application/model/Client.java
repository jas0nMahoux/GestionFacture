package com.example.application.model;

public class Client {

    private String nom;

    private String prenom;

    private double numeroTelephone;


    public Client(String nom, String prenom, double numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTelephone = numeroTelephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(double numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
