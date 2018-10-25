package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    CarRepository carRepository;

    // save the car
    @GetMapping("/add")
    public String creatCar(Model model){
        model.addAttribute("car",new Car());
        return "carform";
    }

    // get the list of all cars
    @GetMapping("/")
    public String listCars(Model model){

        model.addAttribute("cars",carRepository.findAll());
        return  "list";
    }

    // process or save the car added
    @PostMapping("/save-car")
    public String saveCar(@Valid Car car , BindingResult result){
        if(result.hasErrors()){
            return "carform";
            }



        carRepository.save(car);

            return "redirect:/";
    }


    // to see the detail of each car with id
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") long id,  Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }


    // delete the car by id
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";

    }
}
