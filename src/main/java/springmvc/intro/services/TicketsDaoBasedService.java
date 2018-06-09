package springmvc.intro.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;
import springmvc.intro.model.Resolution;
import springmvc.intro.model.Ticket;
import springmvc.intro.model.TicketStatus;
import springmvc.intro.model.value.TicketValue;
import springmvc.intro.repositories.TicketDao;

@Service
public class TicketsDaoBasedService implements TicketsService {

  private TicketDao ticketDao;

  public TicketsDaoBasedService(TicketDao ticketDao) {
    this.ticketDao = ticketDao;
  }

  @Override
  public Ticket report(Ticket ticket) {
    return ticketDao.create(ticket);
  }

  @Override
  public Ticket get(Long ticketId) {
    return ticketDao.getOne(ticketId);
  }

  @Override
  public Optional<Ticket> find(Long ticketId) {
    return ticketDao.findOne(ticketId);
  }

  @Override
  public List<Ticket> all() {
    return ticketDao.list();
  }

  @Override
  public Ticket modify(Ticket ticket) {
    return ticketDao.update(ticket);
  }

  @Override
  public Ticket close(Long ticketId, Resolution resolution) {
    TicketValue.TicketValueBuilder builder = TicketValue.from(get(ticketId)).toBuilder();
    Ticket ticket = builder
        .status(TicketStatus.CLOSED)
        .closedAs(resolution)
        .closingDate(LocalDateTime.now())
        .build();
    if (ticket.getClosedAs().get().equals(Resolution.SOLVED) && !ticket.getSolution().isPresent()) {
      throw new IllegalStateException(
          "Si el ticket se cierra SOLVED debe tener una solución asignada");
    }
    return modify(ticket);
  }

  @Override
  public Ticket close(Long ticketId, Resolution resolution, String solutionText) {
    TicketValue.TicketValueBuilder builder = TicketValue.from(get(ticketId)).toBuilder();
    Ticket ticket = builder
        .solution(solutionText)
        .status(TicketStatus.CLOSED)
        .closedAs(resolution)
        .closingDate(LocalDateTime.now())
        .build();
    return modify(ticket);
  }

  @Override
  public List<Ticket> find(Predicate<Ticket> predicate) {
    return ticketDao.find(predicate);
  }
}
