public class Monster extends Character {

    public Monster(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower, armor);
    }

    public int getExperienceReward() {
        return (getMaxHealth() / 3) + (getAttackPower() * 2) + getBaseArmor();
    }

    public void takeTurn(Character target) {
        attack(target);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " attacks the player!");
        target.takeDamage(getAttackPower());
    }
}
