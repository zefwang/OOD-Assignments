import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the TriangleSolitaireImpl class.
 */
public class TriangleModelImplTests {

  @Test
  public void testDefaultGameState() {
    MarbleSolitaireModel defaultTest = new TriangleSolitaireModelImpl();
    String defaultOut = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O";
    assertEquals(defaultOut, defaultTest.getGameState());

    MarbleSolitaireModel sideLength = new TriangleSolitaireModelImpl(6);
    String sideOut = "     _"
            + "\n    O O"
            + "\n   O O O"
            + "\n  O O O O"
            + "\n O O O O O"
            + "\nO O O O O O";
    assertEquals(sideOut, sideLength.getGameState());

    MarbleSolitaireModel cellTest = new TriangleSolitaireModelImpl(3, 3);
    String cellOut = "    O"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O _"
            + "\nO O O O O";
    assertEquals(cellOut, cellTest.getGameState());

    MarbleSolitaireModel allCustTest = new TriangleSolitaireModelImpl(4, 2, 2);
    String custOut = "   O"
            + "\n  O O"
            + "\n O O _"
            + "\nO O O O";
    assertEquals(custOut, allCustTest.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSideLength() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl(-4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidEmptyCell() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl(10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfBoundsCell() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl(4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAll() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl(-3, 5, 6);
  }

  @Test
  public void testAllDirections() {
    MarbleSolitaireModel moveBoard = new TriangleSolitaireModelImpl(6, 5, 3);

    moveBoard.move(3, 1, 5, 3);
    String moveOut = "     O"
            + "\n    O O"
            + "\n   O O O"
            + "\n  O _ O O"
            + "\n O O _ O O"
            + "\nO O O O O O";
    assertEquals(moveOut, moveBoard.getGameState());

    moveBoard = new TriangleSolitaireModelImpl(6, 5, 3);
    moveBoard.move(3, 3, 5, 3);
    moveOut = "     O"
            + "\n    O O"
            + "\n   O O O"
            + "\n  O O O _"
            + "\n O O O _ O"
            + "\nO O O O O O";
    assertEquals(moveOut, moveBoard.getGameState());

    moveBoard = new TriangleSolitaireModelImpl(6, 5, 3);
    moveBoard.move(5, 1, 5, 3);
    moveOut = "     O"
            + "\n    O O"
            + "\n   O O O"
            + "\n  O O O O"
            + "\n O O O O O"
            + "\nO _ _ O O O";
    assertEquals(moveOut, moveBoard.getGameState());

    moveBoard = new TriangleSolitaireModelImpl(6, 5, 3);
    moveBoard.move(5, 5, 5, 3);
    moveOut = "     O"
            + "\n    O O"
            + "\n   O O O"
            + "\n  O O O O"
            + "\n O O O O O"
            + "\nO O O O _ _";
    assertEquals(moveOut, moveBoard.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMoveTooFar() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(4, 4, 4, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToCell() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(2, 1, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFromCell() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(-2, 1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFromMove() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(2, 1, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidToMove() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(2, 1, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyFrom() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(0, 0, 2, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEmptyMiddle() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(-1, 1, 1, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMarbleInTo() {
    MarbleSolitaireModel invalid = new TriangleSolitaireModelImpl();
    invalid.move(2, 1, 4, 1);
  }

  @Test
  public void testInitScore() {
    MarbleSolitaireModel def = new TriangleSolitaireModelImpl();
    assertEquals(14, def.getScore());

    MarbleSolitaireModel custom = new TriangleSolitaireModelImpl(8);
    assertEquals(35, custom.getScore());
  }

  @Test
  public void testInitGameOver() {
    MarbleSolitaireModel newGame = new TriangleSolitaireModelImpl();
    assertEquals(false, newGame.isGameOver());
  }

  @Test
  public void testFullGame() {
    MarbleSolitaireModel test = new TriangleSolitaireModelImpl();

    test.move(2, 0, 0, 0);
    String testOut = "    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(13, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(2, 2, 2, 0);
    testOut = "    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(12, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(0, 0, 2, 2);
    testOut = "    _"
            + "\n   _ _"
            + "\n  O _ O"
            + "\n O O O O"
            + "\nO O O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(11, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(4, 1, 2, 1);
    testOut = "    _"
            + "\n   _ _"
            + "\n  O O O"
            + "\n O _ O O"
            + "\nO _ O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(10, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(3, 3, 3, 1);
    testOut = "    _"
            + "\n   _ _"
            + "\n  O O O"
            + "\n O O _ _"
            + "\nO _ O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(9, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(2, 1, 4, 1);
    testOut = "    _"
            + "\n   _ _"
            + "\n  O _ O"
            + "\n O _ _ _"
            + "\nO O O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(8, test.getScore());
    assertEquals(false, test.isGameOver());

    test.move(3, 0, 1, 0);
    testOut = "    _"
            + "\n   O _"
            + "\n  _ _ O"
            + "\n _ _ _ _"
            + "\nO O O O O";
    assertEquals(testOut, test.getGameState());
    assertEquals(7, test.getScore());
    assertEquals(true, test.isGameOver());
  }
}
