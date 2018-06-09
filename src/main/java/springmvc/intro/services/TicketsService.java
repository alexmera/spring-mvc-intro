package springmvc.intro.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import springmvc.intro.model.Resolution;
import springmvc.intro.model.Ticket;

public interface TicketsService {

  Ticket report(Ticket ticket);

  Ticket get(Long ticketId);

  Optional<Ticket> find(Long ticketId);

  List<Ticket> all();

  Ticket modify(Ticket ticket);

  Ticket close(Long ticketId, Resolution resolution);

  Ticket close(Long ticketId, Resolution resolution, String solutionText);

  List<Ticket> find(Predicate<Ticket> predicate);

}
