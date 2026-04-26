package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Map<String, Double> add(
            @RequestParam double a,
            @RequestParam double b) {
        return Map.of("result", a + b);
    }

    @GetMapping("/subtract")
    public Map<String, Double> subtract(
            @RequestParam double a,
            @RequestParam double b) {
        return Map.of("result", a - b);
    }
}
