package br.com.clariium.productapi.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class StatusController {

    @GetMapping("status")
    public ResponseEntity<HashMap<String,Object>> getApiStatus(){

        var response = new HashMap<String,Object>();

        response.put("service", "product-api");
        response.put("service", "up");
        response.put("service", HttpStatus.OK.value());

        return ResponseEntity.ok(response);

    }

    
}
