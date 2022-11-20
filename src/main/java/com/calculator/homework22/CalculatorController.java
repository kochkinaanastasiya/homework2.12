package com.calculator.homework22;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping()
    public String welcome(){
        return calculatorService.welcome();
    }
    @GetMapping(path = "/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if(num1 == null || num2 == null) {
            return "Не задан парметр";
        }
            String num3 = Integer.toString(num1);
            String num4 = Integer.toString(num2);
            int result = calculatorService.plus(num1, num2);
            return num3 + " + " + num4 + " = " + result;
        }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if(num1 == null || num2 == null) {
            return "Не задан парметр";
        }
        String num3 = Integer.toString(num1);
        String num4 = Integer.toString(num2);
        int result = calculatorService.minus(num1, num2);
        return num3 + " - " + num4 + " = " + result;
    }
    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if(num1 == null || num2 == null) {
            return "Не задан парметр";
        }
        String num3 = Integer.toString(num1);
        String num4 = Integer.toString(num2);
        int result = calculatorService.multiply(num1, num2);
        return num3 + " * " + num4 + " = " + result;
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer num1, @RequestParam(name = "num2", required = false) Integer num2){
        if(num1 == null || num2 == null) {
            return "Не задан парметр";
        } else if(num2 == 0){
            return "Ошибка, на ноль делить нельзя";
        }
        String num3 = Integer.toString(num1);
        String num4 = Integer.toString(num2);
        int result = calculatorService.divide(num1, num2);
        return num3 + " / " + num4 + " = " + result;
    }
}
