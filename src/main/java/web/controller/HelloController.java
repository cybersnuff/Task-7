package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarDao.CarDao;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private final CarDao carDao;

    @Autowired
    public HelloController(CarDao carDao) {
        this.carDao = carDao;
    }


    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "index";
    }

    @GetMapping("/cars")
    public String printCars(Model model, @RequestParam(value = "count", required = false) Integer count) {
        List<Car> cars;
        if (count != null && count >= 1 && count < 5) {
            cars = carDao.returnCar().subList(0, count);
        } else {
            cars = carDao.returnCar();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}

