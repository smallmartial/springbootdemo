package cn.smallmartial.quartz.service.imp;

import cn.smallmartial.quartz.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author smallmartial
 * @Date 2020/4/19
 * @Email smallmarital@qq.com
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public void test() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("hello serive...."+uuid);
    }
}
