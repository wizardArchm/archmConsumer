package ren.wizard.archm.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
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
    ResponseEntity<String> testGet();

    /**
     * test get method
     *
     * @return a string
     */
    @GetMapping("/test/flux/")
    String testFlux();

    /**
     * test Error
     *
     * @return default message
     */
    @GetMapping("/error/")
    String testError();
}

