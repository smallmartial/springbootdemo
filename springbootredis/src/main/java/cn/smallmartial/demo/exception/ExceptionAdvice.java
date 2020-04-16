package cn.smallmartial.demo.exception;

import cn.smallmartial.demo.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author smallmartial
 * @Date 2019/9/23
 * @Email smallmarital@qq.com
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionAdvice {

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        return ResponseUtil.badArgument();
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error("不支持当前请求方法", e);
        return ResponseUtil.unsupport();
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedException(Exception e, HttpServletRequest request) {
        log.error("不支持当前请求方法", e);
        return ResponseUtil.unsupport();
    }

//    /**
//     * 500 - Internal Server Error
//     * 系统异常以506返回
//     */
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(Exception.class)
//    public Object handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
//        log.error(e.getMessage(), e);
//        if (e instanceof ExpiredJwtException) {
//            Map<String, Object> obj = new HashMap<String, Object>();
//            obj.put("errno", 506);
//            obj.put("errmsg", "系统异常");
//            log.error("权限不足", e);
//            return obj;
//        }
//        log.error("系统异常", e);
//        return ResponseUtil.serious();
//    }

    /**
     * 业务异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public Object handleException(BusinessException e) {
        log.error(e.getMessage(), e);
        ApiResult apiResult = e.getApiResult();
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", apiResult.getErrno());
        obj.put("errmsg", apiResult.getErrmsg());
        return obj;
    }


}