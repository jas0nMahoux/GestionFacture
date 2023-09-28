package com.example.application.model;

public class Facture {

    private LigneArticle ligneArticle;

    private double total;

    private Client client;

    private Entreprise entreprise;

    public Facture(LigneArticle ligneArticle, double total, Client client, Entreprise entreprise) {
        this.ligneArticle = ligneArticle;
        this.total = total;
        this.client = client;
        this.entreprise = entreprise;
    }

    public LigneArticle getLigneArticle() {
        return ligneArticle;
    }

    public void setLigneArticle(LigneArticle ligneArticle) {
        this.ligneArticle = ligneArticle;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }


    @Override
    public String toString() {
        return "Facture{" +
                "ligneArticle=" + ligneArticle +
                ", total=" + total +
                ", client=" + client +
                ", entreprise=" + entreprise +
                '}';
    }
}
