package com.zhuihoude.girl.controll;

import com.zhuihoude.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//@Controller
//@ResponseBody 用下面的
@RestController
@RequestMapping("/girl")
public class HelloController {

//    @Value("${cupSize}") //配置单个属性的获取
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value(("${content}"))
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping("hello")
    ///hello
    public String say(HttpServletRequest request){

        request.getRemoteAddr();
        request.getHeader("x-forwarded-for");

        System.out.println(request.getRemoteAddr()+request.getHeader("x-forwarded-for"));
        return "request.getRemoteAddr:"+request.getRemoteAddr()+","+"request.getHeader:"+request.getHeader("x-forwarded-for");

    }

    @RequestMapping(value = {"/hello1/{id}"},method = RequestMethod.GET) //不写GET POST都可以
    ///hello1/123
    public String say1(@PathVariable("id") Integer id){
        System.out.println("hello1");
        return "ID = "+ id + " | " + girlProperties.getContent();
    }


    //@RequestMapping(value = {"/hello2"},method = RequestMethod.GET) //不写GET POST都可以
    @GetMapping("hello2")
    ///hello2/?id=1
    public String say2(@RequestParam(value="id",required = false, defaultValue = "0") Integer id){
        System.out.println("hello2");
        return "ID = "+ id + " | " + girlProperties.getContent();
    }

}