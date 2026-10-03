public class Ranger extends Player {
    public Ranger(String name) { super(name, 110, 13, 3); }

    public void aimedShot(Character target) {
        System.out.println(getName() + " uses Aimed Shot!");
        target.takeDamage(getTotalAttackPower() + 9);
    }

    @Override
    public String getSpecialAbilityName() { return "Aimed Shot"; }

    @Override
    public void useSpecialAbility(Character target) { aimedShot(target); }
}
