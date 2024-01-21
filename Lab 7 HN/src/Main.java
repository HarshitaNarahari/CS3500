import cs3500.marblesolitaire.controller.ControllerFeatures;
import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.controller.SwingGuiController;
import cs3500.marblesolitaire.model.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireGuiView;
import cs3500.marblesolitaire.view.SwingGuiView;

/**
 * The main class creates an English Solitaire model with default settings
 */
public class Main {
  public static void main(String[] args) {
    MarbleSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireGuiView view = new SwingGuiView(model);
    SwingGuiController controller = new SwingGuiController(model, view);

    view.input(controller);
  }

}