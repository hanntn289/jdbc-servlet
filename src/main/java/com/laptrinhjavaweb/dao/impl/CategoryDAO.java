package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.mysql.jdbc.Driver;
import model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return Query(sql, new CategoryMapper());
    }
    }



