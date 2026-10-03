public class Treant extends Monster {
    public Treant(String name) {
        super(name, 130, 18, 8);
    }

    @Override
    public void attack(Character target) {
        if (Math.random() < 0.25) {
            int oldHealth = getHealth();
            setHealth(getHealth() + 8);
            System.out.println(getName() + " draws power from the forest and regenerates "
                    + (getHealth() - oldHealth) + " health.");
        }
        super.attack(target);
    }
}
