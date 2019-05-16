import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the MarbleSolitaireModelImpl class.
 */
public class ImplementationTests {

  private MarbleSolitaireModelImpl defaultBoard = new MarbleSolitaireModelImpl();
  private MarbleSolitaireModelImpl setEmpty = new MarbleSolitaireModelImpl(2, 3);
  private MarbleSolitaireModelImpl setThickness = new MarbleSolitaireModelImpl(5);
  private MarbleSolitaireModelImpl setAllParams =
          new MarbleSolitaireModelImpl(5, 4, 5);

  private String defaultOut = "    O O O"
          + "\n    O O O"
          + "\nO O O O O O O"
          + "\nO O O _ O O O"
          + "\nO O O O O O O"
          + "\n    O O O"
          + "\n    O O O";

  private String setEmptyOut = "    O O O"
          + "\n    O O O"
          + "\nO O O _ O O O"
          + "\nO O O O O O O"
          + "\nO O O O O O O"
          + "\n    O O O"
          + "\n    O O O";

  private String setThicknessOut = "        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O _ O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O";

  private String setParamsOut = "        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\nO O O O O _ O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\nO O O O O O O O O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O"
          + "\n        O O O O O";

  // move() tests
  @Test
  public void testOneMove() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(3, 1, 3, 3);
    String oneMoveOut = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(oneMoveOut, moveBoard.getGameState());
    moveBoard.move(3, 4, 3, 2);
    oneMoveOut = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(oneMoveOut, moveBoard.getGameState());

    MarbleSolitaireModelImpl customBoard = new MarbleSolitaireModelImpl(5);
    customBoard.move(4, 6, 6, 6);
    oneMoveOut = "        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O";
    assertEquals(oneMoveOut, customBoard.getGameState());

    customBoard.move(7, 6, 5, 6);
    oneMoveOut = "        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O";
    assertEquals(oneMoveOut, customBoard.getGameState());
    oneMoveOut = "        O O O O O"
            + "\n        O O O O O"
            + "\n        O O _ O O"
            + "\n        O O _ O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O"
            + "\n        O O O O O";
    customBoard.move(2, 6, 4, 6);
    assertEquals(oneMoveOut, customBoard.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfBounds() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(2, 1, -4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPositionCell() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(1, 1, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDistCell() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(2, 1, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToCell() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(2, 1, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFromCell() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(3, 3, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMiddleCell() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(1, 3, 3, 3);
    moveBoard.move(3, 3, 1, 3);
  }

  // getGameState() tests
  @Test
  public void testGetGameState() {
    assertEquals(defaultOut, defaultBoard.getGameState());
    assertEquals(setEmptyOut, setEmpty.getGameState());
    assertEquals(setThicknessOut, setThickness.getGameState());
    assertEquals(setParamsOut, setAllParams.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenArmThickness() {
    new MarbleSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeArmThickness() {
    new MarbleSolitaireModelImpl(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmptyCell() {
    new MarbleSolitaireModelImpl(1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidParams() {
    new MarbleSolitaireModelImpl(5, 0, 0);
  }

  // getScore() tests
  @Test
  public void testGetInitScore() {
    assertEquals(32, defaultBoard.getScore());
    assertEquals(104, setThickness.getScore());
  }

  @Test
  public void testScoreAfterMove() {
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    moveBoard.move(3, 1, 3, 3);
    assertEquals(31, moveBoard.getScore());
    moveBoard.move(3, 4, 3, 2);
    assertEquals(30, moveBoard.getScore());
  }

  // isGameOver() tests
  @Test
  public void testGameNotOver() {
    assertEquals(false, this.defaultBoard.isGameOver());

    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();

    moveBoard.move(1, 3, 3, 3);
    String moveOut = "    O O O"
            + "\n    O _ O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";

    moveBoard.move(4, 3, 2, 3);
    moveOut = "    O O O"
            + "\n    O _ O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O _ O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());

    //moveBoard.move();

    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(moveOut, moveBoard.getGameState());
  }
}

