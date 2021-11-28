package cn.icelo.controller;


import cn.icelo.feignclients.HystrixClient;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDemoController {


    @Autowired
    private HystrixClient hystrixClient;


    @GetMapping("test")
    public String test(@RequestParam("id") Integer id) {

        // 希望在调用服务过程中出现问题能有备选处理
        String result = hystrixClient.demo(id);
        return "test demo ok!!!" + result;
    }
}
