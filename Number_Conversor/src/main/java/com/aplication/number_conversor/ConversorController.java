package com.aplication.number_conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ConversorController {

    @Autowired
    NumberConversonrClient ncc;

    @GetMapping("number")
    public String NumberToLetters(@RequestParam String number1){
        return ncc.converData(Integer.parseInt(number1));
    }


    @GetMapping("numberDollars")
    public String NumberToDollarrs(@RequestParam String number1){
        return ncc.DollarsData(Integer.parseInt(number1));
    }
}
