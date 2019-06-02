package cs3500.marblesolitaire.model.hw04;

import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.GamePiece;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This class is an abstract implementation of the MarbleSolitaireModel interface. This model
 * reduces the amount of redundant code for handling moves and determining the score & if the game
 * is over. Used in EuropeanSolitaireModel and the original model
 */
public abstract class AbstractMS implements MarbleSolitaireModel {
  protected ArrayList<ArrayList<GamePiece>> currentBoard;
  protected int sideLength;
  protected int row;
  protected int col;

  /**
   * Constructs a {@code AbstractMS} object. Default constructor that creates a board with
   * sideLength of 3 and empty middle cell. Used in EuropeanSolitaireModel and the original model
   */
  public AbstractMS() {
    this.row = 3;
    this.col = 3;
    this.sideLength = 3;
    this.initBoard();
  }

  /**
   * Constructs a {@code EuropeanSolitaireModelImpl} object. This constructor creates a board with
   * the given empty cell position and a side length of 3. Used in EuropeanSolitaireModel and the
   * original model
   *
   * @param row represents the row value of the empty cell.
   * @param col represents the col value of the empty cell.
   * @throws IllegalArgumentException if the empty cell position is invalid.
   */
  public AbstractMS(int row, int col) {
    this.sideLength = 3;
    if (invalidPos(row, col)) {
      throw new IllegalArgumentException("Invalid position for empty cell.");
    }
    this.row = row;
    this.col = col;
    this.initBoard();
  }

  /**
   * Constructs a {@code AbstractMS} object. This constructor creates a board with the given
   * sideLength and an empty middle cell. Used in EuropeanSolitaireModel and the original model
   *
   * @param sideLength represents the length of one side of the octagon.
   * @throws IllegalArgumentException if the given side length is not > 1 and odd.
   */
  public AbstractMS(int sideLength) {
    if (sideLength < 3 || sideLength % 2 != 1) {
      throw new IllegalArgumentException("Invalid side length");
    }
    this.sideLength = sideLength;
    this.row = determineMiddle();
    this.col = determineMiddle();
    this.initBoard();
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
  public AbstractMS(int sideLength, int row, int col) {
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

  /**
   * Creates the initial game board for the MarbleSolitaireModel.
   */
  protected void initBoard() {
    int boardSideLength = this.sideLength + 2 * (this.sideLength - 1);

    this.currentBoard = new ArrayList<>();

    for (int i = 0; i < boardSideLength; i++) {
      ArrayList<GamePiece> rowResult = new ArrayList<>();
      for (int j = 0; j < boardSideLength; j++) {
        if (!invalidPos(i, j)) {
          if (i == this.row && j == this.col) {
            rowResult.add(GamePiece.EMPTY);
          } else {
            rowResult.add(GamePiece.MARBLE);
          }
        } else {
          if (j < boardSideLength / 2) {
            rowResult.add(GamePiece.INVALID);
          }
        }
      }
      this.currentBoard.add(rowResult);
    }
  }

  /**
   * Determines if the position of the first empty cell is a valid position.
   *
   * @param mtRow The row value for the position of the empty cell.
   * @param mtCol The col value for the position of the empty cell.
   * @return A boolean which is true if the empty cell is not on the board.
   */
  protected boolean invalidPos(int mtRow, int mtCol) {
    return (mtRow < this.sideLength - 1 && mtCol < this.sideLength - 1)
            || (mtRow < this.sideLength - 1 && mtCol > 2 * this.sideLength - 2)
            || (mtRow > 2 * this.sideLength - 2 && mtCol < this.sideLength - 1)
            || (mtRow > 2 * this.sideLength - 2 && mtCol > 2 * this.sideLength - 2);
  }

  /**
   * Finds the middle of the board, where the empty cell is located.
   *
   * @return the x (and y) value of the middle of the board.
   */
  protected int determineMiddle() {
    return (this.sideLength / 2) + (this.sideLength - 1);
  }

  /**
   * Moves a marble to an empty space and removes the one in the middle if the move is valid.
   *
   * @param fromRow the row number of the position to be moved from.
   * @param fromCol the column number of the position to be moved from.
   * @param toRow   the row number of the position to be moved to.
   * @param toCol   the column number of the position to be moved to.
   * @throws IllegalArgumentException if the move is invalid
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (!validMove(fromRow, fromCol, toRow, toCol)) {
      throw new IllegalArgumentException("Invalid move");
    }
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;

    this.currentBoard.get(fromRow).set(fromCol, GamePiece.EMPTY);
    this.currentBoard.get(toRow).set(toCol, GamePiece.MARBLE);
    this.currentBoard.get(middleRow).set(middleCol, GamePiece.EMPTY);
  }

  /**
   * Determines if the game is over.
   *
   * @return boolean that returns TRUE if game is over.
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.currentBoard.size(); i++) {
      for (int j = 0; j < this.currentBoard.get(i).size(); j++) {
        if (this.currentBoard.get(i).get(j).toString().equals("O")) {
          if (validMove(i, j, i + 2, j) || validMove(i, j, i - 2, j)
                  || validMove(i, j, i, j + 2) || validMove(i, j, i, j - 2)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Determines if the move is valid.
   *
   * @param fromRow the row of the cell from.
   * @param fromCol the column of the cell from.
   * @param toRow   the row of the cell to.
   * @param toCol   the column of the cell to.
   * @returns a boolean that is true if the move is legal.
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
    int middleRow = (fromRow + toRow) / 2;
    int middleCol = (fromCol + toCol) / 2;

    // Outside the board (index out of bounds)
    if (toRow < 0 || toRow > this.currentBoard.size() - 1
            || toCol < 0 || toCol > this.currentBoard.get(middleRow).size() - 1) {
      return false;
    } else if (invalidPos(fromRow, fromCol) || invalidPos(toRow, toCol)) {
      return false;
    }
    // Checks that distance is 2 using distance formula(only possible vertically or horizontally)
    else if (Math.sqrt(Math.pow(fromRow - toRow, 2) + Math.pow(fromCol - toCol, 2)) != 2) {
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
    for (ArrayList<GamePiece> row : this.currentBoard) {
      int currentSlot = 0;
      for (GamePiece item : row) {
        gameState += item.toString();
        if (currentSlot + 1 != row.size()) {
          gameState += " "; //If not the last slot in row, add a space
        }
        currentSlot++;
      }
      if (currentRow + 1 != this.currentBoard.size()) {
        gameState += "\n"; //If not the last line, add a newline character
      }
      currentRow++;
    }

    return gameState;
  }

  @Override
  public int getScore() {
    int score = 0;

    for (ArrayList<GamePiece> row : this.currentBoard) {
      for (GamePiece item : row) {
        if (item.toString().equals("O")) {
          score++;
        }
      }
    }
    return score;
  }
}
