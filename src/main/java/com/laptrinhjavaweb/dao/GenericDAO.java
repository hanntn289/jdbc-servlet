package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> Query(String sql, RowMapper<T> rowMapper, Object...parameters);
}
