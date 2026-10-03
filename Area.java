public class Area {
    private AreaType type;
    private String name;
    private String description;
    private double experienceMultiplier;
    private String[] monsterNames;
    private int regularEncounterCount;
    private String bossName;

    public Area(AreaType type, String name, String description, double experienceMultiplier,
            String[] monsterNames, int regularEncounterCount, String bossName) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.experienceMultiplier = experienceMultiplier;
        this.monsterNames = monsterNames;
        this.regularEncounterCount = regularEncounterCount;
        this.bossName = bossName;
    }

    public String getName() {
        return name;
    }

    public AreaType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public int getRegularEncounterCount() {
        return regularEncounterCount;
    }

    public String getBossName() {
        return bossName;
    }

    public void displayMonsterOptions() {
        for (int i = 0; i < monsterNames.length; i++) {
            System.out.println((i + 1) + ". " + monsterNames[i]);
        }
        System.out.println("0. Return to area selection");
    }

    public Monster createMonster(int choice) {
        if (type == AreaType.WOODS) {
            switch (choice) {
                case 1: return new Goblin("Goblin");
                case 2: return new Crab("Crab");
                case 3: return new Wolf("Wolf");
                case 4: return new Spider("Spider");
                default: return null;
            }
        }

        if (type == AreaType.CAVERNS) {
            switch (choice) {
                case 1: return new Slime("Slime");
                case 2: return new Skeleton("Skeleton");
                case 3: return new Vampire("Vampire");
                case 4: return new Orc("Orc");
                default: return null;
            }
        }

        if (type == AreaType.WASTES) {
            switch (choice) {
                case 1: return new Troll("Troll");
                case 2: return new Golem("Golem");
                case 3: return new Dragon("Dragon");
                default: return null;
            }
        }

        return null;
    }

    public Monster createRandomMonster() {
        int choice = (int) (Math.random() * monsterNames.length) + 1;
        return createMonster(choice);
    }

    public Monster createBoss() {
        if (bossName.equals("Ancient Treant")) return new Treant(bossName);
        if (bossName.equals("Cave Wyrm")) return new CaveWyrm(bossName);
        if (bossName.equals("Dragon")) return new Dragon(bossName);
        return null;
    }

    public int getExperienceReward(Monster monster) {
        return (int) Math.round(monster.getExperienceReward() * experienceMultiplier);
    }
}
