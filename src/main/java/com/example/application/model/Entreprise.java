package com.example.application.model;

public class Entreprise {

    private String nom;

    private String siret;

    private String activité;


    public Entreprise(String nom, String siret, String activité) {
        this.nom = nom;
        this.siret = siret;
        this.activité = activité;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getActivité() {
        return activité;
    }

    public void setActivité(String activité) {
        this.activité = activité;
    }
}
