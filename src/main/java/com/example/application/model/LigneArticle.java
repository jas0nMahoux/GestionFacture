package com.example.application.model;

public class LigneArticle {

    private Article article;

    private int remise;

    private int quantite;

    public LigneArticle(Builder builder) {
        this.article = builder.article;
        this.remise = builder.remise;
        this.quantite = builder.quantite;
    }

    public static class Builder {

        private Article article;

        private int remise;

        private int quantite;

        public Builder setArticle(Article article) {
            this.article = article;
            return this;
        }

        public Builder setRemise(int remise) {
            this.remise = remise;
            return this;
        }

        public Builder setQuantite(int quantite) {
            this.quantite = quantite;
            return this;
        }

        public LigneArticle build() {
            return new LigneArticle(this);
        }
    }
}
