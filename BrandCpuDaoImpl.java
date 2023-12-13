package com.simulation.dao;

import com.simulation.entity.BrandCPU;
import com.simulation.util.DaoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandCpuDaoImpl implements DaoServices <BrandCPU> {

    @Override
    public List<BrandCPU> fetchAll() throws SQLException, ClassNotFoundException {
        List<BrandCPU> brandCPUS = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT brandID, name FROM brand_cpu";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        BrandCPU brandCPU = new BrandCPU();
                        brandCPU.setBrandID(rs.getInt("brandID"));
                        brandCPU.setName(rs.getString("name"));

                        brandCPUS.add(brandCPU);
                    }
                }
            }
        }
        return brandCPUS;
    }
}
