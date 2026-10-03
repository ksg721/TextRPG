import java.util.ArrayList;

public class AreaFactory {
    private AreaFactory() {
        // This class only creates areas and should not be instantiated.
    }

    public static ArrayList<Area> createAreas() {
        ArrayList<Area> areas = new ArrayList<>();

        areas.add(new Area(
                AreaType.WOODS,
                "Whispering Woods",
                "A living forest of tangled roots, hidden paths, and ancient magic.",
                1.0,
                new String[] {"Goblin", "Crab", "Wolf", "Spider"},
                15,
                "Ancient Treant"));

        areas.add(new Area(
                AreaType.CAVERNS,
                "Cursed Caverns",
                "A maze of tunnels, unstable ceilings, and creatures changed by a curse.",
                1.25,
                new String[] {"Slime", "Skeleton", "Vampire", "Orc"},
                15,
                "Cave Wyrm"));

        areas.add(new Area(
                AreaType.WASTES,
                "Dragon's Wastes",
                "A scorched wasteland where lava, firestorms, and the Dragon block the way forward.",
                1.5,
                new String[] {"Troll", "Golem"},
                15,
                "Dragon"));

        return areas;
    }
}
