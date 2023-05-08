package com.experiment.ecrecommendersystem.controller.admin;

import com.experiment.ecrecommendersystem.common.AdminPermission;
import com.experiment.ecrecommendersystem.common.BusinessException;
import com.experiment.ecrecommendersystem.common.EmBusinessError;
import com.experiment.ecrecommendersystem.service.CategoryService;
import com.experiment.ecrecommendersystem.service.SellerService;
import com.experiment.ecrecommendersystem.service.ShopService;
import com.experiment.ecrecommendersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Controller("/admin/admin")
@RequestMapping("/admin/admin")
public class AdminController {
    public static final String CURRENT_ADMIN_SESSION = "currentAdminSession";

    // 由application.properties配置
    @Value("${admin.email}")
    private String email;
    @Value("${admin.encrptyPassword}")
    private String encrptyPassword;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ShopService shopService;


    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index");

        //th
        //sidebar中匹配
        modelAndView.addObject("CONTROLLER_NAME","admin");
        modelAndView.addObject("ACTION_NAME","index");

        //index
        modelAndView.addObject("userCount",userService.countAllUser());
        modelAndView.addObject("shopCount",shopService.countAllShop());
        modelAndView.addObject("categoryCount",categoryService.countAllCategory());
        modelAndView.addObject("sellerCount",sellerService.countAllSeller());
        return modelAndView;
    }

    @RequestMapping("/loginpage")
    public ModelAndView loginpage(){
        ModelAndView modelAndView = new ModelAndView("/admin/admin/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"用户名密码不能为空");
        }

        if (email.equals(this.email) && encodeByMd5(password).equals(this.encrptyPassword)){
            httpServletRequest.getSession().setAttribute(CURRENT_ADMIN_SESSION,email);
            return "redirect:/admin/admin/index";
        }else {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"用户名密码错误");
        }
    }




    private String encodeByMd5(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
    }


}
