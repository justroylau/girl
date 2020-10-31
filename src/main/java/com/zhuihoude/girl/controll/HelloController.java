package com.zhuihoude.girl.controll;

import com.zhuihoude.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody 用下面的
@RestController
//@RequestMapping("/girl")
public class HelloController {

//    @Value("${cupSize}") //配置单个属性的获取
//    private String cupSize;
//    @Value("${age}")
//    private Integer age;
//    @Value(("${content}"))
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello1/{id}"},method = RequestMethod.GET) //不写GET POST都可以
    public String say1(@PathVariable("id") Integer id){
        System.out.println("hello1");
        return "ID = "+ id + " | " + girlProperties.getContent();
    }
//    @RequestMapping(value = {"/hello2"},method = RequestMethod.GET) //不写GET POST都可以
    @GetMapping("hello2")
//  public String say2(@RequestParam("id") Integer id){
    //required 是否必传 ，defaultValue默认值
    public String say2(@RequestParam(value="id",required = false, defaultValue = "0") Integer id){
        System.out.println("hello2");
        return "ID = "+ id + " | " + girlProperties.getContent();
    }

}