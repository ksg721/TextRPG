public class Druid extends Player {
    public Druid(String name) { super(name, 100, 10, 3); }

    public void naturesWrath(Character target) {
        System.out.println(getName() + " uses Nature's Wrath!");
        target.takeDamage(getTotalAttackPower() + 7);
        heal(8);
    }

    @Override
    public String getSpecialAbilityName() { return "Nature's Wrath"; }

    @Override
    public void useSpecialAbility(Character target) { naturesWrath(target); }
}
