package com.ssafy.enjoyTrip.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping(path="/fda", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test() {
        return "안녕하세요!!";
    }
}
