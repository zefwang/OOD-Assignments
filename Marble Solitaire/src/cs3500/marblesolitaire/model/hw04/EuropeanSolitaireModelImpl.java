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
    super();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. This constructor creates a board with
   * the given sideLength and an empty middle cell.
   *
   * @param sideLength represents the length of one side of the octagon.
   * @throws IllegalArgumentException if the given side length is not > 1 and odd.
   */
  public EuropeanSolitaireModelImpl(int sideLength) {
    super(sideLength);
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
    super(row, col);
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object.
   *
   * @param sideLength the number of marbles in the top/bottom row or left/right columns.
   * @param row        the row value (ie. y-val) of the position.
   * @param col        the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if armThickness is not valid or empty cell is in an invalid
   *                                  position.
   */
  public EuropeanSolitaireModelImpl(int sideLength, int row, int col) {
    super(sideLength, row, col);
  }

  @Override
  protected boolean invalidPos(int mtRow, int mtCol) {
    return (mtRow < this.sideLength - 1 && mtCol < this.sideLength - 1 - mtRow)
            || (mtRow < this.sideLength - 1 && mtCol > 2 * this.sideLength - 2 + mtRow)
            || (mtRow > 2 * this.sideLength - 2 && mtCol < mtRow - 2 * this.sideLength + 2)
            || (mtRow > 2 * this.sideLength - 2 && mtCol > 5 * (this.sideLength - 1) - mtRow);
  }
}
