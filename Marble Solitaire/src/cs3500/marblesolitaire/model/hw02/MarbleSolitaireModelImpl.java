package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMS;

/**
 * This class is an implementation of the MarbleSolitaireModel interface. This model handles
 * moves and determines the score & if the game is over. For assignment 4, I removed the
 * getGameState() and getScore() methods from this implementation. Instead, I created an Abstract
 * class that implements the MarbleSolitaireModel interface, called AbstractMS. This class
 * overrides those two methods to avoid repetition in the other two implementations of the
 * MarbleSolitaireModel.
 */
public class MarbleSolitaireModelImpl extends AbstractMS {

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object. Default constructor that creates a board
   * with armThickness of 3 and empty middle cell.
   */
  public MarbleSolitaireModelImpl() {
    this.row = 3;
    this.col = 3;
    this.sideLength = 3;
    this.initBoard();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param row the row value (ie. y-val) of the position.
   * @param col the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if empty cell is in an invalid position.
   */
  public MarbleSolitaireModelImpl(int row, int col) {
    this.sideLength = 3;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid empty cell position");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the number of marbles in the top/bottom row or left/right columns.
   * @throws IllegalArgumentException if armThickness is invaild (ie. negative or even).
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    if (!(armThickness % 2 == 1 && armThickness > 2)) { // Odd and positive, not 1
      throw new IllegalArgumentException();
    }
    this.sideLength = armThickness;
    this.row = determineMiddle();
    this.col = determineMiddle();
    this.initBoard();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the number of marbles in the top/bottom row or left/right columns.
   * @param row         the row value (ie. y-val) of the position.
   * @param col         the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if armThickness is not valid or empty cell is in an invalid
   *                                  position.
   */
  public MarbleSolitaireModelImpl(int armThickness, int row, int col) {
    if (!(armThickness % 2 == 1 && armThickness > 2)) {
      throw new IllegalArgumentException();
    }
    this.sideLength = armThickness;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException();
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }
}
