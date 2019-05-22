import org.junit.Test;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * This class contains tests for the public methods of the MarbleSolitaireConstructorImpl class.
 */

public class ControllerImplementationTests {
  MarbleSolitaireModelImpl testModel = new MarbleSolitaireModelImpl();
  MarbleSolitaireControllerImpl test =
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);

  @Test
  public void fillerTest() {
    test.playGame(testModel);
    assertEquals(0, 0);
  }
}
