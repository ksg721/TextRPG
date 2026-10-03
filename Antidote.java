public class Antidote extends Consumable {
    public Antidote(String name, String description, int value, int healAmount) {
        super(name, description, value, healAmount);
    }

    @Override
    public boolean use(Player player) {
        boolean wasPoisoned = player.isPoisoned();
        player.curePoison();
        return super.use(player) || wasPoisoned;
    }
}
