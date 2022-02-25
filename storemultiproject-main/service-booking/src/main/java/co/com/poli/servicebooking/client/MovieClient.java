package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="service-movie")
public interface MovieClient {

    @GetMapping("/store/v1/movie/{id}")
    Response findById(@PathVariable("id") Long id);
}
