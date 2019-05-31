package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractMS;

/**
 * This class is an implementation of the MarbleSolitaireModel interface. This model handles moves
 * and determines the score & if the game is over. For assignment 4, I removed all the methods from
 * this implementation. Instead, I created an Abstract class that implements the
 * MarbleSolitaireModel interface, called AbstractMS. This was done to get rid of redundant code.
 */
public class MarbleSolitaireModelImpl extends AbstractMS {

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object. Default constructor that creates a board
   * with armThickness of 3 and empty middle cell.
   */
  public MarbleSolitaireModelImpl() {
    super();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param row the row value (ie. y-val) of the position.
   * @param col the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if empty cell is in an invalid position.
   */
  public MarbleSolitaireModelImpl(int row, int col) {
    super(row, col);
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the number of marbles in the top/bottom row or left/right columns.
   * @throws IllegalArgumentException if armThickness is invaild (ie. negative or even).
   */
  public MarbleSolitaireModelImpl(int armThickness) {
    super(armThickness);
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the number of marbles in the top/bottom row or left/right columns.
   * @param row          the row value (ie. y-val) of the position.
   * @param col          the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if armThickness is not valid or empty cell is in an invalid
   *                                  position.
   */
  public MarbleSolitaireModelImpl(int armThickness, int row, int col) {
    super(armThickness, row, col);
  }
}
