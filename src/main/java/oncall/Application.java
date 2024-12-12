package oncall;

import oncall.controller.AssignController;
import oncall.global.util.InputHandler;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        AssignController controller = new AssignController(inputHandler);
        controller.process();
    }
}
