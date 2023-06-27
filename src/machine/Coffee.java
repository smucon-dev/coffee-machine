package machine;

public class Coffee {

    private final int water;
    private final int milk;
    private final int beans;
    private final int money;

    public Coffee(int water, int milk, int beans, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getMoney() {
        return money;
    }
}
