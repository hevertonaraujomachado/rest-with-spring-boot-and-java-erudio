package com.git.hevertonaraujomachado.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException();
        return convertToDouble(numberOne) + convertDouble(numberTwo);

    }

    private Double convertDouble(String numberOne) {
        return 1d;
    }

    private Double convertToDouble(String numbertwo) {
        return 1d;
    }

    private boolean isNumeric(String number) {
        return true;
    }
}
