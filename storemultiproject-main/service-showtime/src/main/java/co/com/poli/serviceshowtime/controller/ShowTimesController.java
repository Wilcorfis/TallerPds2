package co.com.poli.serviceshowtime.controller;

import co.com.poli.serviceshowtime.entities.ShowTime;
import co.com.poli.serviceshowtime.helper.ResponseBuilder;
import co.com.poli.serviceshowtime.model.Response;
import co.com.poli.serviceshowtime.service.ShowTimesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/showtime")
@RequiredArgsConstructor
public class ShowTimesController {

    private final ShowTimesService showTimesService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody ShowTime showTime, BindingResult result) {
        showTimesService.save(showTime);
        return builder.success(showTime);
    }

    @GetMapping
    public Response findAll(){
        List<ShowTime> showTime = showTimesService.findAll();
        if(showTime.isEmpty()){
            return builder.failed("Show Times is Empty");
        }
        return builder.success(showTime);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        ShowTime showTime = showTimesService.findById(id);
        if(showTime==null){
            return builder.failed("Not Found showtime");
        }
        return builder.success(showTime);
    }
}