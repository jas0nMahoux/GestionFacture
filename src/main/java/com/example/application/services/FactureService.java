package com.example.application.services;

import com.example.application.model.Facture;
import com.example.application.repository.FactureDao;

import java.util.List;

public class FactureService {

    public FactureDao factureDao = new FactureDao();

    public List<Facture> findAllFactures() {
        return factureDao.findAll();
    }

    public void createNewFacture(String nomArticle, Float totalPrice, String nameClient, int qte) {
        factureDao.insertFacture(nomArticle, totalPrice, nameClient, qte);
    }


}
