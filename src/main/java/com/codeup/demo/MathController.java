package com.codeup.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{varOne}/and/{varTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String doAddition(@PathVariable int varOne, @PathVariable int varTwo) {
        return "The product is " + (varOne + varTwo);
    }

    @RequestMapping(path = "/subtract/{varOne}/from/{varTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String doSubtract(@PathVariable int varOne, @PathVariable int varTwo) {
        return varOne + " from " + varTwo + " is " + (varTwo - varOne);
    }

    @RequestMapping(path = "/multiply/{varOne}/and/{varTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String doMultiplication(@PathVariable int varOne, @PathVariable int varTwo) {
        return varOne + " times " + varTwo + " = " + (varOne * varTwo);
    }

    @RequestMapping(path = "/divide/{varOne}/by/{varTwo}", method = RequestMethod.GET)
    @ResponseBody
    public String doDivision(@PathVariable int varOne, @PathVariable int varTwo) {
        return varOne + " divided by " + varTwo + " = " + (varOne / varTwo);
    }

}
