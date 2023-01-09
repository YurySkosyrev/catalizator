package letscode.catalizator.config;

import letscode.catalizator.handlers.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;

import java.util.Map;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

        RequestPredicate route = RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON));

        return RouterFunctions
                .route(route, greetingHandler::hello)
                .andRoute(RequestPredicates.GET("/"),
                greetingHandler::indexServerRequest
                );
    }
}