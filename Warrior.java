public class Warrior extends Player {
    public Warrior(String name) { super(name, 105, 11, 4); }

    public void powerStrike(Character target) {
        System.out.println(getName() + " uses Power Strike!");
        target.takeDamage(getTotalAttackPower() + 2);
    }

    @Override
    public String getSpecialAbilityName() { return "Power Strike"; }

    @Override
    public void useSpecialAbility(Character target) { powerStrike(target); }
}
