package cn.icelo.feignclients;


import org.springframework.context.annotation.Configuration;


// 自定义的默认备选方案类
@Configuration
public class HystrixClientFallBack implements HystrixClient {

    @Override
    public String demo(Integer id) {
        return "这个是新的备选方法" + id;
    }
}
