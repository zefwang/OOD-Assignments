package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.GamePiece;


/**
 * This class is an implementation of the MarbleSolitaireModel interface. This model handles moves
 * and determines the score & if the game is over. This implementation creates a triangle board.
 */
public class TriangleSolitaireModelImpl extends AbstractMS {
  /**
   * Constructs a {@code TriangleSolitaireModelImpl} object. Default constructor that creates a
   * board with 5 rows and empty slot at (0, 0).
   */
  public TriangleSolitaireModelImpl() {
    this.sideLength = 5;
    this.row = 0;
    this.col = 0;
    this.initBoard();
  }

  /**
   * Constructs a {@code TriangleSolitaireModelImpl} object. Constructor that creates a board with
   * given number of rows and empty slot at (0, 0).
   *
   * @param sideLength the dimension of the board (ie. number of slots in the bottom row).
   * @throws IllegalArgumentException if the given dimension is invalid.
   */
  public TriangleSolitaireModelImpl(int sideLength) {
    if (sideLength < 1) {
      throw new IllegalArgumentException("Invalid dimensions");
    }
    this.sideLength = sideLength;
    this.row = 0;
    this.col = 0;
    this.initBoard();
  }

  /**
   * Constructs a {@code TriangleSolitaireModelImpl} object. Constructor that creates a board with 5
   * rows and empty slot at given position.
   *
   * @param row the row value for the empty cell.
   * @param col the column value for the empty cell.
   * @throws IllegalArgumentException if the given cell is invalid.
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    this.sideLength = 5;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid position");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  /**
   * Constructs a {@code TriangleSolitaireModelImpl} object. Constructor that creates a board with
   * given number of rows and empty slot at given position.
   *
   * @param sideLength the dimension of the board (ie. number of slots in the bottom row).
   * @param row        the row value of the empty cell.
   * @param col        the column value of the empty cell.
   * @throws IllegalArgumentException if the sideLength or empty cell position is invalid
   */
  public TriangleSolitaireModelImpl(int sideLength, int row, int col) {
    if (sideLength < 1) {
      throw new IllegalArgumentException("Invalid dimension");
    }
    this.sideLength = sideLength;
    if (this.invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid position");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  @Override
  protected void initBoard() {
    currentBoard = new ArrayList<>();

    for (int i = 0; i < sideLength; i++) {
      ArrayList<GamePiece> row = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (i == this.row && j == this.col) {
          row.add(GamePiece.EMPTY);
        } else {
          row.add(GamePiece.MARBLE);
        }
      }
      currentBoard.add(row);
    }
  }

  @Override
  protected boolean invalidPos(int mtRow, int mtCol) {
    // Only invalid if the column is greater than the row (ex. {6, 5})
    return mtRow > this.sideLength - 1 || mtCol > mtRow;
  }

  @Override
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;

    double dist = Math.sqrt(Math.pow(fromRow - toRow, 2) + Math.pow(fromCol - toCol, 2));

    // Outside the board (index out of bounds)
    if (toRow < 0 || toRow > this.currentBoard.size() - 1
            || toCol < 0 || toCol > this.currentBoard.get(toRow).size() - 1) {
      return false;
    } else if (invalidPos(fromRow, fromCol) || invalidPos(toRow, toCol)) {
      return false;
    }
    // Checks that distance is 2 or root(2) using distance formula
    else if (!(Math.abs(2 - dist) < .01 || Math.abs(Math.sqrt(8) - dist) < .01)) {
      return false;
    }
    // Checks that "from" & middle position has a marble and "to" position is empty
    else if (!(this.currentBoard.get(fromRow).get(fromCol).toString().equals("O"))
            || !(this.currentBoard.get(toRow).get(toCol).toString().equals("_"))
            || !(this.currentBoard.get(middleRow).get(middleCol).toString().equals("O"))) {
      return false;
    }
    return true;
  }

  @Override
  public String getGameState() {
    String gameState = "";
    int currentRow = 0;
    // Number of spaces is equal to numRows - currentRow
    for (ArrayList<GamePiece> row : this.currentBoard) {
      int currentSlot = 0;

      for (int i = 0; i < this.sideLength - currentRow - 1; i++) {
        gameState += " ";
      }

      for (GamePiece item : row) {
        gameState += item.toString();
        currentSlot++;

        if (currentSlot != row.size()) {
          gameState += " ";
        }
      }

      currentRow++;
      if (currentRow != this.currentBoard.size()) {
        gameState += "\n";
      }
    }
    return gameState;
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.currentBoard.size(); i++) {
      for (int j = 0; j < this.currentBoard.get(i).size(); j++) {
        if (this.currentBoard.get(i).get(j).toString().equals("O")) {
          if (validMove(i, j, i + 2, j) || validMove(i, j, i - 2, j)
                  || validMove(i, j, i, j + 2) || validMove(i, j, i, j - 2)
                  || validMove(i, j, i + 2, j + 2) || validMove(i, j,
                  i - 2, j - 2) || validMove(i, j, i - 2, j + 2)
                  || validMove(i, j, i + 2, j - 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
