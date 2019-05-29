import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the TriangleSolitaireImpl class.
 */
public class TriangleModelImplTests {
  private MarbleSolitaireModel defaultTest = new TriangleSolitaireModelImpl();

  private String defaultOut =
          "    _"
                  + "\n   O O"
                  + "\n  O O O"
                  + "\n O O O O"
                  + "\nO O O O O";

  @Test
  public void testDefaultGameState() {
    assertEquals(defaultOut, defaultTest.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove(){
    defaultTest.move(2, 1, 0, 0);
    System.out.println(defaultTest.getGameState());
  }
}
