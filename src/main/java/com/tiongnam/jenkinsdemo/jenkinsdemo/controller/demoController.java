package com.tiongnam.jenkinsdemo.jenkinsdemo.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/demo")
public class demoController {
    @GetMapping("/")
    public @ResponseBody String getBook() {
        return "Welcome Demo new";
    }

}
