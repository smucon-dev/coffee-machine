package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Machine machine = new Machine();
        machine.setState(State.CHOOSE_ACTION);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            var input = scanner.nextLine();
            running = machine.processInput(input);
        }
    }

}
