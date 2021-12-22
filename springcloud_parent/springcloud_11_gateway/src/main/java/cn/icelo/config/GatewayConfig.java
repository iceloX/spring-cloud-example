package cn.icelo.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            // 路由配置
            .route("product_router", r -> r.path("/list/**").uri("http://localhost:8788"))
            .route("category_router", r -> r.path("/category/**").uri("http://localhost:8787"))
            .build();

    }
}
