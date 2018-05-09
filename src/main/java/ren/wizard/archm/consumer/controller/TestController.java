package ren.wizard.archm.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import ren.wizard.archm.consumer.client.ProviderClient;

/**
 * @author uyangjie
 */
@RestController
@RequestMapping("/test/")
public class TestController {
    private final ProviderClient providerClient;

    @Autowired
    public TestController(ProviderClient providerClient) {
        this.providerClient = providerClient;
    }

    @GetMapping("/rest")
    public ResponseEntity<String> testGet() {
        return new ResponseEntity<>(providerClient.testGet(), HttpStatus.OK);
    }

    @GetMapping("/rest/echo/{word}")
    public ResponseEntity<String> testEcho(@PathVariable("word") String word) {
        return new ResponseEntity<>(word, HttpStatus.OK);
    }

    @GetMapping("/flux")
    public Flux<String> testFluxGet() {
        return Flux.just(providerClient.testFlux());
    }

    @GetMapping("/flux/echo/{word}")
    public Flux<String> testFluxEcho(@PathVariable("word") String word) {
        return Flux.just(word);
    }

    @GetMapping("/error/")
    public ResponseEntity<String> testError() {
        return new ResponseEntity<>(providerClient.testError(), HttpStatus.OK);
    }
}
