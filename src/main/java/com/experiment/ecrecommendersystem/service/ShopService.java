package com.experiment.ecrecommendersystem.service;

import com.experiment.ecrecommendersystem.common.BusinessException;
import com.experiment.ecrecommendersystem.model.ShopModel;

import java.util.List;

public interface ShopService {
    ShopModel create(ShopModel shopModel) throws BusinessException;

    ShopModel get(Integer id);
    List<ShopModel> selectAll();
    Integer countAllShop();
}
