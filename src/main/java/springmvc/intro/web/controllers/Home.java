package springmvc.intro.web.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springmvc.intro.model.Resolution;
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
    List<Ticket> tickets = ticketsService.all();

    model.addAttribute("h1Message", String.format("Tickets (%s)", tickets.size()));
    model.addAttribute("tickets", tickets);
    return "home";
  }

  @PostMapping("/report")
  public String report(@RequestParam String subject) {
    long id = idGenerator.nextId();
    Ticket ticket = new TicketValue(
        id,
        subject,
        TicketStatus.OPEN,
        null,
        null,
        LocalDateTime.now(),
        null
    );
    ticketsService.report(ticket);
    return "redirect:/";
  }

  @GetMapping("/close/{id}")
  public String close(@PathVariable Long id) {
    ticketsService.close(id, Resolution.NOT_SOLVED);
    return "redirect:/";
  }
}
