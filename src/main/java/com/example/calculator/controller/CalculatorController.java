package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
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

    @GetMapping("/date-interval")
    public Map<String, Object> dateInterval(
            @RequestParam String date1,
            @RequestParam String date2) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate d1 = LocalDate.parse(date1, formatter);
            LocalDate d2 = LocalDate.parse(date2, formatter);
            long days = ChronoUnit.DAYS.between(d1, d2);
            long weeks = ChronoUnit.WEEKS.between(d1, d2);
            long months = ChronoUnit.MONTHS.between(d1, d2);
            long years = ChronoUnit.YEARS.between(d1, d2);
            return Map.of(
                    "date1", date1,
                    "date2", date2,
                    "days", Math.abs(days),
                    "weeks", Math.abs(weeks),
                    "months", Math.abs(months),
                    "years", Math.abs(years)
            );
        } catch (DateTimeParseException e) {
            return Map.of("error", "日期格式错误，请使用 yyyy-MM-dd 格式");
        }
    }
}
