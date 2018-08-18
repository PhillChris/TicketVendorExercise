import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
  private static final int[] ROW_LENGTHS = {
    55, 66, 13, 2, 88, 30, 53, 33, 72, 42, 85, 14, 30, 54, 32, 93, 25, 25, 92, 30, 23, 30, 87, 3,
    34, 19, 38, 76, 9, 79, 70, 88
  };

  public static void main(String[] args) {
    try {
      List<Integer> lengths = makeLengthsList();
      Venue myVenue = new Venue(new StandardSeating(lengths));
      myVenue.addEvent("myEvent", LocalDate.now());
      Event myEvent = myVenue.getEvents().get(0);
      User user = new User("meme@dream.com");
      myEvent.sellTicket(user, "A1");
      myEvent.sellTicket(user, "A2");
      System.out.println(myEvent.getSeatingGrid());
      System.out.println(User.getGoldMembers());
      System.out.println(user.getTickets());
      System.out.println(myEvent.isComplimentary("A2"));
    } catch (Exception a) {
      System.out.println(a);
    }
  }

  private static List<Integer> makeLengthsList() {
    List<Integer> temp = new ArrayList<>();
    for (int i: ROW_LENGTHS) {
      temp.add(i);
    }
    return temp;
  }
}
