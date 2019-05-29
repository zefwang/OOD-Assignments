package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;

/**
 * Class that acts as the entry point to the MarbleSolitaire game.
 */
public class MarbleSolitaire {
  /**
   * The main method which accepts command line arguments.
   *
   * @param args The arguments that determine the board type and and actions.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel ms = new MarbleSolitaireModelImpl();

    switch (args[0]) {
      case "english":
        if (args.length == 1) {
          ms = new MarbleSolitaireModelImpl();
        } else if (args[1].equals("-size")) {
          ms = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]));
        } else {
          ms = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
        }
        break;
      case "european":
        if (args.length == 1) {
          ms = new EuropeanSolitaireModelImpl();
        } else if (args[1].equals("-size")) {
          ms = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]));
        } else {
          ms = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
        }
        break;
      case "triangular":
        if (args.length == 1) {
          ms = new TriangleSolitaireModelImpl();
        } else if (args[1].equals("-size")) {
          ms = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]));
        } else {
          ms = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
        }
        break;
      default:
        //No other cases, here to satisfy the Handin Server
    }

    //Used for personal testing purposes
    System.out.println(ms.getGameState());
  }
}

