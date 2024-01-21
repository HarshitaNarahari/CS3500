package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;

/**
 * This class represents a swing GUI controller
 */
public class SwingGuiController implements ControllerFeatures{
  private MarbleSolitaireModel model;
  private MarbleSolitaireGuiView view;
  private int fromRow, fromCol, toRow, toCol;

  /**
   * Default constructor
   *
   * @param model a marble solitaire model
   * @param view a GUI view
   */
  public SwingGuiController(MarbleSolitaireModel model, MarbleSolitaireGuiView view) {
    if (model == null || view == null){
      throw new IllegalArgumentException("model or view cannot be null");
    }
    this.model = model;
    this.view = view;
    this.view.refresh();
    fromRow = -1;
    fromCol = -1;
    toRow = -1;
    toCol = -1;
  }

  /**
   * Takes in a cell's row and column as an input
   *
   * @param row row of the board
   * @param col column of the board
   */
  @Override
  public void input(int row, int col) {

    if (row >= 0 && col >= 0) {
      if (fromRow == -1) {
        fromRow = row;
        fromCol = col;
      }
      else {
        toRow = row;
        toCol = col;
        try {
          model.move(fromRow, fromCol, toRow, toCol);

          if (model.isGameOver()) {
            this.view.renderMessage("Game Over!");
          }
        }
        catch (IllegalArgumentException e) {
          this.view.renderMessage("Move is invalid!");
        }
        fromRow = fromCol = toRow = toCol = -1;
      }
    }
    this.view.refresh();
  }
}