package cn.icelo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    @Value("${server.port}")
    private int port;


    @GetMapping("order")
    public String demo(){
        System.out.println("order demo");
        return "order demo ok"+"端口："+port;
    }
}
