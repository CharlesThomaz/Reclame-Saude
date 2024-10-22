package br.com.devset.reclamesaude.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/ola")
    @ResponseStatus(HttpStatus.OK)
    public String olaMundo() {
        return "Hello World";
    }
    @PostMapping("/ola")
    @ResponseStatus(HttpStatus.CREATED)
    public String olaNome(@RequestBody String name) {
        return "Hello " + name;
    }

}
