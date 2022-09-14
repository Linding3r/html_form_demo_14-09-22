package com.example.htmldemo14_09_22.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebFormController {

  @GetMapping("/")
  public String showForm(){
    return "webForm";
  }

  @PostMapping("/makegreeting")
  public String greetingPage(@RequestParam("fullname") String name, @RequestParam("personage") int age, RedirectAttributes redirectAttributes){
    System.out.println(name + age); //Will be replaced with database create/update/delete
    redirectAttributes.addAttribute("personage", age);
    redirectAttributes.addAttribute("fullname", name);
    return "redirect:/makegreeting";
  }

  @GetMapping("/makegreeting")
  public String makeGreetingPage(@RequestParam("fullname") String name, @RequestParam("personage") int age, Model model){
    model.addAttribute("fullname", name);
    model.addAttribute("personage", age);
    return"greetingPage";
  }

}
