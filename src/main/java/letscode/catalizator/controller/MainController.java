package letscode.catalizator.controller;

import letscode.catalizator.domain.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

import java.io.Flushable;

@Controller
@RequestMapping("/controller")
public class MainController {
    public Flux<Message> list(
            @RequestParam(defaultValue = "0") Long start,
            @RequestParam(defaultValue = "3") Long count){
        return Flux
                .just(
                        "Hello Reactive!",
                        "More then one",
                        "Second post",
                        "Third post"
                )
                .skip(start)
                .take(count)
                .map(Message::new);
    }
}
