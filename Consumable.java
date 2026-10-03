public class Consumable extends Item {
    private int healAmount;

    public Consumable(String name, String description, int value, int healAmount) {
        super(name, description, value, ItemType.CONSUMABLE);
        this.healAmount = healAmount;
    }

    public boolean use(Player player) { return player.heal(healAmount); }
}
