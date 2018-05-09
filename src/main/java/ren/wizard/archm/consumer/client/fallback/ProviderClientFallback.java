package ren.wizard.archm.consumer.client.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ren.wizard.archm.consumer.client.ProviderClient;

/**
 * @author uyangjie
 */
@Component
public class ProviderClientFallback implements ProviderClient {
    @Override
    public ResponseEntity<String> testGet() {
        return null;
    }

    @Override
    public String testFlux() {
        return null;
    }

    @Override
    public String testError() {
        return "error and fall back to default method";
    }
}
