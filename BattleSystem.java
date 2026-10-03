import java.util.Scanner;

public class BattleSystem {
    private final Scanner scanner;

    public BattleSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public BattleResult battle(Player player, Monster monster, Area area) {
        while (player.isAlive() && monster.isAlive()) {
            displayBattleMenu(player);
            int choice = InputHelper.readChoice(scanner);
            boolean playerTurnCompleted = false;

            switch (choice) {
                case 1:
                    player.attack(monster);
                    playerTurnCompleted = true;
                    break;
                case 2:
                    playerTurnCompleted = useSpecialAbility(player, monster);
                    break;
                case 3:
                    ItemUseResult result = useBattleItem(player);
                    if (result == ItemUseResult.ESCAPED) return BattleResult.ESCAPED;
                    playerTurnCompleted = result == ItemUseResult.USED;
                    break;
                case 4:
                    player.displayInventory();
                    break;
                case 5:
                    System.out.println("You ran away from the " + monster.getName() + ".");
                    return BattleResult.ESCAPED;
                case 6:
                    System.out.println("You wait for an opening.");
                    playerTurnCompleted = true;
                    break;
                default:
                    System.out.println("That is not a valid choice.");
            }

            if (playerTurnCompleted && monster.isAlive()) {
                monster.takeTurn(player);
                player.processStatusEffects();
                player.reduceSpecialCooldown();
            }

            player.displayStatus();
            monster.displayStatus();
        }

        if (!player.isAlive()) {
            System.out.println("You were defeated.");
            return BattleResult.DEFEAT;
        }

        int experienceReward = area.getExperienceReward(monster);
        System.out.println("You defeated the " + monster.getName() + "!");
        player.gainExperience(experienceReward);

        Item droppedItem = ItemCatalog.getMonsterReward(area, monster);
        if (droppedItem != null) {
            System.out.println("The " + monster.getName() + " dropped: "
                    + droppedItem.getName());
            player.addItem(droppedItem);
            if (droppedItem instanceof Weapon || droppedItem instanceof Armor) {
                offerEquipmentUpgrade(player, droppedItem);
            }
        }

        return BattleResult.VICTORY;
    }

    private void displayBattleMenu(Player player) {
        System.out.println("\n--- Battle Menu ---");
        System.out.println("1. Attack");

        String cooldownStatus = player.canUseSpecialAbility()
                ? "Ready"
                : "Cooldown: " + player.getSpecialCooldown() + " turn(s)";
        System.out.println("2. Use Special Ability: "
                + player.getSpecialAbilityName() + " (" + cooldownStatus + ")");
        System.out.println("3. Use Item");
        System.out.println("4. View Inventory");
        System.out.println("5. Run Away");
        System.out.println("6. Wait");
    }

    private boolean useSpecialAbility(Player player, Monster monster) {
        if (player.canUseSpecialAbility()) {
            player.useSpecialAbility(monster);
            player.startSpecialCooldown();
        } else {
            System.out.println("Your special ability is still on cooldown for "
                    + player.getSpecialCooldown() + " turn(s).");
        }

        // Attempting a cooling-down ability still uses the player's turn.
        return true;
    }

    private ItemUseResult useBattleItem(Player player) {
        player.displayInventory();
        System.out.print("Enter the item name to use: ");
        return player.useItem(InputHelper.readLine(scanner));
    }

    private void offerEquipmentUpgrade(Player player, Item droppedItem) {
        System.out.println("\n--- Equipment Comparison ---");

        if (droppedItem instanceof Weapon) {
            Weapon newWeapon = (Weapon) droppedItem;
            Weapon currentWeapon = player.getEquippedWeapon();
            int currentBonus = currentWeapon == null ? 0 : currentWeapon.getAttackBonus();
            int newTotalAttack = player.getAttackPower() + newWeapon.getAttackBonus();

            System.out.println("Current weapon: "
                    + (currentWeapon == null ? "None" : currentWeapon.getName())
                    + " (Attack bonus: " + currentBonus + ")");
            System.out.println("Dropped weapon: " + newWeapon.getName()
                    + " (Attack bonus: " + newWeapon.getAttackBonus() + ")");
            System.out.println("Your attack with the dropped weapon would be: "
                    + newTotalAttack);
        } else {
            Armor newArmor = (Armor) droppedItem;
            Armor currentArmor = player.getEquippedArmor();
            int currentBonus = currentArmor == null ? 0 : currentArmor.getArmorBonus();
            int newTotalArmor = player.getBaseArmor() + newArmor.getArmorBonus();

            System.out.println("Current armor: "
                    + (currentArmor == null ? "None" : currentArmor.getName())
                    + " (Armor bonus: " + currentBonus + ")");
            System.out.println("Dropped armor: " + newArmor.getName()
                    + " (Armor bonus: " + newArmor.getArmorBonus() + ")");
            System.out.println("Your armor with the dropped item would be: "
                    + newTotalArmor);
        }

        System.out.println("1. Equip the dropped equipment");
        System.out.println("2. Keep your current equipment");

        if (InputHelper.readChoice(scanner) == 1) {
            if (droppedItem instanceof Weapon) {
                player.equipWeapon((Weapon) droppedItem);
            } else {
                player.equipArmor((Armor) droppedItem);
            }
        } else {
            System.out.println("You keep your current equipment.");
        }
    }
}
