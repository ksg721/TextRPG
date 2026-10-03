import java.util.Scanner;

public class PlayerFactory {
    private PlayerFactory() {
        // This class creates players and should not be instantiated.
    }

    public static Player choosePlayerClass(Scanner scanner, String playerName) {
        System.out.println("\nChoose your class:");
        System.out.println("1. Warrior");
        System.out.println("2. Rogue");
        System.out.println("3. Mage");
        System.out.println("4. Paladin");
        System.out.println("5. Ranger");
        System.out.println("6. Berserker");
        System.out.println("7. Druid");
        System.out.println("8. Necromancer");
        System.out.println("9. Monk");
        System.out.println("10. Bard");

        while (true) {
            System.out.print("Enter your choice: ");
            int choice = InputHelper.readChoice(scanner);

            switch (choice) {
                case 1: return new Warrior(playerName);
                case 2: return new Rogue(playerName);
                case 3: return new Mage(playerName);
                case 4: return new Paladin(playerName);
                case 5: return new Ranger(playerName);
                case 6: return new Berserker(playerName);
                case 7: return new Druid(playerName);
                case 8: return new Necromancer(playerName);
                case 9: return new Monk(playerName);
                case 10: return new Bard(playerName);
                default: System.out.println("That is not a valid choice.");
            }
        }
    }

    public static void giveStartingEquipment(Player player) {
        Consumable healthPotion = new Consumable(
                "Health Potion", "Restores 25 health.", 10, 25);

        if (player instanceof Warrior) {
            addAndEquip(player, new Weapon("Iron Sword", "A dependable sword.", 50, 5),
                    new Armor("Iron Armor", "Heavy protective armor.", 60, 4));
            player.addItem(healthPotion);
        } else if (player instanceof Rogue) {
            addAndEquip(player, new Weapon("Dagger", "A quick and precise blade.", 35, 3),
                    new Armor("Shadow Cloak", "Light armor for sneaky fighters.", 40, 2));
            player.addItem(new EscapeItem("Smoke Bomb", "Escape from the current battle.", 15));
            player.addItem(new Consumable(
                    "Trail Rations", "Restores a small amount of health.", 5, 15));
        } else if (player instanceof Mage) {
            addAndEquip(player, new Weapon("Magic Staff", "A staff that focuses spell power.", 60, 6),
                    new Armor("Apprentice Robe", "Light magical protection.", 30, 1));
            player.addItem(healthPotion);
        } else if (player instanceof Paladin) {
            addAndEquip(player, new Weapon("Holy Mace", "A blessed weapon.", 55, 4),
                    new Armor("Steel Armor", "Strong armor for a holy warrior.", 75, 5));
            player.addItem(healthPotion);
        } else if (player instanceof Ranger) {
            addAndEquip(player, new Weapon("Longbow", "A reliable ranged weapon.", 50, 5),
                    new Armor("Ranger Leathers", "Flexible armor for travel.", 45, 2));
            player.addItem(new Consumable(
                    "Trail Rations", "Restores a small amount of health.", 5, 15));
        } else if (player instanceof Berserker) {
            addAndEquip(player, new Weapon("Great Axe", "A powerful two-handed weapon.", 65, 7),
                    new Armor("Fur Mantle", "Light protection that allows movement.", 25, 1));
            player.addItem(healthPotion);
        } else if (player instanceof Druid) {
            addAndEquip(player, new Weapon("Oak Staff", "A staff connected to nature.", 45, 3),
                    new Armor("Nature Garb", "Clothing woven from strong vines.", 35, 3));
            player.addItem(new Consumable(
                    "Healing Herb", "A natural healing item.", 8, 20));
        } else if (player instanceof Necromancer) {
            addAndEquip(player, new Weapon("Bone Wand", "A wand filled with dark energy.", 60, 6),
                    new Armor("Dark Robe", "A robe woven with shadow magic.", 30, 1));
            player.addItem(new QuestItem(
                    "Ancient Bone", "A mysterious bone used in rituals.", 0));
            player.addItem(new Consumable(
                    "Soul Tonic", "Restores health with dark magic.", 12, 20));
        } else if (player instanceof Monk) {
            addAndEquip(player, new Weapon("Quarterstaff", "A balanced weapon for martial arts.", 40, 4),
                    new Armor("Monk Wraps", "Light wraps that allow quick movement.", 25, 2));
            player.addItem(new Consumable(
                    "Meditation Tea", "Restores focus and health.", 10, 15));
        } else if (player instanceof Bard) {
            addAndEquip(player, new Weapon("Enchanted Lute", "A lute that strengthens battle songs.", 50, 2),
                    new Armor("Performer Garb", "Comfortable and flexible clothing.", 30, 2));
            player.addItem(new Consumable(
                    "Celebration Cake", "A sweet source of healing.", 12, 20));
        }
    }

    private static void addAndEquip(Player player, Weapon weapon, Armor armor) {
        player.addItem(weapon);
        player.addItem(armor);
        player.useItem(weapon.getName());
        player.useItem(armor.getName());
    }
}
