package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/newservlet12month2018";
            String user = "root";
            String password = "24092001";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <T1> List<T1> Query(String sql, RowMapper<T1> rowMapper, Object... parameters) {
        List<T1> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, parameters);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try{
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int Index = i + 1;
                if (parameter instanceof Long) {
                    //instance of: trong trường hợp
                    statement.setLong(Index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(Index, (String) parameter);
                }
            }
        }catch(SQLException e){
                e.printStackTrace();
            }


    }
}
