import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the MarbleSolitaireModelImpl class.
 */
public class ModelImplementationTests {

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
    MarbleSolitaireModelImpl moveBoard = new MarbleSolitaireModelImpl();
    String moveOut = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(false, moveBoard.isGameOver());
    assertEquals(moveOut, moveBoard.getGameState());

    moveBoard.move(1, 3, 3, 3);
    moveOut = "    O O O"
            + "\n    O _ O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 1, 2, 3);
    moveOut = "    O O O"
            + "\n    O _ O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 4, 2, 2);
    moveOut = "    O O O"
            + "\n    O _ O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(0, 4, 2, 4);
    moveOut = "    O O _"
            + "\n    O _ _"
            + "\nO _ O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(0, 2, 0, 4);
    moveOut = "    _ _ O"
            + "\n    O _ _"
            + "\nO _ O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 2, 0, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\nO _ _ _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(3, 4, 1, 4);
    moveOut = "    O _ O"
            + "\n    _ _ O"
            + "\nO _ _ _ _ O O"
            + "\nO O O O _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 2, 2, 2);
    moveOut = "    O _ O"
            + "\n    _ _ O"
            + "\nO _ O _ _ O O"
            + "\nO O _ O _ O O"
            + "\nO O _ O O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 3, 2, 3);
    moveOut = "    O _ O"
            + "\n    _ _ O"
            + "\nO _ O O _ O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 2, 2, 4);
    moveOut = "    O _ O"
            + "\n    _ _ O"
            + "\nO _ _ _ O O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(1, 4, 3, 4);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\nO _ _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\nO O _ _ O O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 4, 2, 4);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\nO _ _ _ O O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ _ O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 1, 2, 1);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\nO O _ _ O O O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 0, 2, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O O O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 5, 2, 3);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O O _ _ O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 5, 2, 5);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O O _ O O"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 6, 2, 4);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O O O _ _"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 3, 2, 1);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ O _ _ O _ _"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 0, 2, 0);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\nO O _ _ O _ _"
            + "\n_ _ _ _ _ _ O"
            + "\n_ _ _ _ _ _ O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 0, 2, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O _ _"
            + "\n_ _ _ _ _ _ O"
            + "\n_ _ _ _ _ _ O"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 6, 2, 6);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ _ _ _ _ _"
            + "\n    O O O"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(6, 2, 4, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ O _ _ _ _"
            + "\n    _ O O"
            + "\n    _ O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(5, 4, 5, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ O _ _ _ _"
            + "\n    O _ _"
            + "\n    _ O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 2, 6, 2);
    moveOut = "    O _ O"
            + "\n    _ _ _"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ _ _ _ _ _"
            + "\n    _ _ _"
            + "\n    O O O";
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(true, moveBoard.isGameOver());
  }
}

