package cn.icelo.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// fallBack : 当服务不可用时，默认的备选方法
@FeignClient(value = "HYSTRIX", fallback = HystrixClientFallBack.class)
public interface HystrixClient {

    @GetMapping("demo")
    String demo(@RequestParam("id") Integer id);

}
