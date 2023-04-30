package com.laptrinhjavaweb.service;

import model.NewModel;

import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryId);
    NewModel save(NewModel newModel);
}
