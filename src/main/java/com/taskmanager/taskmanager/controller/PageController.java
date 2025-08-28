package com.taskmanager.taskmanager.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController 
{
    Logger logger = LoggerFactory.getLogger(PageController.class);

    
    
    @GetMapping("/home")
    public String home(Model model)
    {
        System.out.println("Home page");

        model.addAttribute("name", "Bappi Gorain");

        model.addAttribute("currentDate", LocalDate.now());
        
        return "homepage";
    }


    @GetMapping("/loop")
    public String iterate(Model model)
    {
        logger.info("Loop is running");
        
        List<String> names = List.of("Ram","Shyam","Radha","Baski","Rani");
        
        model.addAttribute("names", names);
        
        return "loop";
    }    


    @GetMapping("/animals")
    public String printAnimalsName(Model model)
    {

        List<String> animals = new ArrayList<>();
        
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Tiger");
        animals.add("Lion");
        animals.add("Cheetah");
        
        model.addAttribute("animal", animals);
        
        return "Animal";
    }




    
    @PostMapping("/save")
    public String saveAnimal(@RequestParam("animalName") String animalName, Model model) 
    {
        // here you get the data from frontend
        System.out.println("Received animal: " + animalName);

        // you can send it back to frontend if needed
        model.addAttribute("animal", animalName);
        return "animal"; // your Thymeleaf HTML file
    }


    
    
    
}
