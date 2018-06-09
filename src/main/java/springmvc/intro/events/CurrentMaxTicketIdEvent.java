package springmvc.intro.events;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.context.ApplicationEvent;

@EqualsAndHashCode(callSuper = false)
@Value
public class CurrentMaxTicketIdEvent extends ApplicationEvent {


  private Long maxId;

  /**
   * Create a new ApplicationEvent.
   *
   * @param source the object on which the event initially occurred (never {@code null})
   */
  public CurrentMaxTicketIdEvent(Object source, Long maxId) {
    super(source);
    this.maxId = maxId;
  }
}
