package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user", fallback = UserClientFallbackHystrix.class)
public interface UserClient {

    @GetMapping("/store/v1/user/numberID/{numberID}")
    Response findByNumberID(@PathVariable("numberID") String numberID);

    @GetMapping("/store/v1/user/{id}")
    Response findByID(@PathVariable("id") Long id);

}
