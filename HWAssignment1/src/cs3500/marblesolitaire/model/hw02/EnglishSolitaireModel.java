package cs3500.marblesolitaire.model.hw02;

import java.lang.reflect.Array;
import java.util.*;

/**
 * EnglishSolitaireModel represented with armThickness, sRow, sCol, and score
 */
public class EnglishSolitaireModel implements MarbleSolitaireModel {

  private final int armThickness;
  private int sRow;
  private int sCol;
  private int score;
  private ArrayList<ArrayList<SlotState>> board;

  SlotState empty = SlotState.Empty;
  SlotState marble = SlotState.Marble;
  SlotState invalid = SlotState.Invalid;


  /**
   *
   * @return 2D array representing the board
   */
  public ArrayList<ArrayList<SlotState>> makeBoard() {

    int length = (armThickness * 3) - 2;
    int edges = armThickness - 1;

    board = new ArrayList<ArrayList<SlotState>>(length * length);

    for (int row = 0; row < length; row++) {
      ArrayList<SlotState> boardArray = new ArrayList<SlotState>();

      for (int col = 0; col < length; col++) {

        boolean isInvalid = (row < edges && col < edges) || (row < edges && col >= edges + armThickness) ||
                (row >= edges + armThickness && col < edges) ||
                (row >= edges + armThickness && col >= edges + armThickness);

        boolean isEmpty = (row == length / 2 && col == length / 2);

        if (isInvalid) {
          boardArray.add(invalid);
        } else if (isEmpty) {
          boardArray.add(empty);
        } else {
          boardArray.add(marble);

        }
      }
      board.add(boardArray);
    }
    return board;
  }


  public EnglishSolitaireModel() {
    this.armThickness = 3;

    this.board = makeBoard();


    empty = getSlotAt(((armThickness * 3) - 2) / 2, ((armThickness * 3) - 2) / 2);

    int length = (armThickness * 3) - 2;
    int edges = armThickness - 1;

    this.score = (length * length) - ((edges * edges) * 4 + 1);

  }

  public EnglishSolitaireModel(int sRow, int sCol) {
    this.armThickness = 3;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = makeBoard();

    empty = this.getSlotAt(sRow, sCol);


    if (this.getSlotAt(sRow, sCol) == SlotState.Invalid) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }


    int length = (armThickness * 3) - 2;
    int edges = armThickness - 1;

    this.score = (length * length) - ((edges * edges) * 4 + 1);

  }

  public EnglishSolitaireModel(int armThickness) {
    this.armThickness = armThickness;
    this.board = makeBoard();


    // empty would just be Position of (armThickness, armThickness)
    empty = getSlotAt(((armThickness * 3) - 2) / 2, ((armThickness * 3) - 2) / 2);

    if (this.armThickness <= 0 || this.armThickness % 2 == 0) {
      throw new IllegalArgumentException("Error: Arm thickness is not a positive odd number.");
    }

    int length = (armThickness * 3) - 2;
    int edges = armThickness - 1;

    this.score = (length * length) - ((edges * edges) * 4 + 1);


  }

  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    this.armThickness = armThickness;
    this.sRow = sRow;
    this.sCol = sCol;
    this.board = makeBoard();

    empty = this.getSlotAt(sRow, sCol);

    if ((this.armThickness <= 0 || this.armThickness % 2 == 0) || empty == invalid) {
      throw new IllegalArgumentException("Error: Arm thickness is not a positive odd number " +
              "or the empty cell position is invalid.");
    }

    int length = (armThickness * 3) - 2;
    int edges = armThickness - 1;

    this.score = (length * length) - ((edges * edges) * 4 + 1);


  }


  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {

    SlotState fromPosition = board.get(fromRow).get(fromCol);
    SlotState toPosition = board.get(toRow).get(toCol);
    int midCol = 0;
    int midRow = 0;
    SlotState midPosition;

    if (fromCol > toCol) {
      midCol = toCol + 1;
    }
    if (fromRow > toRow) {
      midRow = toRow + 1;
    }
    if (toCol > fromCol) {
      midCol = fromCol + 1;
    }
    if (toRow > fromRow) {
      midRow = fromRow + 1;
    }
    midPosition = board.get(midRow).get(midCol);


    if (fromPosition != invalid && toPosition != invalid &&
            fromPosition == marble && toPosition == empty && midPosition == marble &&
            ((midCol + 1 == toCol || midCol - 1 == toCol)
                    || (midRow + 1 == toRow || midRow - 1 == toRow))) {
      board.get(fromRow).set(fromCol,empty) ;
      board.get(toRow).set(toCol,marble) ;
      board.get(midRow).set(midCol,empty) ;

      //  toPosition = marble;
      //midPosition = empty;
      this.score = this.score - 1;

    }
    else {
      throw new IllegalArgumentException("Error: Move is invalid.");
    }
  }

  @Override
  public boolean isGameOver() {
    boolean gameOver = false;

    int length = (armThickness * 3) - 2;

    for (int row = 0; row < length; row++) {
      for (int col = 0; col < length; col++) {
        // if only 1 marble in board & in right location
        if (this.getSlotAt(length / 2, length / 2) == SlotState.Marble) {
          gameOver = this.getSlotAt(row, col) == SlotState.Empty
                  || this.getSlotAt(row, col) == SlotState.Invalid;
        }
        // no set of 2 marbles next to each other
        if (this.getSlotAt(row, col) == SlotState.Marble &&
                (this.getSlotAt(row + 1, col) == SlotState.Empty)
                || ((this.getSlotAt(row - 1, col) == SlotState.Empty || this.getSlotAt(row - 1, col) == SlotState.Invalid))
                || ((this.getSlotAt(row, col + 1) == SlotState.Empty) || (this.getSlotAt(row, col + 1) == SlotState.Invalid))
                || ((this.getSlotAt(row, col - 1) == SlotState.Empty) || (this.getSlotAt(row, col - 1) == SlotState.Invalid))) {
          gameOver = true;
        }
      }
    }
    return gameOver;
  }


  @Override
  public int getBoardSize() {
    return board.size();
  }


  /**
   * Get the state of the slot at a given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {

    if (row >= ((armThickness * 3) - 2) || row < 0 || col >= ((armThickness * 3) - 2) || col < 0) {
      throw new IllegalArgumentException("The row or the column is beyond the dimensions of the board.");
    } else {
      return board.get(row).get(col);
    }
  }

  public int getScore() {
    return this.score;
  }
// ask if the getScore method should throw any exceptions


  @Override
  public String toString() {
    return "EnglishSolitaireModel{" +
            "board=" + board +
            '}';
  }
}
