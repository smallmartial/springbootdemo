package cn.smallmartial.demo.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author smallmartial
 * @Date 2020/4/16
 * @Email smallmarital@qq.com
 */
public interface TokenService {

    /**
     * 创建token
     *
     * @return
     */
    public String createToken();

    /**
     * 检验token
     *
     * @param request
     * @return
     */
    public boolean checkToken(HttpServletRequest request) throws Exception;

}
