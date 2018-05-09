package ren.wizard.archm.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ren.wizard.archm.consumer.client.fallback.ProviderClientFallback;

/**
 * @author uyangjie
 */
@FeignClient(value = "provider", fallback = ProviderClientFallback.class)
@Component
public interface ProviderClient {
    /**
     * test get method
     *
     * @return a string
     */
    @GetMapping("/test/rest/")
    String testGet();

    /**
     * echo
     *
     * @param word word
     * @return word
     */
    @GetMapping("/test/rest/echo/{word}/")
    String testEcho(@PathVariable("word") String word);

    /**
     * test get method
     *
     * @return a string
     */
    @GetMapping("/test/flux/")
    String testFlux();

    /**
     * echo using flux
     *
     * @param word word
     * @return word
     */
    @GetMapping("/test/flux/echo/{word}/")
    String testFluxEcho(@PathVariable("word") String word);

    /**
     * test Error
     *
     * @return default message
     */
    @GetMapping("/error/")
    String testError();

    @GetMapping("/test/flux/sleep/")
    String testFluxSleep();

    @GetMapping("/test/echo/sleep/")
    String testSleep();
}

