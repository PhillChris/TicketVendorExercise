import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Venue {
  private Seating seating;
  private List<Event> events = new ArrayList<>();
  public Venue(Seating seating) {
    this.seating = seating;
  }

  public Seating getSeating() {
    return this.seating;
  }

  public void setSeating(Seating seating) {
    this.seating = seating;
  }

  public List<Event> getEvents() {
    return this.events;
  }


  public void addEvent(String name, LocalDate date) {
    this.events.add(new StandardEvent(name, date, this.seating));
  }
}
