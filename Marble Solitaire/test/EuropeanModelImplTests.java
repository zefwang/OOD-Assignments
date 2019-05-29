import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains the tests for the public methods of the EuropeanSolitaireModelImpl class.
 */
public class EuropeanModelImplTests {
  private MarbleSolitaireModel defaultTest = new EuropeanSolitaireModelImpl();

  private String defaultOut = "    O O O"
          + "\n  O O O O O"
          + "\nO O O O O O O"
          + "\nO O O _ O O O"
          + "\nO O O O O O O"
          + "\n  O O O O O"
          + "\n    O O O";

  private MarbleSolitaireModel customEmpty = new EuropeanSolitaireModelImpl(3,0, 2);

  private String emptyOut = "    _ O O"
          + "\n  O O O O O"
          + "\nO O O O O O O"
          + "\nO O O O O O O"
          + "\nO O O O O O O"
          + "\n  O O O O O"
          + "\n    O O O";


  @Test
  public void testDefaultGameState() {
    assertEquals(defaultOut, defaultTest.getGameState());
  }

  @Test
  public void testCustomGameState(){
    assertEquals(emptyOut, customEmpty.getGameState());
  }
}
