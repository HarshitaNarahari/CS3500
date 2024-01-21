package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.controller.ControllerFeatures;

/**
 * This class represents a GUI view that is implemented using Java
 * Swing.
 */
public class SwingGuiViewMock implements MarbleSolitaireGuiView {
  Appendable appendable;

  /**
   * the constructor
   * @param appendable represents the appendable given to mock
   */
  public SwingGuiViewMock(Appendable appendable) {
    this.appendable = appendable;
  }

  /**
   * Refreshes the score
   */
  public void refresh() {
    try {
      appendable.append("refresh" + "\n");
    } catch (Exception e) {
      throw new IllegalStateException("Could not transmit to appendable");
    }

  }

  /**
   * Displays a given message
   *
   * @param message the message to be displayed
   */
  @Override
  public void renderMessage(String message) {
    try {
      appendable.append(message + "\n");
    } catch (Exception e) {
      throw new IllegalStateException("Could not transmit to appendable");
    }

  }

  /**
   * Takes controller features as inputs
   *
   * @param controllerFeatures features of the controller
   */
  @Override
  public void input(ControllerFeatures controllerFeatures) {
    try {
      appendable.append("input" + "\n");
    } catch (Exception e) {
      throw new IllegalStateException("Could not transmit to appendable");
    }
  }
}