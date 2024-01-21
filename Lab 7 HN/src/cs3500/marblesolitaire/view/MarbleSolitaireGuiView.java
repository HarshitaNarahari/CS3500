package cs3500.marblesolitaire.view;
import cs3500.marblesolitaire.controller.ControllerFeatures;

/**
 * This interface represents a GUI view for the game of marble solitaire.
 */
public interface MarbleSolitaireGuiView {
  /**
   * Refresh the screen. This is called when the something on the
   * screen is updated and therefore it must be redrawn.
   */
  void refresh();

  /**
   * Display a message in a suitable area of the GUI.
   * @param message the message to be displayed
   */
  void renderMessage(String message);

  /**
   * Accepts an object of the ControllerFeatures interface
   * @param features the ControllerFeatures to be added
   */
  void input(ControllerFeatures features);

}
