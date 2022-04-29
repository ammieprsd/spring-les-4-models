package nl.novi.springlesviermodels.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<String> HelloWold(){
        return ResponseEntity.ok("Hello World!!");
    }

}
