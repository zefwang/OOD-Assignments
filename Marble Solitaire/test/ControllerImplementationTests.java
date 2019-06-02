import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class contains tests for the public methods of the MarbleSolitaireConstructorImpl class. It
 * provides thorough tests for the playGame() method. Each method uses a ModelImpl, European, and
 * Triangle board.
 */

public class ControllerImplementationTests {

  @Test
  public void oneMoveTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneMove = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O\nScore: 31"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 31";

    assertEquals(oneMove, out.toString());
  }

  @Test
  public void oneMoveEuro() {
    StringBuffer euroOut = new StringBuffer();
    StringReader euroIn = new StringReader("4 2 4 4 q");
    MarbleSolitaireModel testEuro = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(euroIn, euroOut);

    test.playGame(testEuro);

    String euroMove = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O\nScore: 35"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 35";

    assertEquals(euroMove, euroOut.toString());
  }

  @Test
  public void oneMoveTriangle() {
    StringBuffer out = new StringBuffer();
    StringReader in = new StringReader("3 1 1 1 q");
    MarbleSolitaireModel testTriangle = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testTriangle);

    String triangleMove = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\n    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O\nScore: 13"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O\nScore: 13";

    assertEquals(triangleMove, out.toString());
  }

  @Test
  public void multiMovesTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 4 5 4 3 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMoves = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 31"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30";

    assertEquals(twoMoves, out.toString());
  }

  @Test
  public void multiMovesEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 4 5 4 3 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMoves = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 35"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34";

    assertEquals(twoMoves, out.toString());
  }

  @Test
  public void multiMovesTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 1 3 3 3 1 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMoves = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\n    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O\nScore: 13"
            + "\n    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O\nScore: 12"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O\nScore: 12";


    assertEquals(twoMoves, out.toString());
  }

  @Test
  public void letterInMiddleTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 a 4 4 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneMove = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O\nScore: 31"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 31";

    assertEquals(oneMove, out.toString());
  }

  @Test
  public void letterInMiddleEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 a 4 4 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneMove = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O\nScore: 35"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 35";

    assertEquals(oneMove, out.toString());
  }

  @Test
  public void letterInMiddleTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 a 1 1 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneMove = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O\nScore: 13"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O\nScore: 13";

    assertEquals(oneMove, out.toString());
  }

  @Test
  public void letterSeparatingMovesTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 a 4 5 4 3 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMove = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 31"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30";

    assertEquals(twoMove, out.toString());
  }

  @Test
  public void letterSeparatingMovesEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 4 a 4 5 4 3 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);


    String twoMove = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 35"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34";

    assertEquals(twoMove, out.toString());

  }

  @Test
  public void letterSeparatingMovesTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 1 a 3 3 3 1 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);


    String twoMove = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\n    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 13"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O\nScore: 12"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O\nScore: 12";

    assertEquals(twoMove, out.toString());
  }

  @Test
  public void multiLettersTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 b 4 4 a 4 5 4 3 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMove = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nInvalid move. Play again. \"b\" is not a valid input"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 31"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 30";

    assertEquals(twoMove, out.toString());
  }

  @Test
  public void multiLettersEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 b 4 4 a 4 5 4 3 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMove = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nInvalid move. Play again. \"b\" is not a valid input"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ _ O O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 35"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO _ O _ _ O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 34";

    assertEquals(twoMove, out.toString());
  }

  @Test
  public void multiLettersTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 b 1 1 a 3 3 3 1 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoMove = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nInvalid move. Play again. \"b\" is not a valid input"
            + "\n    O"
            + "\n   _ O"
            + "\n  _ O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 13"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\n    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 12"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O"
            + "\n   _ O"
            + "\n  O _ _"
            + "\n O O O O"
            + "\nO O O O O\nScore: 12";

    assertEquals(twoMove, out.toString());
  }

  @Test
  public void oneLetter() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nInvalid move. Play again. \"a\" is not a valid input\n"
            + "Game quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void oneLetterEuropean() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nInvalid move. Play again. \"a\" is not a valid input\n"
            + "Game quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void oneLetterTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nInvalid move. Play again. \"a\" is not a valid input\n"
            + "Game quit!\nState of game when quit:\n"
            + "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void multiLetters() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a % q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String twoInvalid = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\nInvalid move. Play again. \"%\" is not a valid input"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32";

    assertEquals(twoInvalid, out.toString());
  }

  @Test
  public void multiLettersEuroNo() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a % q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\nInvalid move. Play again. \"%\" is not a valid input"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void multiLettersTriangleNo() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("a % q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nInvalid move. Play again. \"a\" is not a valid input"
            + "\nInvalid move. Play again. \"%\" is not a valid input"
            + "\nGame quit!\nState of game when quit:\n"
            + "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void oneQuit() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneQuit = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32";

    assertEquals(oneQuit, out.toString());
  }

  @Test
  public void oneQuitEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void oneQuitTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nGame quit!\nState of game when quit:\n"
            + "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void quitInMiddle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 q 4 4");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneQuit = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32";

    assertEquals(oneQuit, out.toString());
  }

  @Test
  public void quitInMiddleEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 q 4 4");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void quitInMiddleTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 q 1 1");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nGame quit!\nState of game when quit:\n"
            + "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void quitBeforeEnd() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 q 4");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneQuit = "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n    O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n    O O O"
            + "\n    O O O"
            + "\nScore: 32";

    assertEquals(oneQuit, out.toString());
  }

  @Test
  public void quitBeforeEndEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 2 4 q 4");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36"
            + "\nGame quit!\nState of game when quit:\n"
            + "    O O O"
            + "\n  O O O O O"
            + "\nO O O O O O O"
            + "\nO O O _ O O O"
            + "\nO O O O O O O"
            + "\n  O O O O O"
            + "\n    O O O"
            + "\nScore: 36";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void quitBeforeEndTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 q 1");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    String oneInvalid = "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14"
            + "\nGame quit!\nState of game when quit:\n"
            + "    _"
            + "\n   O O"
            + "\n  O O O"
            + "\n O O O O"
            + "\nO O O O O"
            + "\nScore: 14";

    assertEquals(oneInvalid, out.toString());
  }

  @Test
  public void gameCompleteTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 3 2 3 4 3 5 3 3 1 5 3 5 1 3 1 5 3 3 1 3 4 5 2 5 5 3 " +
            "3 3  5 4 3 4 3 3 3 5 2 5 4 5 5 5 3 5 5 2 3 2 3 1 3 3 3 6 3 4 5 6 3 6 3 7 3 5 3 4 3 2" +
            " 5 1 3 1 3 1 3 3 5 7 3 7 7 3 5 3 6 5 6 3 5 3 7 3");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Game over!"));
  }

  @Test
  public void completeGameEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 3 2 3 4 3 5 3 3 1 5 3 5 1 3 1 5 3 3 1 3 4 5 2 5 5 3 " +
            "3 3  5 4 3 4 3 3 3 5 2 5 4 5 5 5 3 5 5 2 3 2 3 1 3 3 3 6 3 4 5 6 3 6 3 7 3 5 3 4 3 2" +
            " 5 1 3 1 3 1 3 3 5 7 3 7 7 3 5 3 6 5 6 3 5 3 7 3");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Game over!"));
  }

  @Test
  public void completeGameTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("3 1 1 1 3 3 3 1 1 1 3 3 5 2 3 2 4 4 4 2 3 2 5 2 4 1 2 1");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Game over!"));
  }

  @Test
  public void invalidMove() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test
  public void invalidMoveEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test
  public void invalidMoveTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test
  public void outOfBoundMove() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 -1 4 5 q");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test
  public void outOfBoundMoveEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 -1 4 5 q");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test
  public void outOfBoundMoveTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 -1 4 5 q");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);

    assertTrue(out.toString().contains("Invalid move. Play again. " +
            "The move could not be completed."));
  }

  @Test(expected = IllegalStateException.class)
  public void threeInputsTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void threeInputsTestEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void threeInputsTestTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void sixInputsTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 4 2");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void sixInputsTestEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 4 2");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void sixInputsTestTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5 4 2");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void noQuitOrEnd() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void noQuitOrEndEuro() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void noQuitOrEndTriangle() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(testModel);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullModelTest() {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, out);

    test.playGame(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullReadableTest() {
    StringBuffer out = new StringBuffer();

    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(null, out);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullAppendableTest() {
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, null);
  }

  @Test(expected = IllegalStateException.class)
  public void appendableErrorTest() {
    Appendable ap = new AppendableException();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new MarbleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, ap);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void appendableErrorTestEuro() {
    Appendable ap = new AppendableException();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new EuropeanSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, ap);

    test.playGame(testModel);
  }

  @Test(expected = IllegalStateException.class)
  public void appendableErrorTestTriangle() {
    Appendable ap = new AppendableException();
    Reader in = new StringReader("4 3 4 5");

    MarbleSolitaireModel testModel = new TriangleSolitaireModelImpl();
    MarbleSolitaireController test = new MarbleSolitaireControllerImpl(in, ap);

    test.playGame(testModel);
  }
}
