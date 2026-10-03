public class Skeleton extends Monster {
    public Skeleton(String name) {
        super(name, 45, 9, 3);
    }

    @Override
    public void takeDamage(int damage) {
        if (Math.random() < 0.25) {
            System.out.println(getName() + " resists part of the attack!");
            damage /= 2;
        }
        super.takeDamage(damage);
    }
}
