public class Necromancer extends Player {
    public Necromancer(String name) { super(name, 90, 15, 1); }

    public Monster raiseDead() {
        System.out.println(getName() + " raises a skeleton from the dead!");
        return new Skeleton(getName() + "'s Skeleton");
    }

    @Override
    public String getSpecialAbilityName() { return "Raise Dead"; }

    @Override
    public void useSpecialAbility(Character target) {
        raiseDead();
        target.takeDamage(getTotalAttackPower() + 1);
        blockNextAttack();
        System.out.println(getName() + "'s skeleton guards against the next attack.");
    }
}
