public class InvalidSeatException extends Exception {
  public String getMessage() {
    return "This seat either does not exist, or has already been sold";
  }
}
