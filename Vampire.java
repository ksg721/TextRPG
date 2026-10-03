public class Vampire extends Monster {
    public Vampire(String name) {
        super(name, 55, 13, 4);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " attacks the player with lifesteal!");

        int targetHealthBeforeAttack = target.getHealth();
        target.takeDamage(getAttackPower());
        int damageDealt = targetHealthBeforeAttack - target.getHealth();
        int healing = Math.min(damageDealt / 2, getMaxHealth() - getHealth());

        setHealth(getHealth() + healing);
        System.out.println(getName() + " restores " + healing + " health.");
    }
}
