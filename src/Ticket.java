public class Ticket {
  private String seatName;
  private String ownerEmail;
  private Event event;
  private int price;

  public Ticket(String seatName, String ownerEmail, Event event, int price) {
    this.seatName = seatName;
    this.ownerEmail = ownerEmail;
    this.event = event;
    this.price = price;
  }

  public String getSeatName() {
    return seatName;
  }

  public void setSeatName(String seatName) {
    this.seatName = seatName;
  }

  public String getOwnerEmail() {
    return ownerEmail;
  }

  public void setOwnerEmail(String ownerEmail) {
    this.ownerEmail = ownerEmail;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String toString() {
    return "Event: "
        + this.event.getName()
        + " Date: "
        + this.event.getDate()
        + " Seat: "
        + seatName
        + " Price: $"
        + this.price;
  }
}
