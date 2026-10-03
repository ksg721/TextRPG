public class Spider extends Monster {
    public Spider(String name) {
        super(name, 30, 7, 2);
    }

    public void poisonAttack(Character target) {
        System.out.println(getName() + " bites the player with poisonous fangs!");
        target.takeDamage(getAttackPower());
        if (target.isAlive()) {
            target.applyPoison(3, 3);
        }
    }

    @Override
    public void takeTurn(Character target) {
        if (Math.random() < 0.4) poisonAttack(target);
        else attack(target);
    }
}
