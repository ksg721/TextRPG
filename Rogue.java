public class Rogue extends Player {
    private static final double EVASION_CHANCE = 0.28;

    public Rogue(String name) { super(name, 100, 11, 3); }

    @Override
    public void takeDamage(int damage) {
        if (Math.random() < EVASION_CHANCE) {
            System.out.println(getName() + " evades the attack!");
            return;
        }
        super.takeDamage(damage);
    }

    public void doubleStrike(Character target) {
        System.out.println(getName() + " uses Double Strike!");
        int strikeDamage = getTotalAttackPower();
        target.takeDamage(strikeDamage);
        if (target.isAlive()) target.takeDamage(strikeDamage);
    }

    @Override
    public String getSpecialAbilityName() { return "Double Strike"; }

    @Override
    public void useSpecialAbility(Character target) { doubleStrike(target); }
}
