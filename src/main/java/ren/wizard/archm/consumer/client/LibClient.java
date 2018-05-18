package ren.wizard.archm.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import ren.wizard.archm.providercontract.controller.LibController;

/**
 * @author uyangjie
 */
@FeignClient("provider")
@Component
public interface LibClient extends LibController {
}
