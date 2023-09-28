package com.example.application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "article")
public class Article {

    @Id
    private int id;

    private String nom;

    private float prix;

    public Article(Builder builder) {
        this.id = builder.id;
        this.nom = builder.nom;
        this.prix = builder.prix;
    }

    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Article{" +
                "nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }

    public static class Builder {

        private int id;

        private String nom;

        private float prix;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder setPrix(float prix) {
            this.prix = prix;
            return this;
        }

        public Article build() {
            return new Article(this);
        }

    }



}
