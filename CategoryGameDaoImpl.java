package com.simulation.dao;

import com.simulation.entity.CategoryGame;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryGameDaoImpl implements DaoServices<CategoryGame> {
    @Override
    public List<CategoryGame> fetchAll() throws SQLException, ClassNotFoundException {
        List<CategoryGame> categoryGames = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT categoryID, name FROM category_game";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        CategoryGame categoryGame = new CategoryGame();
                        categoryGame.setCategoryID(rs.getInt("categoryID"));
                        categoryGame.setName(rs.getString("name"));

                        categoryGames.add(categoryGame);
                    }
                }
            }
        }
        return categoryGames;
    }
}
