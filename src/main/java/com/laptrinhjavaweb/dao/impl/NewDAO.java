package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import model.CategoryModel;
import model.NewModel;

import javax.enterprise.inject.New;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news where categoryid = ? ";
        return Query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewModel newModel) {
        try {
            String sql = "INSERT  INTO news (title, content, categoryid) VALUES(?, ?, ?)";
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    }


