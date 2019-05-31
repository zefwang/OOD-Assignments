import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the EuropeanSolitaireModelImpl class.
 */
public class EuropeanModelImplTests {
  private MarbleSolitaireModel defaultTest = new EuropeanSolitaireModelImpl();

  private MarbleSolitaireModel setSideLength = new EuropeanSolitaireModelImpl(5);

  private MarbleSolitaireModel setCell = new EuropeanSolitaireModelImpl(2, 6);

  private MarbleSolitaireModel setAll =
          new EuropeanSolitaireModelImpl(3, 0, 2);

  @Test
  public void testGetGameState() {
    String defaultOut = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";

    String sideCustomOut =
            "        O O O O O"
                    + "\n      O O O O O O O"
                    + "\n    O O O O O O O O O"
                    + "\n  O O O O O O O O O O O"
                    + "\nO O O O O O O O O O O O O"
                    + "\nO O O O O O O O O O O O O"
                    + "\nO O O O O O _ O O O O O O"
                    + "\nO O O O O O O O O O O O O"
                    + "\nO O O O O O O O O O O O O"
                    + "\n  O O O O O O O O O O O"
                    + "\n    O O O O O O O O O"
                    + "\n      O O O O O O O"
                    + "\n        O O O O O";

    String cellCustomOut = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O _"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";

    String allCustomOut = "    _ O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(defaultOut, defaultTest.getGameState());
    assertEquals(sideCustomOut, setSideLength.getGameState());
    assertEquals(allCustomOut, setAll.getGameState());
    assertEquals(cellCustomOut, setCell.getGameState());
  }

  @Test
  public void testOneMove() {
    //Down
    defaultTest.move(1, 3, 3, 3);
    String defaultOut = "    O O O"
            + "\n  O O _ O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(defaultOut, defaultTest.getGameState());

    //Up
    setSideLength.move(8, 6, 6, 6);
    String sideCustomOut = "        O O O O O"
            + "\n      O O O O O O O"
            + "\n    O O O O O O O O O"
            + "\n  O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O O O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\nO O O O O O _ O O O O O O"
            + "\n  O O O O O O O O O O O"
            + "\n    O O O O O O O O O"
            + "\n      O O O O O O O"
            + "\n        O O O O O";
    assertEquals(sideCustomOut, setSideLength.getGameState());

    //Right
    setCell.move(2, 4, 2, 6);
    String cellCustomOut = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O _ _ O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(cellCustomOut, setCell.getGameState());

    //Left
    setAll.move(0, 4, 0, 2);
    String allCustomOut = "    O _ _"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(allCustomOut, setAll.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyFrom() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(3, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleTo() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(4, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMiddle() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(2, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidTo() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(3, 5, 3, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFrom() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(1, 0, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveTooFar() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(0, 3, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiagonalMove() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    defBoard.move(1, 1, 3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEvenArm() {
    MarbleSolitaireModel invalid = new EuropeanSolitaireModelImpl(4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeArm() {
    MarbleSolitaireModel invalid = new EuropeanSolitaireModelImpl(-5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArmInvalid() {
    MarbleSolitaireModel invalid = new EuropeanSolitaireModelImpl(-4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCell() {
    MarbleSolitaireModel invalid = new EuropeanSolitaireModelImpl(0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAll() {
    MarbleSolitaireModel invalid = new EuropeanSolitaireModelImpl(4, 1, 0);
  }

  @Test
  public void testInitScore() {
    MarbleSolitaireModel defBoard = new EuropeanSolitaireModelImpl();
    assertEquals(36, defBoard.getScore());

    MarbleSolitaireModel custBoard = new EuropeanSolitaireModelImpl(5);
    assertEquals(128, custBoard.getScore());
  }

  @Test
  public void testIsGameOver() {
    MarbleSolitaireModel notOver = new EuropeanSolitaireModelImpl();
    assertEquals(false, notOver.isGameOver());
  }

  @Test
  public void testGameToEnd() {
    MarbleSolitaireModel moveBoard = new EuropeanSolitaireModelImpl();
    String moveOut = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(36, moveBoard.getScore());
    assertEquals(false, moveBoard.isGameOver());
    assertEquals(moveOut, moveBoard.getGameState());

    moveBoard.move(1, 3, 3, 3);
    moveOut = "    O O O"
            + "\n  O O _ O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(35, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 1, 2, 3);
    moveOut = "    O O O"
            + "\n  O O _ O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(34, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 4, 2, 2);
    moveOut = "    O O O"
            + "\n  O O _ O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(33, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(0, 4, 2, 4);
    moveOut = "    O O _"
            + "\n  O O _ _ O"
            + "\nO _ O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(32, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(0, 2, 0, 4);
    moveOut = "    _ _ O"
            + "\n  O O _ _ O"
            + "\nO _ O _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(31, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 2, 0, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\nO _ _ _ O O O"
            + "\nO O O O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(30, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(3, 4, 1, 4);
    moveOut = "    O _ O"
            + "\n  O _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\nO O O O _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(29, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 2, 2, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ O O"
            + "\nO _ O _ _ O O"
            + "\nO O _ O _ O O"
            + "\nO O _ O O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(28, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 3, 2, 3);
    moveOut = "    O _ O"
            + "\n  O _ _ O O"
            + "\nO _ O O _ O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(27, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 2, 2, 4);
    moveOut = "    O _ O"
            + "\n  O _ _ O O"
            + "\nO _ _ _ O O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(26, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(1, 4, 3, 4);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\nO _ _ _ _ O O"
            + "\nO O _ _ O O O"
            + "\nO O _ _ O O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(25, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 4, 2, 4);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\nO _ _ _ O O O"
            + "\nO O _ _ _ O O"
            + "\nO O _ _ _ O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(24, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 1, 2, 1);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\nO O _ _ O O O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(23, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 0, 2, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O O O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(22, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 5, 2, 3);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O O _ _ O"
            + "\nO _ _ _ _ O O"
            + "\nO _ _ _ _ O O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(21, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 5, 2, 5);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O O _ O O"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(20, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 6, 2, 4);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O O O _ _"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(19, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 3, 2, 1);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ O _ _ O _ _"
            + "\nO _ _ _ _ _ O"
            + "\nO _ _ _ _ _ O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(18, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 0, 2, 0);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\nO O _ _ O _ _"
            + "\n_ _ _ _ _ _ O"
            + "\n_ _ _ _ _ _ O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(17, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(2, 0, 2, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O _ _"
            + "\n_ _ _ _ _ _ O"
            + "\n_ _ _ _ _ _ O"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(16, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 6, 2, 6);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ _ _ _ _ _"
            + "\n  O O O O O"
            + "\n    O O O";
    assertEquals(15, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(6, 2, 4, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ O _ _ _ _"
            + "\n  O _ O O O"
            + "\n    _ O O";
    assertEquals(14, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(5, 4, 5, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ O _ _ _ _"
            + "\n  O O _ _ O"
            + "\n    _ O O";
    assertEquals(13, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(false, moveBoard.isGameOver());

    moveBoard.move(4, 2, 6, 2);
    moveOut = "    O _ O"
            + "\n  O _ _ _ O"
            + "\n_ _ O _ O _ O"
            + "\n_ _ _ _ _ _ _"
            + "\n_ _ _ _ _ _ _"
            + "\n  O _ _ _ O"
            + "\n    O O O";
    assertEquals(12, moveBoard.getScore());
    assertEquals(moveOut, moveBoard.getGameState());
    assertEquals(true, moveBoard.isGameOver());
  }
}
