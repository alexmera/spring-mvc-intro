package springmvc.intro.web.controllers;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.intro.model.Ticket;
import springmvc.intro.model.TicketStatus;
import springmvc.intro.model.value.TicketValue;
import springmvc.intro.services.IdGenerator;
import springmvc.intro.services.TicketsService;

@Controller
@RequestMapping("/")
public class Home {

  private TicketsService ticketsService;
  private IdGenerator idGenerator;

  public Home(TicketsService ticketsService, IdGenerator idGenerator) {
    this.ticketsService = ticketsService;
    this.idGenerator = idGenerator;
  }

  @GetMapping
  public String home(Model model) {
    model.addAttribute("helloMessage", "HELLO SPRING MVC!");
    long id = idGenerator.nextId();
    Ticket ticket = new TicketValue(
        id,
        "SUBJECT A " + id,
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );
    ticketsService.report(ticket);
    ticketsService.all().forEach(System.out::println);
    return "home";
  }
}
