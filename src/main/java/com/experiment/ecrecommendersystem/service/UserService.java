package com.experiment.ecrecommendersystem.service;

import com.experiment.ecrecommendersystem.common.BusinessException;
import com.experiment.ecrecommendersystem.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface UserService {
    UserModel getUser(Integer id);

    UserModel register(UserModel userModel) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    UserModel login(String telphone,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;
}
