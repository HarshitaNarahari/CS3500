package cs3500.marblesolitaire.view;

import java.awt.*;
import javax.swing.*;

import cs3500.marblesolitaire.controller.ControllerFeatures;
import cs3500.marblesolitaire.model.MarbleSolitaireModelState;

/**
 * This class represents a GUI view that is implemented using Java
 * Swing.
 */
public class SwingGuiView extends JFrame implements MarbleSolitaireGuiView {

  // panel board is drawn on
  private IBoardPanel boardPanel;
  // model state
  private MarbleSolitaireModelState modelState;
  // to display the score
  private JLabel scoreLabel;
  //a label to display any messages to the user
  private JLabel messageLabel;

  /**
   * the constructor
   * @param state represents the model state
   */
  public SwingGuiView(MarbleSolitaireModelState state) {
    super("Marble solitaire");
    this.modelState = state;
    /* main frame uses a border layout. Read about it here:
     *
     * */
    this.setLayout(new BorderLayout());
    //initialize the custom board with the model state
    boardPanel = new BoardPanel(this.modelState);
    //add custom board to the center of the frame
    this.add((Component) boardPanel,BorderLayout.CENTER);
    //create the score label
    this.scoreLabel = new JLabel();
    //create the message label
    this.messageLabel = new JLabel();
    //put them both in a panel. This is done mostly to arrange them properly
    JPanel panel = new JPanel();
    /*
    the panel uses a grid layout with two columns. The gridlayout
    will stretch the labels so that they are exactly half of the width
    of this panel.
    Since we mention that we want a grid of 2 columns, and we
    add exactly two things to it, it will use one row.
     */
    panel.setLayout(new GridLayout(0,2));
    panel.add(scoreLabel);
    panel.add(messageLabel);
    //add this panel to the bottom of the frame
    this.add(panel,BorderLayout.PAGE_END);
    pack();
    setVisible(true);
  }

  /**
   * Refreshes the score
   */
  public void refresh() {
    //refresh the score
    this.scoreLabel.setText("Score: "+modelState.getScore());
    //this repaints the frame, which cascades to everything added
    //in the frame
    this.repaint();
  }

  /**
   * Displays a given message
   *
   * @param message the message to be displayed
   */
  @Override
  public void renderMessage(String message) {
    this.messageLabel.setText(message);
  }

  /**
   * Takes controller features as inputs
   *
   * @param controllerFeatures features of the controller
   */
  @Override
  public void input(ControllerFeatures controllerFeatures) {
    boardPanel.setFeatures(controllerFeatures);
  }
}