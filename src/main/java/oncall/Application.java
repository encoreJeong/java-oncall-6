package oncall;

import oncall.controller.AssignController;

public class Application {
    public static void main(String[] args) {
        AssignController controller = new AssignController();
        controller.process();
    }
}
