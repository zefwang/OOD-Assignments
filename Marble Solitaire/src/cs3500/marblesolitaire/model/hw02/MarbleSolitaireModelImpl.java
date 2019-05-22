package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;

/**
 * This class is an implementation of the MarbleSolitaireModel interface. This model handles
 * moves and determines the score & if the game is over.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {
  private final int sRow;
  private final int sCol;
  private final int armThickness;
  private ArrayList<ArrayList<GamePiece>> currentBoard;

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object. Default constructor that creates a board
   * with armThickness of 3 and empty middle cell.
   */
  public MarbleSolitaireModelImpl() {
    this.sRow = 3;
    this.sCol = 3;
    this.armThickness = 3;
    this.initBoard();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param sRow the row value (ie. y-val) of the position.
   * @param sCol the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if empty cell is in an invalid position.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    this.armThickness = 3;
    if (invalidPos(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position");
    }
    this.sRow = sRow;
    this.sCol = sCol;
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
    this.armThickness = armThickness;
    this.sCol = determineMiddle();
    this.sRow = determineMiddle();
    this.initBoard();
  }

  /**
   * Constructs a {@code MarbleSolitaireModelImpl} object.
   *
   * @param armThickness the number of marbles in the top/bottom row or left/right columns.
   * @param sRow         the row value (ie. y-val) of the position.
   * @param sCol         the col value (ie. x-val) of the position.
   * @throws IllegalArgumentException if armThickness is not valid or empty cell is in an invalid
   *                                  position.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {
    if (!(armThickness % 2 == 1 && armThickness > 2)) {
      throw new IllegalArgumentException();
    }
    this.armThickness = armThickness;
    if (invalidPos(sRow, sCol)) {
      throw new IllegalArgumentException();
    }
    this.sRow = sRow;
    this.sCol = sCol;
    this.initBoard();
  }

  /**
   * Creates the initial board using given arm thickness and position of the empty cell.
   *
   * @return the initial 3x3 board as a 2D array.
   */
  private void initBoard() {
    ArrayList<ArrayList<GamePiece>> result = new ArrayList<>();

    int sideLength = this.armThickness + 2 * (this.armThickness - 1);

    this.currentBoard = new ArrayList<>();

    for (int i = 0; i < sideLength; i++) {
      ArrayList<GamePiece> rowResult = new ArrayList<>();
      for (int j = 0; j < sideLength; j++) {
        if (!invalidPos(j, i)) {
          if (i == this.sRow && j == this.sCol) {
            rowResult.add(GamePiece.EMPTY);
          } else {
            rowResult.add(GamePiece.MARBLE);
          }
        } else {
          if (j < sideLength / 2) {
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
  private boolean invalidPos(int mtRow, int mtCol) {
    return (mtRow < this.armThickness - 1 && mtCol < this.armThickness - 1)
            || (mtRow < this.armThickness - 1 && mtCol > 2 * this.armThickness - 2)
            || (mtRow > 2 * this.armThickness - 2 && mtCol < this.armThickness - 1)
            || (mtRow > 2 * this.armThickness - 2 && mtCol > 2 * this.armThickness - 2);

  }

  /**
   * Finds the middle of the board, where the empty cell is located.
   *
   * @return the x (and y) value of the middle of the board.
   */
  private int determineMiddle() {
    return (this.armThickness / 2) + (this.armThickness - 1);
  }

  /**
   * Moves a marble to an empty space and removes the one in the middle if the move is valid.
   *
   * @param fromRow the row number of the position to be moved from.
   * @param fromCol the column number of the position to be moved from.
   * @param toRow   the row number of the position to be moved to.
   * @param toCol   the column number of the position to be moved to.
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
  private boolean validMove(int fromRow, int fromCol, int toRow, int toCol) {
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

  /**
   * Prints the current game state with the board represented by strings.
   *
   * @return The current board represented using a String.
   */
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

  /**
   * Gets the current score, which is the number of empty squares on the board.
   *
   * @return An int that represents the current score.
   */
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
