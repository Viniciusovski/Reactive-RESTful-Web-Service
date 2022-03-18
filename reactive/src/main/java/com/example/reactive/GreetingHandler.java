/*
 * Na abordagem Spring Reactive, usamos um manipulador para lidar com a solicitação e 
 * criar uma resposta, conforme mostrado no exemplo a seguir: 
 */

package com.example.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {
	
	public Mono<ServerResponse> hello(ServerRequest request){
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(new Greeting("Hello, Spring")));
	}
	
	/*
	 * Essa classe reativa simples sempre retorna um corpo JSON com um “Hello, Spring!” saudações. Ele pode retornar muitas outras coisas, 
	 * incluindo um fluxo de itens de um banco de dados, um fluxo de itens que foram gerados por cálculos e assim por diante. 
	 * Observe o código reativo: um Mono objeto que contém um ServerResponsecorpo.
	 */

}
