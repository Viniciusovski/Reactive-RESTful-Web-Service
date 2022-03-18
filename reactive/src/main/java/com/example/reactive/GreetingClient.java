/*
 * Criar um WebClient
 * A classe Spring RestTemplateé, por natureza, bloqueante. 
 * Consequentemente, não queremos usá-lo em um aplicativo reativo. 
 * Para aplicativos reativos, o Spring oferece a WebClientclasse, que não é bloqueante. 
 * Usamos uma implementação baseada em WebClient para consumir nosso serviço RESTful:
 */

package com.example.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class GreetingClient {
	
	private final WebClient client;
	
	public GreetingClient(WebClient.Builder builder) {
		this.client = builder.baseUrl("http://localhost:8080").build();
	}
	
	public Mono<String> getMessage(){
		return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(Greeting.class)
				.map(Greeting::getMessage);
	}

}

/*
 * A WebClientclasse utiliza recursos reativos, na forma de a Monopara conter o conteúdo da mensagem (retornada pelo getMessagemétodo). 
 * Isso está usando uma API de função, em vez de uma imperativa, para encadear operadores reativos.
 * Pode levar tempo para se acostumar com as APIs Reativas , mas WebClientpossui recursos interessantes e 
 * também pode ser usado em aplicativos Spring MVC tradicionais. 
 */
