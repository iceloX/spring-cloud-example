package cn.icelo.controller;


import cn.icelo.feignclient.ProductClients;
import cn.icelo.pojo.Product;
import java.util.Date;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private ProductClients productClients;

    @Value("${server.port}")
    public Integer port;


    @GetMapping("/category")
    public Product category() {
        log.info("进入分类服务");
        // 调用商品服务

        // 1、RestTemplate 2、Ribbon+RestTemplate 3、OpenFeign

        return productClients.getProduct(21);
    }
}
