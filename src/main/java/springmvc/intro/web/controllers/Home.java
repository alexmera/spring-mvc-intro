package springmvc.intro.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {

  @GetMapping
  public String home(Model model) {
    model.addAttribute("helloMessage", "HELLO SPRING MVC!");
    return "home";
  }
}
