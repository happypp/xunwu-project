package com.happy.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: Administrator
 * @CreateDate: 22:11 2018/7/28
 */
@Controller
public class AppErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    /**
     * @Author: Administrator
     * @Desc: web页面处理
     * @Date: 2018/7/28 22:14
    */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        int status = response.getStatus();
//        int status1 = getStatus(request);
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "index";
    }

    /**
     * @Author: Administrator
     * @Desc: 除web页面外的错误处理，比如：json/xml等
     * @Date: 2018/7/28 22:21
    */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public ApiResponse errorHandler(HttpServletRequest request,HttpServletResponse response){
//        int status1 = response.getStatus();
        RequestAttributes attributes = new ServletRequestAttributes(request);
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(attributes, false);
        int status = getStatus(request);
        return ApiResponse.ofMessage(status,String.valueOf(errorAttributes.getOrDefault("message","error")));
    }

    /**
     * @Author: Administrator
     * @Desc: 获取错误状态码
     * @Date: 2018/7/28 22:28
    */
    private int getStatus(HttpServletRequest request) {
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(status != null){
            return status;
        }
        return 500;
    }

}
