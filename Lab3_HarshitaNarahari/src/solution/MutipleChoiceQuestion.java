package solution;

import java.util.Arrays;
import solution.AbstractQuestion;

/**
 * Represents a class for a Mutiple choice question
 */
public class MutipleChoiceQuestion extends AbstractQuestion{
  private String[] choices;

  /**
   * Constructs a Multiple choice question
   *
   * @param text the question text
   * @param choices the answer options
   */
  public MutipleChoiceQuestion(String text, String[] choices) throws IllegalArgumentException{
    super(text);

    this.choices = Arrays.copyOf(choices, choices.length);
  }

  /**
   * returns the question type as a String
   *
   * @return the string "MultipleChoice"
   */
  @Override
  public String getType() {
    return ("MultipleChoice");
  }

  /**
   * sets the answer with given answer
   *
   * @param enteredAnswer the answer entered by the user
   * @throws IllegalArgumentException if the answer given is invalid
   */
  @Override
  public void answer(String enteredAnswer) {
    int choiceNum = -1;
    try {
      choiceNum = Integer.parseInt(enteredAnswer);
    }
    catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid Answer");
    }

    if ((choiceNum <= 0) || (choiceNum > this.choices.length)) {
      throw new IllegalArgumentException("Invalid Answer");
    }
    this.enteredAns = enteredAnswer;
  }

  /**
   * determines if a question has been answered
   *
   * @return boolean determining if a question has been answered
   */
  @Override
  public boolean hasBeenAnswered() {
    return (!this.enteredAns.equals(""));
  }
}









