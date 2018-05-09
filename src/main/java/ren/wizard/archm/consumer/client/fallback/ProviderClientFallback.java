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
    public String testGet() {
        return "error and fall back to default method";
    }

    @Override
    public String testEcho(String word) {
        return "error and fall back to default method";
    }

    @Override
    public String testFlux() {
        return "error and fall back to default method";
    }

    @Override
    public String testFluxEcho(String word) {
        return "error and fall back to default method";
    }

    @Override
    public String testError() {
        return "error and fall back to default method";
    }

    @Override
    public String testSleep() {
        return "error and fall back to default method";
    }

    @Override
    public String testFluxSleep() {
        return "error and fall back to default method";
    }
}
