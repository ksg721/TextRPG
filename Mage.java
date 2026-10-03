public class Mage extends Player {
    public Mage(String name) { super(name, 100, 16, 2); }

    public void fireball(Character target) {
        System.out.println(getName() + " casts Fireball!");
        target.takeDamage(getTotalAttackPower() + 10);
    }

    @Override
    public String getSpecialAbilityName() { return "Fireball"; }

    @Override
    public void useSpecialAbility(Character target) { fireball(target); }
}
