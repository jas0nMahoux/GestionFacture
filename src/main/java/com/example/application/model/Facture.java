package com.example.application.model;

public class Facture {

    private String nameArticle;

    private Float total;

    private String clientName;

    private int qte;


    public Facture(String nameArticle, Float total, String clientName, int qte) {
        this.nameArticle = nameArticle;
        this.total = total;
        this.clientName = clientName;
        this.qte = qte;
    }

    public String getLigneArticle() {
        return nameArticle;
    }

    public void setNameArticle(String nameArticle) {
        this.nameArticle = nameArticle;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /*public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }*/


    @Override
    public String toString() {
        return "Facture{" +
                "nameArticle=" + nameArticle +
                ", total=" + total +
                ", clientName=" + clientName +
                '}';
    }
}
