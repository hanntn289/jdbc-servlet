package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.service.ICategoryService;
import model.CategoryModel;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
//nhúng theo kiểu cũ
//mỗi class phải public một lần nên dài dòng:
//    private ICategoryDAO categoryDao;
//    public CategoryService(){
//        categoryDao = new CategoryDAO();

//Dùng inject ngắn gọn hơn
    @Inject
    //chỉ việc khởi tạo một dòng duy nhất
    //các hàm ở trong class nào thì hệ thống tự tìm
    private ICategoryDAO categoryDao;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }
}
