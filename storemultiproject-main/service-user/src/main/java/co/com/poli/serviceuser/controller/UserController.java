package co.com.poli.serviceuser.controller;

import co.com.poli.serviceuser.entities.User;
import co.com.poli.serviceuser.helper.ResponseBuilder;
import co.com.poli.serviceuser.model.Response;
import co.com.poli.serviceuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
           return builder.failed(this.formatMessage(result));
        }
        userService.save(user);
        return builder.success(user);
    }
    @DeleteMapping("/{numberID}")
    public Response delete(@PathVariable("numberID") Long numberID){
        User user = (User) findByID(numberID).getData();

        if(user==null){
            return builder.failed("Not found");
        }
        userService.delete(user);
        return builder.success(user);
    }

    @GetMapping
    public Response findAll(){
        return builder.success(userService.findAll());
    }

    @GetMapping("/numberID/{numberID}")
    public Response findByNumberID(@PathVariable("numberID") String numberID){
        return builder.success(userService.findByName(numberID));
    }

    @GetMapping("/{id}")
    public Response findByID(@PathVariable("id") Long id){
        return builder.success(userService.findById(id));
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
