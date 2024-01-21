package cs3500.marblesolitaire.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import cs3500.marblesolitaire.controller.ControllerFeatures;
import cs3500.marblesolitaire.model.MarbleSolitaireModelState;

/**
 * to represent a board panel
 */
public class BoardPanel extends JPanel implements IBoardPanel {
  private MarbleSolitaireModelState modelState;
  private Image emptySlot, marbleSlot, blankSlot;
  private final int cellDimension;
  private int originX, originY;
  private ControllerFeatures features;
  private int highlightRow, highlightCol;

  /**
   * Default constructor
   *
   * @param state representing the model state
   * @throws IllegalStateException if there are no icons
   */
  public BoardPanel(MarbleSolitaireModelState state) throws IllegalStateException {
    super();
    this.modelState = state;
    this.setBackground(Color.WHITE);
    this.cellDimension = 50;
    try {
      emptySlot = ImageIO.read(new FileInputStream("res/empty.png"));
      emptySlot = emptySlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      marbleSlot = ImageIO.read(new FileInputStream("res/marble.png"));
      marbleSlot = marbleSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      blankSlot = ImageIO.read(new FileInputStream("res/blank.png"));
      blankSlot = blankSlot.getScaledInstance(cellDimension, cellDimension, Image.SCALE_DEFAULT);

      this.setPreferredSize(
              new Dimension((this.modelState.getBoardSize() + 4) * cellDimension
                      , (this.modelState.getBoardSize() + 4) * cellDimension));
    } catch (IOException e) {
      throw new IllegalStateException("No icons");
    }

  }

  /**
   * Draws the board
   *
   * @param g the <code>Graphics</code> object to protect
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g3d = (Graphics2D) g;
    originX = (int) (this.getPreferredSize().getWidth() / 2 - this.modelState.getBoardSize()
            * cellDimension / 2);
    originY = (int) (this.getPreferredSize().getHeight() / 2 - this.modelState.getBoardSize()
            * cellDimension / 2);

    for (int i = 0; i < this.modelState.getBoardSize(); i++) {
      for (int j = 0; j < this.modelState.getBoardSize(); j++) {
        switch (this.modelState.getSlotAt(i, j)) {
          case Invalid:
            g.drawImage(blankSlot, originX + j * cellDimension, originY + i * cellDimension, null);
            break;
          case Marble:
            g.drawImage(marbleSlot, originX + j * cellDimension, originY + i * cellDimension, null);
            break;
          case Empty:
            g.drawImage(emptySlot, originX + j * cellDimension, originY + i * cellDimension, null);
            break;
        }
      }
    }

    if ((highlightRow != -1) && (highlightCol != -1)) {
      g.setColor(Color.red);
    }
  }
  /**
   * Sets the features of this board panel
   *
   * @param features the feature value being set
   */
  @Override
  public void setFeatures(ControllerFeatures features) {
    this.features = features;
    this.addMouseListener(new BoardMouseListener());
  }

  /**
   * Represents a board mouse listener
   */
  private class BoardMouseListener extends MouseAdapter {

    /**
     * Handles a mouse click
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
      int row = (e.getY() - originY) / BoardPanel.this.cellDimension;
      int col = (e.getX() - originX) / BoardPanel.this.cellDimension;
      BoardPanel.this.features.input(row, col);
      System.out.println("SOMETHING HAPPENED");
      System.out.println("row: " + row + " col: " + col);
    }
  }
}