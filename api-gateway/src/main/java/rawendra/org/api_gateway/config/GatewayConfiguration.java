package rawendra.org.api_gateway.config;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.function.*;

@Configuration
public class GatewayConfiguration {

//  @Bean
//  public RouterFunction<ServerResponse> products() {
//
//    return GatewayRouterFunctions
////            .route("product-service")
////
////            .route(RequestPredicates.GET("api/products"),
////                    HandlerFunctions.http("http://localhost:8070/"))
////            .route(RequestPredicates.POST("api/products"),
////                    HandlerFunctions.http("http://localhost:8070/")).
//
//
//
//            build();
//  }

//  @Bean
//  public RouterFunction<ServerResponse> getOrders() {
//    return GatewayRouterFunctions
//            .route("order-service")
//            .route(RequestPredicates.path("api/orders"),
//                    HandlerFunctions.http("http://localhost:8070/")).
//
//            build();
//  }


}
