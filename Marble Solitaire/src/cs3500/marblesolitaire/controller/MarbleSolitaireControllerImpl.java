package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This class represents an implementation of a controller for MarbleSolitaire. This controller
 * allows the user to play the game using an instance of MarbleSolitaireModel.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private final Readable rd;
  private final Appendable ap;

  /**
   * Constructs a {@code MarbleSolitaireControllerImpl} object. Creates an instance using the user
   * given Readable and Appendable objects.
   *
   * @param rd Represents the Readable object for this class (ie. info FROM user).
   * @param ap Represents the Appendable object for this class (ie. info TO user).
   * @throws IllegalArgumentException if the Readable and/or Appendable are null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Null argument");
    }
    this.rd = rd;
    this.ap = ap;
  }

  /**
   * This method allows the user to play the game of Marble Solitaire.
   *
   * @param model This is the model for the game of Marble Solitaire.
   * @throws IllegalArgumentException if a null model is passed.
   */
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Null model provided");
    }
    Scanner in = new Scanner(this.rd);
    boolean noQuit = true;
    String nextVal;

    // Initial gameState and score
    this.appendTryCatch(model.getGameState() + "\nScore: " + model.getScore() + "\n");

    ArrayList<Integer> input = new ArrayList<>();

    while (!model.isGameOver()) {
      // Parse through all the Readable data
      if (in.hasNext()) {
        // Takes the next user input
        nextVal = in.next();

        // Quit if q or Q
        if (nextVal.equals("q") || nextVal.equals("Q")) {
          noQuit = false;
          this.appendTryCatch("Game quit!\nState of game when quit:\n" + model.getGameState()
                  + "\nScore: " + model.getScore());
          break;
        } else {
          // Determine if is a number, otherwise invalid letter
          try {
            input.add(Integer.parseInt(nextVal));
          } catch (IllegalArgumentException e) {
            this.appendTryCatch("Invalid move. Play again. \"" + nextVal
                    + "\" is not a valid input\n");
          }
        }

        this.tryMove(input, model);

      } else {
        throw new IllegalStateException("Out of inputs");
      }
    }

    if (noQuit) {
      this.appendTryCatch("Game over!\n" + model.getGameState() + "\nScore: "
              + model.getScore() + "\n");
    }
  }

  private void tryMove(ArrayList<Integer> input, MarbleSolitaireModel model) {
    // Run through the numerical inputs
    while (input.size() >= 4) {
      // Add the positions (-1 because user input starts at 1)
      int fromRow = input.get(0) - 1;
      int fromCol = input.get(1) - 1;
      int toRow = input.get(2) - 1;
      int toCol = input.get(3) - 1;

      // Remove the four elements
      input.remove(0);
      input.remove(0);
      input.remove(0);
      input.remove(0);

      try {
        model.move(fromRow, fromCol, toRow, toCol);
      } catch (IllegalArgumentException e) {
        this.appendTryCatch("Invalid move. Play again. The move could not be completed.");
      }

      this.appendTryCatch(model.getGameState() + "\nScore: " + model.getScore() + "\n");
    }
  }

  private void appendTryCatch(String msg) {
    try {
      ap.append(msg);
    } catch (IOException f) {
      throw new IllegalStateException("Error with Readable or Appendable");
    }
  }
}
