package cn.icelo.feignclient;


import cn.icelo.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// 调用商品服务的接口
@FeignClient(value = "PRODUCT") // value : 用来书写调用的服务ID
public interface ProductClients {


    @GetMapping("product")
        // 返回值和形参列表；名字无所谓
    String product();


    // 声明test接口中的传递name,age
    @GetMapping("/test")
    String test(@RequestParam("name") String name, @RequestParam("age") Integer age);


    // 声明test1接口的中路径参数传递
    @GetMapping("/test1/{id}/{name}")
    String test1(@PathVariable("name") String name, @PathVariable("id") Integer id);

    // 声明postProduct接口对象参数传递
    @PostMapping("product")
    String postProduct(@RequestBody Product product);

    @GetMapping("/product/{id}")
    Product getProduct(@PathVariable Integer id);
}
