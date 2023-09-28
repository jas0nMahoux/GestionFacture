package com.example.application.services;

import com.example.application.model.Article;
import com.example.application.model.Client;
import com.example.application.repository.ArticleDao;
import com.example.application.repository.ClientDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    public ClientDao clientDao = new ClientDao();

    public List<Client> findAllClient() {
        return clientDao.findAll();
    }

    public void createNewClient(String nom, String prenom, long numTel) {
        clientDao.insertClient(nom, prenom, numTel);
    }

}
