package springmvc.intro.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import springmvc.intro.model.Ticket;

public interface TicketDao {

  Ticket create(Ticket ticket);

  Ticket getOne(long id);

  Optional<Ticket> findOne(long id);

  List<Ticket> find(Predicate<Ticket> predicate);

  List<Ticket> list();

  Ticket update(Ticket ticket);

  Ticket delete(long id);
}
