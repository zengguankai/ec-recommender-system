package com.experiment.ecrecommendersystem.service;

import com.experiment.ecrecommendersystem.common.BusinessException;
import com.experiment.ecrecommendersystem.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    CategoryModel create(CategoryModel categoryModel) throws BusinessException;
    CategoryModel get(Integer id);
    List<CategoryModel> selectAll();
    Integer countAllCategory();

}
