package machine;

public class Machine {


    private static final Coffee espresso = new Coffee(250, 0, 16, 4);
    private static final Coffee latte = new Coffee(350, 75, 20, 7);
    private static final Coffee cappuccino = new Coffee(200, 100, 12, 6);
    private final Supplies supplies = new Supplies(400, 540, 120, 9);
    private int money = 550;

    private State state = State.CHOOSE_ACTION;

    boolean processInput(String input) {

        switch (state) {
            case CHOOSE_ACTION:
                return chooseAction(input);
            case CHOOSE_COFFEE:
                chooseCoffee(input);
                setState(State.CHOOSE_ACTION);
                System.out.printf("%nWrite action (buy, fill, take, remaining, exit):%n");
                break;
            case FILL_WATER:
                supplies.addWater(input);
                setState(State.FILL_MILK);
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case FILL_MILK:
                supplies.addMilk(input);
                setState(State.FILL_BEANS);
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case FILL_BEANS:
                supplies.addBeans(input);
                setState(State.FILL_CUPS);
                System.out.println("Write how many disposable cups you want to add:");
                break;
            case FILL_CUPS:
                supplies.addCups(input);
                setState(State.CHOOSE_ACTION);
                break;
        }

        return true;
    }

    void setState(State state) {
        this.state = state;
        if (this.state == State.CHOOSE_ACTION) {
            System.out.printf("%nWrite action (buy, fill, take, remaining, exit):%n");
        }
    }

    // handle main menu actions
    private boolean chooseAction(String input) {

        switch (input) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                state = State.CHOOSE_COFFEE;
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                state = State.FILL_WATER;
                break;
            case "take":
                take();
                System.out.printf("%nWrite action (buy, fill, take, remaining, exit):%n");
                break;
            case "remaining":
                printInventory();
                setState(State.CHOOSE_ACTION);
                break;
            case "exit":
                return false;
            default:
                System.out.println("You provided an unknown action.");
                setState(State.CHOOSE_ACTION);
        }

        return true;
    }

    // handle coffee menu action (buy action sub menu)
    private void chooseCoffee(String coffeeType) {
        switch (coffeeType) {
            case "1":
                if (supplies.brew(espresso)){
                    money += espresso.getMoney();
                }
                break;
            case "2":
                if (supplies.brew(latte)) {
                    money += latte.getMoney();
                }
                break;
            case "3":
                if (supplies.brew(cappuccino)) {
                    money += cappuccino.getMoney();
                }
                break;
            case "back":
                break;
            default:
                System.out.println("You provided an unknown option.");
        }
    }

    // withdraw the money from the machine
    private void take() {
        System.out.printf("I gave you $%d%n%n", money);
        money = 0;
    }

    private void printInventory() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", supplies.getWater());
        System.out.printf("%d ml of milk%n", supplies.getMilk());
        System.out.printf("%d g of coffee beans%n", supplies.getBeans());
        System.out.printf("%d disposable cups%n", supplies.getCups());
        System.out.printf("$%d of money%n", money);
    }
}
