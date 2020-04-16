package cn.smallmartial.demo.web;

import cn.smallmartial.demo.annotation.AutoIdempotent;
import cn.smallmartial.demo.service.TokenService;
import cn.smallmartial.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author smallmartial
 * @Date 2020/4/16
 * @Email smallmarital@qq.com
 */
@RestController
public class BusinessController {


    @Autowired
    private TokenService tokenService;

    @GetMapping("/get/token")
    public Object  getToken(){
        String token = tokenService.createToken();
        return ResponseUtil.ok(token) ;
    }


    @AutoIdempotent
    @GetMapping("/test/Idempotence")
    public Object testIdempotence() {
        String token = "接口幂等性测试";
        return ResponseUtil.ok(token) ;
    }
}