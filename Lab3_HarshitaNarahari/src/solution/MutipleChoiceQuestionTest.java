package solution;

import org.junit.Test;
import java.util.Arrays;
import java.util.Random;
import static org.junit.Assert.*;


public class MutipleChoiceQuestionTest {
  private String longRandom;

  public MutipleChoiceQuestionTest() {
    longRandom = "aosdifjaso oifhas;ldihv;al skdfha;osidghv;osiadhvbasdjkhvn";
  }

  @Test
  public void testCreateMCQ() {
    Random r = new Random(200);
    String[] strArray = new String[5];

    for (int i = 0; i < 1000; i++) {
      int start = r.nextInt(longRandom.length() - 1);
      int end = start + r.nextInt(longRandom.length() - start - 1) + 1;
      String questionText = longRandom.substring(start, end);
      Question q = new MutipleChoiceQuestion(questionText + "?", strArray);
      assertEquals(questionText + "?", q.getQuestionText());
      assertEquals("MultipleChoice", q.getType());
    }
  }

    @Test
    public void testCorrectAnswer() {
      String[] answers = {"1", "2", "3", "4"};
      for (String answer : answers) {
        Question q = new MutipleChoiceQuestion("Is this a trick question?", answers);
        assertFalse(q.hasBeenAnswered());

        q.answer(answer);
        assertEquals(answer.toLowerCase(), q.getEnteredAnswer());
        assertTrue(q.hasBeenAnswered());
      }
    }

    @Test
    public void testAnswerInCorrectly() {
      String[] choices = {"true", "false"};
      String[] answers = {"0", "-1"};
      for (String answer:answers) {
        Question q = new MutipleChoiceQuestion("Is this a trick question?", answers);
        assertFalse(q.hasBeenAnswered());

        try {
          q.answer(answer);
          fail("Multiple choice question accepted an invalid answer");
        }
        catch (IllegalArgumentException e) {
          assertFalse(q.hasBeenAnswered());
        }
      }
    }
  }









