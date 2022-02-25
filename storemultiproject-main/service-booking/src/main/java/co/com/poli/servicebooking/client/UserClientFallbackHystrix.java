package co.com.poli.servicebooking.client;

import co.com.poli.servicebooking.helper.ResponseBuilder;
import co.com.poli.servicebooking.model.User;
import co.com.poli.servicebooking.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientFallbackHystrix implements UserClient{
//llama a los metodos del otro microservicio
    private final ResponseBuilder builder;

    @Override
    public Response findByNumberID(String numberID) {
        return builder.success(new User());
    }

    @Override
    public Response findByID(Long id) {
        return builder.success(new User());
    }
}
