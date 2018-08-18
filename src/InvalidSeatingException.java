public class InvalidSeatingException extends Exception {
  public String getMessage() {
    return "The parameters given to create this seating object were invalid for this seating type.";
  }
}
