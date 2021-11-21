package com.example.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OperationController {

    @Autowired
    OperationClient oc;

    @GetMapping("add")
    public String MakeAdd(@RequestParam String number1,@RequestParam String number2){
        return "The answers is "+oc.addingMetod(Integer.parseInt(number1),Integer.parseInt(number2));
    }

    @GetMapping("subtract")
    public String Makesubtract(@RequestParam String number1,@RequestParam String number2){
        return "The answers is "+oc.substractMetod(Integer.parseInt(number1),Integer.parseInt(number2));
    }

    @GetMapping("multiply")
    public String MakeMultiply(@RequestParam String number1,@RequestParam String number2){
        return "The answers is "+oc.multiplyMetod(Integer.parseInt(number1),Integer.parseInt(number2));
    }

    @GetMapping("divide")
    public String MakeDivide(@RequestParam String number1,@RequestParam String number2){
        try{
            return "The answers is "+oc.DivideMethod(Integer.parseInt(number1),Integer.parseInt(number2));
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
