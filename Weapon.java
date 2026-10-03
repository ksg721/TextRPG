public class Weapon extends Equipment {
    public Weapon(String name, String description, int value, int attackBonus) {
        super(name, description, value, ItemType.WEAPON, attackBonus, 0);
    }
}
