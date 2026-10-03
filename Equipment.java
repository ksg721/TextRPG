public class Equipment extends Item {
    private int attackBonus;
    private int armorBonus;

    public Equipment(String name, String description, int value, ItemType type,
            int attackBonus, int armorBonus) {
        super(name, description, value, type);
        this.attackBonus = attackBonus;
        this.armorBonus = armorBonus;
    }

    public int getAttackBonus() { return attackBonus; }
    public int getArmorBonus() { return armorBonus; }
    public void setAttackBonus(int attackBonus) { this.attackBonus = attackBonus; }
    public void setArmorBonus(int armorBonus) { this.armorBonus = armorBonus; }
}
