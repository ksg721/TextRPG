import java.util.Scanner;

public class Game {
    private final Scanner scanner;
    private final BattleSystem battleSystem;
    private final EncounterSystem encounterSystem;

    public Game() {
        scanner = new Scanner(System.in);
        battleSystem = new BattleSystem(scanner);
        encounterSystem = new EncounterSystem(scanner, battleSystem);
    }

    public void start() {
        System.out.println("Welcome to the Text RPG!");
        String playerName = readPlayerName();

        Player player = PlayerFactory.choosePlayerClass(scanner, playerName);
        PlayerFactory.giveStartingEquipment(player);

        System.out.println("\nYour adventure begins, " + playerName + "!");
        player.displayStatus();
        player.displayInventory();

        for (Area area : AreaFactory.createAreas()) {
            if (!exploreArea(player, area)) {
                if (!player.isAlive()) {
                    System.out.println("Your adventure has ended.");
                } else {
                    System.out.println("You left the adventure.");
                }
                scanner.close();
                return;
            }
        }

        System.out.println("\n========================================");
        System.out.println("You defeated the Dragon and completed the game!");
        System.out.println("Congratulations, " + playerName + "!");
        player.displayStatus();
        scanner.close();
    }

    private String readPlayerName() {
        System.out.print("Enter your name: ");
        String playerName = InputHelper.readLine(scanner).trim();
        return playerName.isEmpty() ? "Hero" : playerName;
    }

    private boolean exploreArea(Player player, Area area) {
        System.out.println("\n========================================");
        System.out.println("Entering: " + area.getName());
        System.out.println(area.getDescription());

        for (int encounterNumber = 1;
                encounterNumber <= area.getRegularEncounterCount(); encounterNumber++) {
            if (!encounterSystem.runEncounter(player, area, encounterNumber)) {
                return false;
            }
        }

        return fightAreaBoss(player, area);
    }

    private boolean fightAreaBoss(Player player, Area area) {
        System.out.println("\nThe regular encounters are complete.");
        System.out.println("Area boss approaching: " + area.getBossName());

        while (player.isAlive()) {
            Monster boss = area.createBoss();
            BattleResult result = battleSystem.battle(player, boss, area);

            if (result == BattleResult.VICTORY) {
                giveAreaReward(player, area);
                return true;
            }

            if (result == BattleResult.DEFEAT) return false;
            System.out.println("You escaped, but the area boss still blocks your path.");
        }

        return false;
    }

    private void giveAreaReward(Player player, Area area) {
        Item reward = ItemCatalog.getAreaReward(area, player);
        System.out.println("Area completion reward: " + reward.getName());
        player.addItem(reward);

        if (reward instanceof Weapon || reward instanceof Armor) {
            player.useItem(reward.getName());
            System.out.println("The new equipment is ready for the next area.");
        }

        player.displayInventory();
    }
}
