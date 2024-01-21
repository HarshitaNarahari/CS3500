package solution;

/**
 * Represents an abstract class for a Question
 */
public abstract class AbstractQuestion implements Question {
  private String qText;
  String enteredAns;

  /**
   * Constructs an abstract Question
   *
   * @param text the question text
   * @throws IllegalArgumentException if the question text was invalid
   */
  public AbstractQuestion(String text){
    this.qText = text;
    enteredAns = "";

    if (text.length() == 0){
      throw new IllegalArgumentException("Invalid question text");
    }
  }

  /**
   * returns the question
   *
   * @return String representing question text
   */
  @Override
  public String getQuestionText() {
    return qText;
  }

  /**
   * returns the question type as a String
   */
  @Override
  public abstract String getType();

  /**
   * sets the answer with given answer
   *
   * @param enteredAnswer the answer entered by the user
   */
  @Override
  public abstract void answer(String enteredAnswer);

  /**
   * determines if a question has been answered
   *
   * @return boolean determining if a question has been answered
   */
  @Override
  public abstract boolean hasBeenAnswered();

  /**
   * returns the entered answer
   *
   * @throws IllegalStateException if the question wasn't attempted yet.
   * @return String as the answer entered by the user
   */
  @Override
  public String getEnteredAnswer() throws IllegalStateException {
    if (!hasBeenAnswered()) {
      throw new IllegalStateException("Question wasn't attempted yet.");
    }
    else {
      return enteredAns;
    }
  }
}
