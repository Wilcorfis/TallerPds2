package co.com.poli.servicebooking.controller;

import co.com.poli.servicebooking.entities.Booking;
import co.com.poli.servicebooking.helper.ResponseBuilder;
import co.com.poli.servicebooking.model.Response;
import co.com.poli.servicebooking.service.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class bookingController {

    private final BookingService bookingService;
    private final ResponseBuilder builder;

    @PostMapping()
    public Response save(@Valid @RequestBody Booking booking, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        bookingService.save(booking);
        return builder.success(booking);
    }

    @DeleteMapping("/{numberId}")
    public Response delete(@PathVariable("numberId") Long numberId) {
        Booking booking = bookingService.findById(numberId);
        if(booking==null){
            return builder.failed(booking);
        }
        return builder.success(booking);
    }

    @GetMapping("/{numberInvoice}")
    public Response findByUserId(@PathVariable("numberInvoice") Long numberInvoice){
        List<Booking> booking = bookingService.findByUserId(numberInvoice);
        if(booking==null){
            return builder.success();
        }
        return builder.success(booking);
    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }
}
