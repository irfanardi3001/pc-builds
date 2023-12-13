package com.simulation.dao;

import com.simulation.entity.Software;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SoftwareDaoImpl implements DaoServices<Software> {
    @Override
    public List<Software> fetchAll() throws SQLException, ClassNotFoundException {
        List<Software> softwares = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT productivityID,categoryID,name FROM productivity";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Software software = new Software();
                        software.setProductivityID(rs.getInt("productivityID"));
                        software.setCategoryID(rs.getInt("categoryID"));
                        software.setName(rs.getString("name"));

                        softwares.add(software);
                    }
                }
            }
        }
        return softwares;
    }
}
