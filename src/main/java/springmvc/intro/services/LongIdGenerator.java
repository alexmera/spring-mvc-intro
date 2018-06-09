package springmvc.intro.services;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springmvc.intro.events.CurrentMaxTicketIdEvent;

@Component
public class LongIdGenerator implements IdGenerator {

  private AtomicLong atomicLong = new AtomicLong();

  @EventListener
  public void currentId(CurrentMaxTicketIdEvent event) {
    System.out.println("LongIdGenerator:currentId");
    System.out.println(event);
    atomicLong.set(event.getMaxId());
    System.out.println(String.format("Id set to: %s", atomicLong.get()));
  }

  @Override
  public long nextId() {
    return atomicLong.incrementAndGet();
  }
}
