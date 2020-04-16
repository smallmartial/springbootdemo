package cn.smallmartial.demo.service.impl;

import cn.smallmartial.demo.bean.RedisKeyPrefix;
import cn.smallmartial.demo.bean.ResponseCode;
import cn.smallmartial.demo.exception.ApiResult;
import cn.smallmartial.demo.exception.BusinessException;
import cn.smallmartial.demo.service.TokenService;
import cn.smallmartial.demo.utils.RedisUtil;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

/**
 * @Author smallmartial
 * @Date 2020/4/16
 * @Email smallmarital@qq.com
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private RedisUtil redisService;

    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString().replace("-", "");
        StringBuilder token = new StringBuilder();
        try {
            token.append(RedisKeyPrefix.TOKEN_PREFIX).append(str);
            redisService.setEx(token.toString(), token.toString(), 10000L);
            boolean empty = StringUtils.isEmpty(token.toString());
            if (!empty) {
                return token.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {

        String token = request.getHeader(RedisKeyPrefix.TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {// header中不存在token
            token = request.getParameter(RedisKeyPrefix.TOKEN_NAME);
            if (StringUtils.isEmpty(token)) {// parameter中也不存在token
                throw new BusinessException(ApiResult.BADARGUMENT);
            }
        }

        if (!redisService.exists(token)) {
            throw new BusinessException(ApiResult.REPETITIVE_OPERATION);
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new BusinessException(ApiResult.REPETITIVE_OPERATION);
        }
        return true;
    }
}
