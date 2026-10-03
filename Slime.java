public class Slime extends Monster {
    public Slime(String name) {
        super(name, 45, 7, 2);
    }

    public void regenerate() {
        int oldHealth = getHealth();
        setHealth(getHealth() + 8);
        System.out.println(getName() + " regenerates " + (getHealth() - oldHealth) + " health.");
    }

    @Override
    public void takeTurn(Character target) {
        if (Math.random() < 0.3) regenerate();
        else attack(target);
    }
}
