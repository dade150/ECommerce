package org.example.controller;

import com.google.gson.Gson;
import org.example.model.database.ProdottoCrud;
import org.example.model.entity.Prodotto;
import org.example.util.HttpResponse;

import java.util.List;

import static spark.Spark.*;
public class ProdottoController {
    ProdottoCrud prodottoCrud = new ProdottoCrud();

    public void startServices() {
        // heartbeat
        get("/", (req, res) -> "System is working");

        get("/prodotti", (req, res) -> {
            List<Prodotto> result = prodottoCrud.getAll();
            HttpResponse response = new HttpResponse("200", "OK, stampa utenti", new Gson().toJsonTree(result));
            return new Gson().toJson(response);
        });

        get("/prodotto/:id", (req, res) -> {
            String id = req.params("id");
            Prodotto result = prodottoCrud.getById(Integer.parseInt(id)).orElse(null);
            HttpResponse response = new HttpResponse("200", "OK, stampa Prodotto", new Gson().toJsonTree(result));
            return new Gson().toJson(response);
        });

        post("/prodotto", (req, res) -> {
            Prodotto prodottoReq = new Gson().fromJson(req.body(), Prodotto.class);
            prodottoCrud.insert(prodottoReq);
            HttpResponse response = new HttpResponse("200", "OK, inserito Prodotto");
            return new Gson().toJson(response);
        });

        put("/prodotto", (req, res) -> {
            Prodotto prodottoReq = new Gson().fromJson(req.body(), Prodotto.class);
            prodottoCrud.update(prodottoReq);
            Prodotto ProdottoRes = prodottoCrud.getById(prodottoReq.getId()).orElse(null);
            HttpResponse response = new HttpResponse("200", "OK, aggiornato Prodotto", new Gson().toJsonTree(ProdottoRes));
            return new Gson().toJson(response);
        });

        delete("/prodotto", (req, res) -> {
            Prodotto prodottoReq = new Gson().fromJson(req.body(), Prodotto.class);
            prodottoCrud.delete(prodottoReq);
            return new Gson().toJson(new HttpResponse("200", "OK, Prodotto cancellato"));
        });

        get("/acquisto/:quantita", (req, res) -> {
            String quantita = req.params("quantita");
            Prodotto prodottoReq = new Gson().fromJson(req.body(), Prodotto.class);
            Prodotto result = prodottoCrud.acquista(prodottoReq.getId(),Integer.parseInt(quantita)).orElse(null);
            HttpResponse response = new HttpResponse("200", "OK, stampa Prodotto", new Gson().toJsonTree(result));
            return new Gson().toJson(response);
        });
    }
}
