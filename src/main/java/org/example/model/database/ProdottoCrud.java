package org.example.model.database;

import org.example.model.entity.Prodotto;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProdottoCrud implements ProdottoDao<Prodotto>{
    @Override
    public boolean insert(Prodotto entity) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"Prodotto\" VALUES (?,?,?,?);";
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
        return false;
    }

    @Override
    public boolean delete(Prodotto entity) throws IOException, SQLException {
        return false;
    }

    @Override
    public Optional<Prodotto> getById(int id) throws IOException, SQLException {
        return Optional.empty();
    }

    @Override
    public List<Prodotto> getAll() throws IOException, SQLException {
        return null;
    }

    @Override
    public Optional<Prodotto> acquista(int id, int quantita) throws IOException, SQLException {
        return Optional.empty();
    }
}
