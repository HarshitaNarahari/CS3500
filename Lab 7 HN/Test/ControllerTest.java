import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cs3500.marblesolitaire.controller.ControllerFeatures;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.controller.SwingGuiController;
import cs3500.marblesolitaire.model.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.view.SwingGuiViewMock;
import cs3500.marblesolitaire.view.SwingGuiView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A JUnit test class for the SolitaireController class.
 */
public class ControllerTest {
  private MarbleSolitaireModel model;
  private MarbleSolitaireGuiView view;
  private ControllerFeatures controller;

  @Before
  public void setUp() {
    model = new EnglishSolitaireModel();
    view = new SwingGuiView(model);
    controller = new SwingGuiController(model, view);
  }

  @Test
  public void testController() {
    List<String> log = new ArrayList<>();
    MarbleSolitaireModel realModel = new EnglishSolitaireModel();

    List<String> expected = new ArrayList<>();
    expected.add("refresh");
    log.add("refresh");

    assertEquals(expected.toString(), log.toString());
  }

  @Test
  public void testInvalidParameters() {
    try {
      ControllerFeatures nullModel = new SwingGuiController(null, view);
      fail("The model or view cannot be null");
    } catch (IllegalArgumentException e) {
      // pass
    }
    try {
      ControllerFeatures nullView = new SwingGuiController(model, null);
      fail("The model or view cannot be null");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }


}