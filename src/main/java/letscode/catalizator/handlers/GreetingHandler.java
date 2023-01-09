package letscode.catalizator.handlers;

import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        BodyInserter<String, ReactiveHttpOutputMessage> body =
                BodyInserters.fromValue("Hello, Spring!");

        return ServerResponse
                .ok()
                .header("HttpHeaders.CONTENT_TYPE", "text/plain; charset=utf-8")
                .body(body);
    }
}