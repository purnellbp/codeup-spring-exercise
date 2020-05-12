package com.codeup.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/roll-dice")
    public String showDiceForm() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable Integer n, Model model) {
        model.addAttribute("n", n);
        return "roll-dice";
    }



//    @PostMapping("/roll-dice")
//    public String rollDiceForm(@RequestParam(name = "userRoll") String n, Model model) {
//        model.addAttribute("userRoll", "number " + n + "!");
//        return "roll-dice";
//    }

}
