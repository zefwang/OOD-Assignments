package cs3500.marblesolitaire.model.hw02;

/**
 * This enum is used to represent the three different types of game pieces in Marble Solitaire. This
 * is used as opposed to Strings because this guarantees only these three Strings can be used.
 */
public enum GamePiece {
  INVALID(" "), MARBLE("O"), EMPTY("_");

  private String text;

  GamePiece(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return this.text;
  }
}
