package com.experiment.ecrecommendersystem.service.Impl;

import com.experiment.ecrecommendersystem.common.BusinessException;
import com.experiment.ecrecommendersystem.common.EmBusinessError;
import com.experiment.ecrecommendersystem.dal.CategoryModelMapper;
import com.experiment.ecrecommendersystem.dal.SellerModelMapper;
import com.experiment.ecrecommendersystem.dal.ShopModelMapper;
import com.experiment.ecrecommendersystem.model.CategoryModel;
import com.experiment.ecrecommendersystem.model.SellerModel;
import com.experiment.ecrecommendersystem.model.ShopModel;
import com.experiment.ecrecommendersystem.service.CategoryService;
import com.experiment.ecrecommendersystem.service.SellerService;
import com.experiment.ecrecommendersystem.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopModelMapper shopModelMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SellerService sellerService;

    @Override
    public ShopModel create(ShopModel shopModel) throws BusinessException {
        shopModel.setCreatedAt(new Date());
        shopModel.setUpdatedAt(new Date());

        //检查商家是否存在,是否禁用
        SellerModel sellerModel = sellerService.get(shopModel.getSellerId());
        if (sellerModel ==null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"商家不存在");
        }

        if (sellerModel.getDisabledFlag() == 1){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"商家已禁用");
        }

        //检查品类是否存在
        CategoryModel categoryModel = categoryService.get(shopModel.getCategoryId());
        if (categoryModel == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"品类不存在");
        }
        shopModelMapper.insertSelective(shopModel);

        return get(shopModel.getId());
    }

    @Override
    public ShopModel get(Integer id) {
        ShopModel shopModel = shopModelMapper.selectByPrimaryKey(id);
        if (shopModel == null){
            return null;
        }

        shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        return shopModel;
    }

    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModels = shopModelMapper.selectAll();
        shopModels.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getSellerId()));
        });
        return shopModels;
    }

    @Override
    public Integer countAllShop() {
        return shopModelMapper.countAllShop();
    }

    @Override
    public List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude) {
        List<ShopModel> shopModelList = shopModelMapper.recommend(longitude, latitude);
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }

    @Override
    public List<ShopModel> search(BigDecimal longitude, BigDecimal latitude, String keyword,
                                  Integer orderby,Integer categoryId,String tags) {
        List<ShopModel> shopModelList = shopModelMapper.search(longitude, latitude, keyword,orderby,categoryId,tags);
        shopModelList.forEach(shopModel -> {
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        });
        return shopModelList;
    }

    @Override
    public List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags) {
        return shopModelMapper.searchGroupByTags(keyword,categoryId,tags);
    }
}
