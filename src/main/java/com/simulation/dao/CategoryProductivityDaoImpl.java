package com.simulation.dao;

import com.simulation.entity.CategoryProductivity;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryProductivityDaoImpl implements DaoServices<CategoryProductivity> {
    @Override
    public List<CategoryProductivity> fetchAll() throws SQLException, ClassNotFoundException {
        List<CategoryProductivity> categoryProductivities = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT categoryID, name FROM category_productivty";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        CategoryProductivity categoryProductivity = new CategoryProductivity();
                        categoryProductivity.setCategoryID(rs.getInt("categoryID"));
                        categoryProductivity.setName(rs.getString("name"));

                        categoryProductivities.add(categoryProductivity);
                    }
                }
            }
        }
        return categoryProductivities;
    }
}
