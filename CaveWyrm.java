public class CaveWyrm extends Monster {
    public CaveWyrm(String name) {
        super(name, 165, 22, 7);
    }

    @Override
    public void attack(Character target) {
        if (Math.random() < 0.25) {
            System.out.println(getName() + " bursts from underground with a burrow attack!");
            target.takeDamage(getAttackPower() + 6);
        } else {
            super.attack(target);
        }
    }
}
