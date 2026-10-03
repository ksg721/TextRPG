public class Berserker extends Player {
    public Berserker(String name) { super(name, 115, 14, 2); }

    public void frenzy(Character target) {
        int bonusDamage = Math.max(0, (getMaxHealth() - getHealth()) / 10);
        System.out.println(getName() + " uses Frenzy!");
        target.takeDamage(getTotalAttackPower() + bonusDamage);
    }

    @Override
    public String getSpecialAbilityName() { return "Frenzy"; }

    @Override
    public void useSpecialAbility(Character target) { frenzy(target); }
}
