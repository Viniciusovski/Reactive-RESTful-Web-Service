/*
 * Criar um roteador
 * Nesta aplicação, usamos um roteador para lidar com a única rota que expomos ( /hello), 
 * conforme mostrado no exemplo a seguir:
 */
package com.example.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GreetingRouter {
	
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

	    return RouterFunctions
	      .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
	}

}

/*
 * O roteador escuta o tráfego no /hellocaminho e retorna o valor fornecido por nossa classe de manipulador reativo.
 * 
*/