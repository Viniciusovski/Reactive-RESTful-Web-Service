/*
 * Criar um manipulador WebFlux
 * Vamos começar com um Greeting POJO que será serializado como JSON pelo nosso serviço RESTful:
 */

package com.example.reactive;

public class Greeting {
	
	private String message;

	public Greeting() {

	}
	
	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	  public String toString() {
	    return "Greeting{" +
	        "message='" + message + '\'' +
	        '}';
	  }

}
