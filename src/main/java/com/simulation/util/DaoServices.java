package com.simulation.util;

import java.sql.SQLException;
import java.util.List;

public interface DaoServices <T> {
    List<T> fetchAll() throws SQLException, ClassNotFoundException;
}
