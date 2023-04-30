package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.service.INewService;
import model.NewModel;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {
    @Inject
    INewDAO newDAO;

    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        return null;
    }

}
