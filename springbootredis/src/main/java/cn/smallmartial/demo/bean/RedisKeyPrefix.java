package cn.smallmartial.demo.bean;


public class RedisKeyPrefix {

    /**
     * 用户登录token
     */
    public static final String LOGIN_TOKEN_KEY_PREFIX = "user:login:";

    /**
     * 注册验证码
     */
    public static final String USER_REGISTER_PREFIX = "user:register:code:";

    /**
     * 忘记密码验证码
     */
    public static final String USER_FORGET_PWD_PREFIX = "user:forgetPwd:code:";

    /**
     * 修改密码
     */
    public static final String USER_UPDATE_PREFIX = "user:updatePwd:code:";
    /**
     * 绑定手机号类型
     */
    public static final String BIND_PHONE = "user:bindPhone:code:";

    /**
     * 接口token校验
     */
    public static final String TOKEN_PREFIX = "user:token:";

    /**
     * 请求头token名称
     */
    public static final String TOKEN_NAME = "access-token";
}
