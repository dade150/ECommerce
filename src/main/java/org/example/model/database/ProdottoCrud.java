package org.example.model.database;

import org.example.model.entity.Prodotto;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdottoCrud implements ProdottoDao<Prodotto>{
    @Override
    public boolean insert(Prodotto entity) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"Prodotto\" (nome, descrizione, quantita, prezzo) VALUES (?,?,?,?);";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);

        ps.setString(1,entity.getNome());
        ps.setString(2,entity.getDescrizione());
        ps.setInt(3,entity.getQuantita());
        ps.setDouble(4, entity.getPrezzo());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean update(Prodotto entity) throws IOException, SQLException {
        String sql = "UPDATE public.\"Prodotto\" SET " +
                "nome=?, descrizione=?, quantita=?, prezzo=? " +
                "WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setString(1,entity.getNome());
        ps.setString(2,entity.getDescrizione());
        ps.setInt(3,entity.getQuantita());
        ps.setDouble(4, entity.getPrezzo());
        ps.setInt(5,entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean delete(Prodotto entity) throws IOException, SQLException {
        String sql = "DELETE FROM public.\"Prodotto\" WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public Optional<Prodotto> getById(int id) throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"Prodotto\" WHERE id=" + id + ";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ResultSet r = ps.executeQuery();
        Prodotto sede = new Prodotto();
        if(r.next()) sede = new Prodotto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getDouble(5));
        ch.closeConnection();
        ps.close();
        return Optional.of(sede);
    }

    @Override
    public List<Prodotto> getAll() throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"Prodotto\"";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        List<Prodotto> prodotti = new ArrayList<>();
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            prodotti.add(new Prodotto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4), r.getDouble(5)));
        }
        ch.closeConnection();
        ps.close();
        return prodotti;
    }

    @Override
    public Optional<Prodotto> acquista(int id, int quantita) throws IOException, SQLException {
        Prodotto prodotto = this.getById(id).orElse(null);
        if(prodotto!=null && prodotto.getQuantita()>=quantita){
            prodotto.setQuantita(prodotto.getQuantita()-quantita);
            this.update(prodotto);
        }
        return Optional.of(prodotto);
    }
    public static void test(String[] args) throws SQLException, IOException {
        ProdottoCrud crud = new ProdottoCrud();
        List<Prodotto> rs = crud.getAll();
        for (Prodotto r : rs) {
            System.out.println(r.getId());
        }
        System.out.println(crud.getById(1).orElse(null));
        Prodotto prodotto= new Prodotto(0,"carne","pollo",2,2.0);
        //System.out.println(crud.delete(prodotto));
        System.out.println(crud.insert(prodotto));
    }
}
