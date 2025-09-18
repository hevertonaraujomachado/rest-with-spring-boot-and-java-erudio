package com.git.hevertonaraujomachado.controllers;


import com.git.hevertonaraujomachado.exception.UnsupportedMathOperationException;
import com.git.hevertonaraujomachado.request.converters.NumberUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController1 {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo) {
        return calculate(numberOne, numberTwo, (a, b) -> a + b);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne,
                              @PathVariable String numberTwo) {
        return calculate(numberOne, numberTwo, (a, b) -> a - b);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne,
                                 @PathVariable String numberTwo) {
        return calculate(numberOne, numberTwo, (a, b) -> a * b);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne,
                           @PathVariable String numberTwo) {
        return calculate(numberOne, numberTwo, (a, b) -> {
            if (b == 0) throw new UnsupportedMathOperationException("Division by zero is not allowed!");
            return a / b;
        });
    }

    @GetMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable String numberOne,
                       @PathVariable String numberTwo) {
        return calculate(numberOne, numberTwo, (a, b) -> (a + b) / 2);
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable String number) {
        if (!NumberUtils.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(NumberUtils.convertToDouble(number));
    }

    private Double calculate(String numberOne, String numberTwo, Operation operation) {
        if (!NumberUtils.isNumeric(numberOne) || !NumberUtils.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        Double a = NumberUtils.convertToDouble(numberOne);
        Double b = NumberUtils.convertToDouble(numberTwo);
        return operation.apply(a, b);
    }

    @FunctionalInterface
    private interface Operation {
        Double apply(Double a, Double b);
    }
}