import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

public class StandardEvent implements Event {
  public static final int LOW_PRICE = 10;
  public static final int MEDIUM_PRICE = 30;
  public static final int HIGH_PRICE = 50;

  /** Stores ticket prices, or null if the ticket has been sold */
  private String name;
  private HashMap<String, Integer> ticketPrices = new HashMap<>();
  private HashMap<String, Boolean> isSold = new HashMap<>();
  private Seating seating;
  private LocalDate date;

  StandardEvent(String name, LocalDate eventDate, Seating seating) {
    this.name = name;
    this.seating = seating;
    this.date = eventDate;
    makeTicketPrices();
    makeIsSold();
  }

  public String getName() {
    return this.name;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public void sellTicket(User user, String seatName) throws InvalidSeatException {
    if (isSold.containsKey(seatName)) {
      if (!isSold.get(seatName)) {
        user.addTicket(new Ticket(seatName, user.getEmail(), this, ticketPrices.get(seatName)));
        if (ticketPrices.get(seatName) == HIGH_PRICE && !User.getGoldMembers().contains(user)) {
          User.addGoldMember(user);
        }
        isSold.replace(seatName, true);
      } else {
        throw new InvalidSeatException();
      }
    } else {
      throw new InvalidSeatException();
    }
  }

  public String getSeatingGrid() {
    String grid = "";
    for(List<String> row: this.seating.getSeating()) {
      for (String tempSeat: row) {
        if (isSold.get(tempSeat)) {
          grid += tempSeat + ":x ";
        } else {
          grid += tempSeat + ":o ";
        }
      }
      grid += System.lineSeparator();
    }
    return grid;
  }

  public boolean isComplimentary(String seatName) {
    return ticketPrices.get(seatName) == 0;
  }

  private void makeTicketPrices() {
    int i = 0;
    for (List<String> row: this.seating.getSeating()) {
      for (String tempSeat: row) {
        if (i < 10) {
          ticketPrices.put(tempSeat, HIGH_PRICE);
        } else if (i < 20) {
          ticketPrices.put(tempSeat, MEDIUM_PRICE);
        } else {
          ticketPrices.put(tempSeat, LOW_PRICE);
        }
      }
    }
  }

  private void makeIsSold() {
    for (List<String> row: this.seating.getSeating()) {
      for (String tempSeat: row) {
        isSold.put(tempSeat, false);
      }
    }
  }
}
