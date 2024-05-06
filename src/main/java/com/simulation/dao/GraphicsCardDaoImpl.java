package com.simulation.dao;

import com.simulation.entity.GraphicsCard;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GraphicsCardDaoImpl implements DaoServices<GraphicsCard> {
    @Override
    public List<GraphicsCard> fetchAll() throws SQLException, ClassNotFoundException {
        List<GraphicsCard> graphicsCards = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT * FROM graphics_card";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        GraphicsCard graphicsCard = new GraphicsCard();
                        graphicsCard.setGpuID(rs.getInt("gpuID"));
                        graphicsCard.setBrandID(rs.getInt("brandID"));
                        graphicsCard.setName(rs.getString("name"));
                        graphicsCard.setMemory(rs.getString("memory"));
                        graphicsCard.setCore(rs.getString("core"));
                        graphicsCard.setBus(rs.getString("bus"));
                        graphicsCard.setClock(rs.getString("clock"));
                        graphicsCard.setPower(rs.getString("power"));
                        graphicsCard.setBenchmark(rs.getString("3dmark"));

                        graphicsCards.add(graphicsCard);
                    }
                }
            }
        }
        return graphicsCards;
    }
}
