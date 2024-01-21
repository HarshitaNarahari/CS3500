package cs3500.marblesolitaire.controller;

/**
 * This interface represents a Marble Solitaire controller
 */
public interface MarbleSolitaireController {

  /**
   * Plays a new Marble Solitaire game
   *
   * @throws IllegalArgumentException if there is an illegal argument
   */
  void playGame() throws IllegalArgumentException;
}
