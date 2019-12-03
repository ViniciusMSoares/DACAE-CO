package server.clients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class Client {
  private WebClient client = WebClient.create("http://localhost:8080");

  private Mono<ClientResponse> result = client.get()
      .uri("/comissao")
      .accept(MediaType.APPLICATION_JSON_UTF8)
      .exchange();

  public String getResult() {
    return result.flatMap(res -> res.bodyToMono(String.class)).block();
  }
}