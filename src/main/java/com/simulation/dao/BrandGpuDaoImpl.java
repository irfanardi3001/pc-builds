package com.simulation.dao;

import com.simulation.entity.BrandGPU;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandGpuDaoImpl implements DaoServices<BrandGPU> {
    @Override
    public List<BrandGPU> fetchAll() throws SQLException, ClassNotFoundException {
        List<BrandGPU> brandGPUS = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT brandID, name FROM brand_gpu";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        BrandGPU brandGPU = new BrandGPU();
                        brandGPU.setBrandID(rs.getInt("brandID"));
                        brandGPU.setName(rs.getString("name"));

                        brandGPUS.add(brandGPU);
                    }
                }
            }
        }
        return brandGPUS;
    }
}
