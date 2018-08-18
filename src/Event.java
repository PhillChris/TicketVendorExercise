import java.time.LocalDate;

public interface Event {
  void sellTicket(User user, String seatName) throws InvalidSeatException;
  String getName();
  LocalDate getDate();
  String getSeatingGrid();
  boolean isComplimentary(String seatName);
}
