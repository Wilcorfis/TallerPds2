package co.com.poli.servicemovie.controller;

import co.com.poli.servicemovie.entities.Movie;
import co.com.poli.servicemovie.helper.ResponseBuilder;
import co.com.poli.servicemovie.model.Response;
import co.com.poli.servicemovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie==null){
            return builder.failed("Not found product");
        }
        movieService.delete(movie);
        return builder.success(movie);
    }

    @GetMapping
    public Response findAll(){
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return builder.failed("Products is empty");
        }
        return builder.success(movies);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie==null){
            return builder.failed("Not found product");
        }
        return builder.success(movie);
    }
   //deberia ir en otra clase
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
