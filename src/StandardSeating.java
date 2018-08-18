import java.util.ArrayList;
import java.util.List;

public class StandardSeating implements Seating {
  private static final int NUM_ROWS = 32;
  private static final String[] ROW_NAMES = {
    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
    "T", "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF"
  };
  private List<List<String>> standardSeats;

  public StandardSeating(List<Integer> rowLengths) throws InvalidSeatingException {
    if (rowLengths.size() != NUM_ROWS) {
      throw new InvalidSeatingException();
    }
    this.standardSeats = new ArrayList<>();
    for (int i = 0; i < NUM_ROWS; i++) {
      List<String> tempList = new ArrayList<>();
      for (int j = 0; j < rowLengths.get(i); j++) {
        tempList.add(getSeatName(i, j + 1));
      }
      standardSeats.add(tempList);
    }
  }

  private String getSeatName(int row, int col) {
    return ROW_NAMES[row] + col;
  }

  public List<List<String>> getSeating() {
    return standardSeats;
  }
}
