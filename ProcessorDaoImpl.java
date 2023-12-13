package com.simulation.dao;

import com.simulation.entity.Processor;
import com.simulation.util.DaoServices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessorDaoImpl implements DaoServices<Processor> {
    @Override
    public List<Processor> fetchAll() throws SQLException, ClassNotFoundException {
        List<Processor> processors = new ArrayList<>();
        try (Connection connection = DatabaseConnection.createConnection()) {
            String query = "SELECT * FROM processor";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Processor processor = new Processor();
                        processor.setCpuID(rs.getInt("cpuID"));
                        processor.setBrandID(rs.getInt("brandID"));
                        processor.setName(rs.getString("name"));
                        processor.setCore(rs.getString("core"));
                        processor.setClockSpeed(rs.getString("clockspeed"));
                        processor.setMemory(rs.getString("memory"));
                        processor.setL3Cache(rs.getString("l3cache"));
                        processor.setPower(rs.getString("power"));
                        processor.setBenchmark(rs.getString("benchmark"));

                        processors.add(processor);
                    }
                }
            }
        }
        return processors;
    }
}
