package cs3500.marblesolitaire.model.hw04;


/**
 * This class is an implementation of the MarbleSolitaireModel interface. This model handles moves
 * and determines the score & if the game is over. The European Solitaire Board is a hexagon.
 */
public class EuropeanSolitaireModelImpl extends AbstractMS {

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. Default constructor that creates a
   * board with sideLength of 3 and empty middle cell.
   */
  public EuropeanSolitaireModelImpl() {
    this.row = 3;
    this.col = 3;
    this.sideLength = 3;
    this.initBoard();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. This constructor creates a board with
   * the given sideLength and an empty middle cell.
   *
   * @param sideLength represents the length of one side of the octagon.
   * @throws IllegalArgumentException if the given side length is not > 1 and odd.
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    if (sideLength < 3 || sideLength % 2 != 1) {
      throw new IllegalArgumentException("Invalid side length");
    }
    this.sideLength = sideLength;
    this.row = determineMiddle();
    this.col = determineMiddle();
    this.initBoard();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. This constructor creates a board with
   * the given empty cell position and a side length of 3.
   *
   * @param row represents the row value of the empty cell.
   * @param col represents the col value of the empty cell.
   * @throws IllegalArgumentException if the empty cell position is invalid.
   */
  public EuropeanSolitaireModelImpl(int row, int col) {
    this.sideLength = 3;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid position for empty cell.");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. This constructor creates a board with
   * the given empty cell position and side length.
   */
  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {
    if (sideLength < 3 || sideLength % 2 != 1) {
      throw new IllegalArgumentException("Invalid side length");
    }
    this.sideLength = sideLength;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid position for empty cell");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  @Override
  protected boolean invalidPos(int mtRow, int mtCol) {
    return (mtRow < this.sideLength - 1 && mtCol < this.sideLength - 1 - mtRow)
            || (mtRow < this.sideLength - 1 && mtCol > 2 * this.sideLength - 2 + mtRow)
            || (mtRow > 2 * this.sideLength - 2 && mtCol < mtRow - 2 * this.sideLength + 2)
            || (mtRow > 2 * this.sideLength - 2 && mtCol > 5 * (this.sideLength - 1) - mtRow);
  }
}
