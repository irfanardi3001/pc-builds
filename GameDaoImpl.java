package com.simulation.dao;

import com.simulation.entity.Game;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements DaoServices<Game> {
    @Override
    public List<Game> fetchAll() throws SQLException, ClassNotFoundException {
        List<Game> games = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT gameID,categoryID,name FROM game";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Game game = new Game();
                        game.setGameID(rs.getInt("gameID"));
                        game.setCategoryID(rs.getInt("categoryID"));
                        game.setName(rs.getString("name"));

                        games.add(game);

                    }
                }
            }
        }
        return games;
    }
}
