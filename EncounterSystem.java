import java.util.Scanner;

public class EncounterSystem {
    private final Scanner scanner;
    private final BattleSystem battleSystem;
    private Area previousArea;
    private EncounterType previousEncounterType;

    public EncounterSystem(Scanner scanner, BattleSystem battleSystem) {
        this.scanner = scanner;
        this.battleSystem = battleSystem;
    }

    public boolean runEncounter(Player player, Area area, int encounterNumber) {
        if (area != previousArea) {
            previousArea = area;
            previousEncounterType = null;
        }

        EncounterType encounterType = getNextEncounterType(area);
        previousEncounterType = encounterType;
        System.out.println("\nEncounter " + encounterNumber + " of "
                + area.getRegularEncounterCount() + ": " + encounterType);

        switch (encounterType) {
            case COMBAT:
                return combatEncounter(player, area);
            case TREASURE:
                return treasureEncounter(player, area);
            case SHRINE:
                return shrineEncounter(player, area);
            case TRAP:
                return trapEncounter(player, area);
            case STORY:
                return storyEncounter(player, area);
            default:
                return true;
        }
    }

    private EncounterType getNextEncounterType(Area area) {
        EncounterType encounterType = randomEncounterType(area);

        while (encounterType == EncounterType.SHRINE
                && previousEncounterType == EncounterType.SHRINE) {
            encounterType = randomEncounterType(area);
        }

        return encounterType;
    }

    private boolean combatEncounter(Player player, Area area) {
        Monster monster = area.createRandomMonster();
        System.out.println("A " + monster.getName() + " appears!");
        BattleResult result = battleSystem.battle(player, monster, area);
        return result != BattleResult.DEFEAT;
    }

    private boolean treasureEncounter(Player player, Area area) {
        System.out.println(getTreasureMessage(area));
        System.out.println("1. Open the cache");
        System.out.println("2. Leave it alone");

        if (InputHelper.readChoice(scanner) == 1) {
            Item item = ItemCatalog.getEncounterItem(area);
            System.out.println("You found: " + item.getName());
            player.addItem(item);
        } else {
            System.out.println("You leave the cache untouched.");
        }
        return true;
    }

    private boolean shrineEncounter(Player player, Area area) {
        System.out.println(getShrineMessage(area));
        System.out.println("1. Rest at the shrine");
        System.out.println("2. Continue onward");

        if (InputHelper.readChoice(scanner) == 1) {
            player.restAtShrine();
        } else {
            System.out.println("You leave the shrine behind.");
        }
        return true;
    }

    private boolean trapEncounter(Player player, Area area) {
        System.out.println(getTrapMessage(area));
        System.out.println("1. Move carefully");
        System.out.println("2. Rush through");

        int damage = getTrapDamage(area);
        if (InputHelper.readChoice(scanner) == 1) {
            damage = Math.max(1, damage / 2);
            System.out.println("You reduce the impact of the trap.");
        } else {
            System.out.println("You rush forward and take the full impact.");
        }

        player.takeDamage(damage);
        player.displayStatus();
        return player.isAlive();
    }

    private boolean storyEncounter(Player player, Area area) {
        System.out.println(getStoryMessage(area));
        System.out.println("1. Investigate the discovery");
        System.out.println("2. Keep moving");

        if (InputHelper.readChoice(scanner) == 1) {
            System.out.println("You learn something valuable from the area.");
            player.gainExperience(10);
        } else {
            System.out.println("You decide not to investigate.");
        }
        return true;
    }

    public EncounterType randomEncounterType(Area area) {
        int roll = (int) (Math.random() * 100);

        if (area.getType() == AreaType.WOODS) {
            if (roll < 38) return EncounterType.COMBAT;
            if (roll < 70) return EncounterType.TREASURE;
            if (roll < 85) return EncounterType.SHRINE;
            if (roll < 93) return EncounterType.TRAP;
            return EncounterType.STORY;
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (roll < 51) return EncounterType.COMBAT;
            if (roll < 67) return EncounterType.TREASURE;
            if (roll < 75) return EncounterType.SHRINE;
            if (roll < 94) return EncounterType.TRAP;
            return EncounterType.STORY;
        }

        if (roll < 58) return EncounterType.COMBAT;
        if (roll < 72) return EncounterType.TREASURE;
        if (roll < 78) return EncounterType.SHRINE;
        if (roll < 94) return EncounterType.TRAP;
        return EncounterType.STORY;
    }

    private int getTrapDamage(Area area) {
        if (area.getType() == AreaType.WOODS) {
            return 5 + (int) (Math.random() * 6);
        }
        if (area.getType() == AreaType.CAVERNS) {
            return 10 + (int) (Math.random() * 9);
        }
        return 15 + (int) (Math.random() * 11);
    }

    private String getTrapMessage(Area area) {
        if (area.getType() == AreaType.WOODS) {
            return "Thorny vines lash out from the forest floor!";
        }
        if (area.getType() == AreaType.CAVERNS) {
            return "The cavern ceiling collapses around you!";
        }
        return "A wave of dragonfire sweeps across the wasteland!";
    }

    private String getTreasureMessage(Area area) {
        if (area.getType() == AreaType.WOODS) {
            return "You discover a herbalist's satchel beneath the roots of an old tree.";
        }
        if (area.getType() == AreaType.CAVERNS) {
            return "You discover an ancient mining cache hidden behind loose stone.";
        }
        return "You discover a scorched treasure chest guarded by ancient magic.";
    }

    private String getShrineMessage(Area area) {
        if (area.getType() == AreaType.WOODS) {
            return "A peaceful forest shrine glows with green light.";
        }
        if (area.getType() == AreaType.CAVERNS) {
            return "A forgotten underground altar offers a moment of safety.";
        }
        return "A rare oasis shields you from the Dragon's flames.";
    }

    private String getStoryMessage(Area area) {
        if (area.getType() == AreaType.WOODS) {
            return "The trees whisper about an ancient guardian protecting the forest.";
        }
        if (area.getType() == AreaType.CAVERNS) {
            return "You find ancient markings warning of a creature beneath the mountain.";
        }
        return "The scorched ground reveals that the Dragon is close.";
    }
}
