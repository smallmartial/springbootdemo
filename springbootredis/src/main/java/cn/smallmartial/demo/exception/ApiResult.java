package cn.smallmartial.demo.exception;

/**
 * @Author smallmartial
 * @Date 2019/9/23
 * @Email smallmarital@qq.com
 */
public enum ApiResult {
    /**
     * 自定义异常
     */
    SEND_CODE_FAIL(101,"发送失败"),
    CHECK_CODE_FAIL(102, "验证码错误"),
    UNAUTHZ(506,"权限不足"),
    BADARGUMENT(401,"参数不对"),
    TAG_EXIST(600,"不能创建相同父节标签"),
    TAG_IS_NOT_MODIFY(601,"含有二级标签，不能修改"),
    TAG_IS_NOT_DELETE(601,"含有二级标签，不能删除"),
    INDEX_IS_NOT_DELETE(603,"含有子模块,无法删除"),
    ACTIVE_IS_NOT_DELETE(604,"活动时间未结束,无法删除"),
    SYSTEM_IS_NOT_DELETE(605,"系统预留板块，无法删除"),
    ALREADY_REGISTER(701,"该手机号已注册，请登录"),
    USER_NOT_EXIST(801,"未找到用户信息，请注册"),
    REPETITIVE_OPERATION(801,"重复性操作"),
    PASSWORD_ERROR(802,"密码错误"),
    ;


    private Integer errno;

    private String errmsg;

    ApiResult(Integer errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
