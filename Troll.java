public class Troll extends Monster {
    public Troll(String name) {
        super(name, 95, 16, 5);
    }

    public void regenerate() {
        int oldHealth = getHealth();
        setHealth(getHealth() + 5);
        System.out.println(getName() + " regenerates " + (getHealth() - oldHealth) + " health.");
    }

    @Override
    public void takeTurn(Character target) {
        if (Math.random() < 0.25) regenerate();
        else attack(target);
    }
}
