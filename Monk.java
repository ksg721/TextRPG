public class Monk extends Player {
    public Monk(String name) { super(name, 107, 12, 3); }

    public void counterattack(Character target) {
        System.out.println(getName() + " uses Counterattack!");
        target.takeDamage(getTotalAttackPower() + (getArmor() / 2));
        reduceNextDamage(50);
        System.out.println(getName() + " prepares to reduce the next attack by 50%.");
    }

    @Override
    public String getSpecialAbilityName() { return "Counterattack"; }

    @Override
    public void useSpecialAbility(Character target) { counterattack(target); }

    @Override
    public void startSpecialCooldown() {
        startSpecialCooldown(2);
    }
}
