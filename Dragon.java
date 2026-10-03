public class Dragon extends Monster {
    public Dragon(String name) {
        super(name, 220, 28, 10);
    }

    public void fireBreath(Character target) {
        System.out.println(getName() + " uses fire breath!");
        target.takeDamage(getAttackPower() + 10);
    }

    @Override
    public void takeTurn(Character target) {
        if (Math.random() < 0.3) fireBreath(target);
        else attack(target);
    }
}
