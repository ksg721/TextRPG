public class Armor extends Equipment {
    public Armor(String name, String description, int value, int armorBonus) {
        super(name, description, value, ItemType.ARMOR, 0, armorBonus);
    }
}
