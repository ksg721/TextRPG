public class Wolf extends Monster {
    public Wolf(String name) {
        super(name, 35, 10, 2);
    }

    public void pounce(Character target) {
        System.out.println(getName() + " pounces twice!");
        target.takeDamage(getAttackPower());
        if (target.isAlive()) {
            target.takeDamage(getAttackPower());
        }
    }

    @Override
    public void takeTurn(Character target) {
        if (Math.random() < 0.3) pounce(target);
        else attack(target);
    }
}
