package cn.icelo.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("demo")
    //@HystrixCommand(fallbackMethod = "demoFallBack",defaultFallback ="defaultFallBack" ) // 熔断之后处理的 fallback Method 书写快速失败方法名
    public String demo(@RequestParam("id") Integer id) {
        System.out.println("demo ok!!!");
        if (id < 0) {
            throw new RuntimeException("无效ID");
        }
        return "demo ok!!!";
    }

//    // 默认的处理的方法
//    public String defaultFallBack(){
//        return "网络异常，请重试！";
//    }
//
//
//    // 自己的备选处理
//    public String demoFallBack(Integer id) {
//        return "当前活动过于火爆，请稍后再试！";
//    }
}
