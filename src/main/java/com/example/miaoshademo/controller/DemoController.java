package com.example.miaoshademo.controller;

import com.example.miaoshademo.result.CodeMsg;
import com.example.miaoshademo.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    //Controller中两种类型的方法：1、rest api json输出；2、页面

    @ResponseBody
    @RequestMapping("/")
    public String home(){
        return "Welcome SpringBoot!";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public Result<String> hello(){
        return Result.success("hello");
        //return new Result(0,"success","hello");
    }

    @ResponseBody
    @RequestMapping("/helloError")
    public Result<String> helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
        //return new Result(500100,"XXX");
        //return new Result(500200,"XXX");
        //return new Result(500300,"XXX");
    }

    @RequestMapping("/thymelead")
    public String thymelead(Model model){
        model.addAttribute("name","张三");
        return "hello";
    }
}
