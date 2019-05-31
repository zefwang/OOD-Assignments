package cs3500.marblesolitaire;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

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
        } else if (args[1].equals("-size") && args[3].equals("-hole")) {
          ms = new MarbleSolitaireModelImpl(Integer.parseInt(args[2]), Integer.parseInt(args[4]),
                  Integer.parseInt(args[5]));
        } else if (args[1].equals("-hole") && args[4].equals("-size")) {
          ms = new MarbleSolitaireModelImpl(Integer.parseInt(args[5]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
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
        } else if (args[1].equals("-size") && args[3].equals("-hole")) {
          ms = new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]), Integer.parseInt(args[4]),
                  Integer.parseInt(args[5]));
        } else if (args[1].equals("-hole") && args[4].equals("-size")) {
          ms = new EuropeanSolitaireModelImpl(Integer.parseInt(args[5]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
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
        } else if (args[1].equals("-size") && args[3].equals("-hole")) {
          ms = new TriangleSolitaireModelImpl(Integer.parseInt(args[2]), Integer.parseInt(args[4]),
                  Integer.parseInt(args[5]));
        } else if (args[1].equals("-hole") && args[4].equals("-size")) {
          ms = new TriangleSolitaireModelImpl(Integer.parseInt(args[5]), Integer.parseInt(args[2]),
                  Integer.parseInt(args[3]));
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

