package cn.icelo.controller;


import cn.icelo.pojo.Product;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    public Integer port;

    @GetMapping("/product")
    public String product() {
        log.info("进入类别服务...");
        return "Product Ok " + port;
    }

    // 定义一个零散类型参数的接口
    @GetMapping("/test")
    public String test(String name, Integer age) {
        log.info("name:{},age:{}", name, age);
        return name + " ok,当前服务的端口为：" + port;
    }

    // 定义一个路径参数类型接口
    @GetMapping("test1/{id}/{name}")
    public String test1(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        log.info("name:{},id:{}", name, id);
        return name + id + " ok,当前服务的端口为：" + port;
    }

    // 定义一个对象参数接口
    @PostMapping("product")
    public String postProduct(@RequestBody Product product) {
        return "product:" + product.toString();
    }


    @GetMapping("product/{id}")
    public Product getProduct(@PathVariable Integer id) {
        System.out.println(id);
        return new Product(id, "超短连衣裙", 23.2, new Date());
    }
}
