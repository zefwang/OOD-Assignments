package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the operations offered by the marble solitaire controller. One object
 * of the controller represents one game of marble solitaire.
 */

public interface MarbleSolitaireController {
  /**
   * This method allows the user to play a game using a MarbleSolitaireModel.
   *
   * @param model This is the model for the game of Marble Solitaire.
   * @throws IllegalArgumentException if the model is null,
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException;
}
