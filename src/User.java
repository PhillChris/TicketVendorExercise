import java.util.List;
import java.util.ArrayList;

public class User {
  private static List<User> goldMembersClub = new ArrayList<>();
  private List<Ticket> tickets;
  private String email;
  public User(String email) {
    this.email = email;
    this.tickets = new ArrayList<>();
  }

  public void addTicket(Ticket ticket) {
    this.tickets.add(ticket);
  }

  public List<Ticket> getTickets() {
    return this.tickets;
  }

  public String getEmail() {
    return this.email;
  }

  public static void addGoldMember(User user) {
    goldMembersClub.add(user);
  }

  public static List<User> getGoldMembers() {
    return goldMembersClub;
  }

  public static void removeGoldMember(User user) {
    goldMembersClub.remove(user);
  }

  public String toString() {
    return this.email;
  }
}
