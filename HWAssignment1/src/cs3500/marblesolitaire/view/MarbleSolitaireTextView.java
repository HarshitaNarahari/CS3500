package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class MarbleSolitaireTextView implements MarbleSolitaireView {

  private MarbleSolitaireModelState modelState;

  public MarbleSolitaireTextView(MarbleSolitaireModelState modelState) {
    this.modelState = modelState;

    if (modelState == null) {
      throw new IllegalArgumentException("Error: The provided model state is null");
    }
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int row = 0; row < modelState.getBoardSize(); row++) {

      for (int col = 0; col < modelState.getBoardSize(); col++) {
        if (this.modelState.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Empty) {
          str.append("_ ");
        }
        if (this.modelState.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Marble) {
          str.append("0 ");
        }
        if (this.modelState.getSlotAt(row, col) == MarbleSolitaireModelState.SlotState.Invalid
                && col < modelState.getBoardSize() / 2 - 1) {
          str.append("  ");
        }
      }
      str.deleteCharAt(str.length() - 1);

      if (row < modelState.getBoardSize() - 1) {
        str.append("\n");
      }
    }
    return str.toString();
  }
}







