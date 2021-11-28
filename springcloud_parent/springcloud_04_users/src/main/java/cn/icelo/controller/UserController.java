package cn.icelo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("user")
    public String invokeDemo() {
        System.out.println("user demo ...");

        // 1、调用订单服务 服务地址：http://localhost:9999/order  接受返回值
       // RestTemplate restTemplate = new RestTemplate();
//
//        String returnStr = restTemplate.getForObject("http://localhost:9999/order", String.class);
//        System.out.println("调用订单服务成功");
        // 使用ribbon 组件 + restTemplate实现负债均衡调用
        // DiscoveryClient
        // List<ServiceInstance> orders = discoveryClient.getInstances("ORDERS");
        // 使用负债均衡
        // loadBalance
        // ServiceInstance instance = loadBalancerClient.choose("ORDERS"); // 默认使用轮询的方式来获得URL

        String result = restTemplate.getForObject("http://ORDERS/order", String.class);

        return result;
    }


}
