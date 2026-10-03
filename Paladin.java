public class Paladin extends Player {
    public Paladin(String name) { super(name, 110, 10, 5); }

    public void holyHeal() {
        System.out.println(getName() + " uses Holy Heal!");
        heal(10);
    }

    @Override
    public String getSpecialAbilityName() { return "Holy Heal"; }

    @Override
    public void useSpecialAbility(Character target) { holyHeal(); }
}
