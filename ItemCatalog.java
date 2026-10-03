import java.util.ArrayList;

public class ItemCatalog {
    public static ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();

        // Upgraded weapons
        items.add(new Weapon("Steel Longsword", "A stronger sword for warriors.", 100, 9));
        items.add(new Weapon("Twin Shadow Daggers", "Fast blades favored by rogues.", 95, 8));
        items.add(new Weapon("Arcane Staff", "A staff filled with magical power.", 120, 10));
        items.add(new Weapon("Sun Mace", "A blessed weapon for paladins.", 110, 8));
        items.add(new Weapon("Hunter's Bow", "A powerful bow for rangers.", 100, 9));
        items.add(new Weapon("Berserker Axe", "A massive axe built for heavy strikes.", 115, 12));
        items.add(new Weapon("Heartwood Staff", "A staff strengthened by nature magic.", 90, 8));
        items.add(new Weapon("Soulreaper Wand", "A wand that channels dark energy.", 125, 11));
        items.add(new Weapon("Dragonbone Staff", "A staff made from ancient dragon bone.", 140, 10));
        items.add(new Weapon("Iron Quarterstaff", "A reinforced staff for experienced monks.", 85, 7));
        items.add(new Weapon("Masterwork Lute", "A lute that makes every battle song stronger.", 90, 6));

        // Monster-drop weapons
        items.add(new Weapon("Rusty Dagger", "A worn blade recovered from a goblin camp.", 25, 2));
        items.add(new Weapon("Shellbreaker Club", "A crude club reinforced with crab shell.", 30, 3));
        items.add(new Weapon("Hunter's Spear", "A spear made for tracking woodland prey.", 35, 3));
        items.add(new Weapon("Venomfang Dagger", "A dagger coated with harmless spider venom.", 35, 3));
        items.add(new Weapon("Crystal Sludge Staff", "A staff hardened from magical slime.", 55, 4));
        items.add(new Weapon("Bone Sword", "A sword carved from ancient bones.", 65, 5));
        items.add(new Weapon("Bloodsteel Rapier", "A thin blade favored by vampires.", 75, 6));
        items.add(new Weapon("Orcish Cleaver", "A heavy blade forged in a cavern war camp.", 75, 6));
        items.add(new Weapon("Troll Club", "A massive club shaped from wasteland stone.", 90, 7));
        items.add(new Weapon("Stonebreaker Hammer", "A hammer cut from a golem's core.", 100, 8));
        items.add(new Weapon("Dragonfang Blade", "A blade sharpened with a dragon's fang.", 115, 9));

        // Upgraded armor
        items.add(new Armor("Knight Plate", "Heavy armor for experienced warriors.", 120, 8));
        items.add(new Armor("Greater Shadowcloak", "A cloak that protects without slowing its wearer.", 105, 5));
        items.add(new Armor("Archmage Robe", "A robe reinforced with protective magic.", 115, 4));
        items.add(new Armor("Paladin Plate", "Blessed armor with excellent protection.", 135, 9));
        items.add(new Armor("Hunter's Mail", "Flexible armor for experienced rangers.", 100, 5));
        items.add(new Armor("Berserker Harness", "Protection that still allows powerful movement.", 90, 4));
        items.add(new Armor("Living Bark Armor", "Armor grown from an ancient tree.", 110, 6));
        items.add(new Armor("Boneweave Robe", "A dark robe reinforced with bone.", 100, 4));
        items.add(new Armor("Master Monk Gi", "Light armor designed for martial artists.", 95, 5));
        items.add(new Armor("Enchanter's Garb", "Clothing strengthened by a bard's magic.", 100, 5));

        // Monster-drop armor
        items.add(new Armor("Patchwork Leather", "Leather pieced together from goblin scraps.", 20, 1));
        items.add(new Armor("Crab Shell Guard", "A small shield made from a crab shell.", 25, 2));
        items.add(new Armor("Wolfhide Vest", "A light vest made from wolf hide.", 30, 2));
        items.add(new Armor("Spider Silk Cloak", "A flexible cloak woven from spider silk.", 30, 2));
        items.add(new Armor("Slimeproof Wraps", "Wraps coated to resist sticky cave slime.", 45, 3));
        items.add(new Armor("Boneplate Armor", "Armor reinforced with polished bone.", 55, 3));
        items.add(new Armor("Vampire Cloak", "A dark cloak that protects against cave winds.", 65, 4));
        items.add(new Armor("Orcish Hide Armor", "Heavy armor made from cavern beasts.", 65, 4));
        items.add(new Armor("Trollhide Armor", "Thick armor made from resilient troll hide.", 80, 5));
        items.add(new Armor("Golemplate Armor", "Stone-plated armor that absorbs heavy blows.", 95, 6));
        items.add(new Armor("Dragon Scale Armor", "Armor crafted from fire-resistant scales.", 110, 7));

        // Consumables
        items.add(new Consumable("Forest Herb", "A woodland herb that restores 20 health.", 8, 20));
        items.add(new Consumable("Wolf Jerky", "Dried meat that restores 15 health.", 5, 15));
        items.add(new Antidote("Spider Antidote", "Cures spider venom and restores 10 health.", 20, 10));
        items.add(new Consumable("Cavern Salve", "A mineral salve that restores 35 health.", 22, 35));
        items.add(new Consumable("Blood Vial", "A vampire's blood that restores 25 health.", 18, 25));
        items.add(new Consumable("Bone Broth", "A warm broth that restores 35 health.", 22, 35));
        items.add(new Consumable("Ember Tonic", "A hot tonic that restores 50 health.", 30, 50));
        items.add(new Consumable("Golem Core Fragment", "A crystal fragment that restores 50 health.", 30, 50));
        items.add(new Consumable("Greater Health Potion", "Restores 50 health.", 30, 50));
        items.add(new Consumable("Elixir", "Restores 100 health.", 75, 100));
        items.add(new Consumable("Healing Herb", "Restores 20 health.", 8, 20));
        items.add(new Antidote("Antidote", "Cures poison and restores 10 health.", 20, 10));

        // Quest items
        items.add(new QuestItem("Brass Key", "Unlocks a locked door.", 0));
        items.add(new QuestItem("Dragon Eye", "May unlock the entrance to the final area.", 0));
        items.add(new QuestItem("Royal Seal", "Proof that an important quest was completed.", 0));
        items.add(new QuestItem("Lost Map", "Reveals a hidden location.", 0));

        return items;
    }

    public static Item getAreaReward(Area area, Player player) {
        if (area.getType() == AreaType.WOODS) {
            return new Consumable("Greater Health Potion", "Restores 50 health.", 30, 50);
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (player instanceof Warrior) return new Weapon("Steel Longsword", "A stronger sword for warriors.", 100, 9);
            if (player instanceof Rogue) return new Weapon("Twin Shadow Daggers", "Fast blades favored by rogues.", 95, 8);
            if (player instanceof Mage) return new Weapon("Arcane Staff", "A staff filled with magical power.", 120, 10);
            if (player instanceof Paladin) return new Weapon("Sun Mace", "A blessed weapon for paladins.", 110, 8);
            if (player instanceof Ranger) return new Weapon("Hunter's Bow", "A powerful bow for rangers.", 100, 9);
            if (player instanceof Berserker) return new Weapon("Berserker Axe", "A massive axe built for heavy strikes.", 115, 12);
            if (player instanceof Druid) return new Weapon("Heartwood Staff", "A staff strengthened by nature magic.", 90, 8);
            if (player instanceof Necromancer) return new Weapon("Soulreaper Wand", "A wand that channels dark energy.", 125, 11);
            if (player instanceof Monk) return new Weapon("Iron Quarterstaff", "A reinforced staff for experienced monks.", 85, 7);
            if (player instanceof Bard) return new Weapon("Masterwork Lute", "A lute that makes every battle song stronger.", 90, 6);
        }

        if (area.getType() == AreaType.WASTES) {
            if (player instanceof Warrior) return new Armor("Knight Plate", "Heavy armor for experienced warriors.", 120, 8);
            if (player instanceof Rogue) return new Armor("Greater Shadowcloak", "A cloak that protects without slowing its wearer.", 105, 5);
            if (player instanceof Mage) return new Armor("Archmage Robe", "A robe reinforced with protective magic.", 115, 4);
            if (player instanceof Paladin) return new Armor("Paladin Plate", "Blessed armor with excellent protection.", 135, 9);
            if (player instanceof Ranger) return new Armor("Hunter's Mail", "Flexible armor for experienced rangers.", 100, 5);
            if (player instanceof Berserker) return new Armor("Berserker Harness", "Protection that still allows powerful movement.", 90, 4);
            if (player instanceof Druid) return new Armor("Living Bark Armor", "Armor grown from an ancient tree.", 110, 6);
            if (player instanceof Necromancer) return new Armor("Boneweave Robe", "A dark robe reinforced with bone.", 100, 4);
            if (player instanceof Monk) return new Armor("Master Monk Gi", "Light armor designed for martial artists.", 95, 5);
            if (player instanceof Bard) return new Armor("Enchanter's Garb", "Clothing strengthened by a bard's magic.", 100, 5);
        }

        return null;
    }

    public static Item getEncounterItem(Area area) {
        if (area.getType() == AreaType.WOODS) {
            if (Math.random() < 0.5) {
                return new Consumable("Healing Herb", "Restores 20 health.", 8, 20);
            }
            return new Consumable("Trail Rations", "Restores 15 health.", 5, 15);
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (Math.random() < 0.25) {
                return new Antidote("Antidote", "Cures poison and restores 10 health.", 20, 10);
            }
            return new Consumable("Greater Health Potion", "Restores 50 health.", 30, 50);
        }

        if (Math.random() < 0.75) {
            return new Consumable("Elixir", "Restores 100 health.", 75, 100);
        }
        return new Consumable("Greater Health Potion", "Restores 50 health.", 30, 50);
    }

    public static Item getMonsterReward(Area area, Monster monster) {
        if (Math.random() >= 0.20) return null;

        double rewardType = Math.random();
        if (rewardType < 0.50) {
            return getMonsterConsumableReward(area, monster);
        }
        if (rewardType < 0.75) {
            return getMonsterWeaponReward(area, monster);
        }
        return getMonsterArmorReward(area, monster);
    }

    private static Item getMonsterConsumableReward(Area area, Monster monster) {
        if (area.getType() == AreaType.WOODS) {
            if (monster instanceof Spider) {
                return new Antidote(
                        "Spider Antidote",
                        "Cures spider venom and restores 10 health.",
                        20,
                        10);
            }
            if (monster instanceof Wolf) {
                return new Consumable(
                        "Wolf Jerky",
                        "Dried meat that restores 15 health.",
                        5,
                        15);
            }
            return new Consumable(
                    "Forest Herb",
                    "A woodland herb that restores 20 health.",
                    8,
                    20);
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (monster instanceof Vampire) {
                return new Consumable(
                        "Blood Vial",
                        "A vampire's blood that restores 25 health.",
                        18,
                        25);
            }
            if (monster instanceof Skeleton) {
                return new Consumable(
                        "Bone Broth",
                        "A warm broth that restores 35 health.",
                        22,
                        35);
            }
            return new Consumable(
                    "Cavern Salve",
                    "A mineral salve that restores 35 health.",
                    22,
                    35);
        }

        if (monster instanceof Golem) {
            return new Consumable(
                    "Golem Core Fragment",
                    "A crystal fragment that restores 50 health.",
                    30,
                    50);
        }
        return new Consumable(
                "Ember Tonic",
                "A hot tonic that restores 50 health.",
                30,
                50);
    }

    private static Item getMonsterWeaponReward(Area area, Monster monster) {
        if (area.getType() == AreaType.WOODS) {
            if (monster instanceof Goblin) {
                return new Weapon("Rusty Dagger", "A worn blade recovered from a goblin camp.", 25, 2);
            }
            if (monster instanceof Crab) {
                return new Weapon("Shellbreaker Club", "A crude club reinforced with crab shell.", 30, 3);
            }
            if (monster instanceof Wolf) {
                return new Weapon("Hunter's Spear", "A spear made for tracking woodland prey.", 35, 3);
            }
            return new Weapon("Venomfang Dagger", "A dagger coated with harmless spider venom.", 35, 3);
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (monster instanceof Slime) {
                return new Weapon("Crystal Sludge Staff", "A staff hardened from magical slime.", 55, 4);
            }
            if (monster instanceof Skeleton) {
                return new Weapon("Bone Sword", "A sword carved from ancient bones.", 65, 5);
            }
            if (monster instanceof Vampire) {
                return new Weapon("Bloodsteel Rapier", "A thin blade favored by vampires.", 75, 6);
            }
            return new Weapon("Orcish Cleaver", "A heavy blade forged in a cavern war camp.", 75, 6);
        }

        if (monster instanceof Golem) {
            return new Weapon("Stonebreaker Hammer", "A hammer cut from a golem's core.", 100, 8);
        }
        return new Weapon("Troll Club", "A massive club shaped from wasteland stone.", 90, 7);
    }

    private static Item getMonsterArmorReward(Area area, Monster monster) {
        if (area.getType() == AreaType.WOODS) {
            if (monster instanceof Goblin) {
                return new Armor("Patchwork Leather", "Leather pieced together from goblin scraps.", 20, 1);
            }
            if (monster instanceof Crab) {
                return new Armor("Crab Shell Guard", "A small shield made from a crab shell.", 25, 2);
            }
            if (monster instanceof Wolf) {
                return new Armor("Wolfhide Vest", "A light vest made from wolf hide.", 30, 2);
            }
            return new Armor("Spider Silk Cloak", "A flexible cloak woven from spider silk.", 30, 2);
        }

        if (area.getType() == AreaType.CAVERNS) {
            if (monster instanceof Slime) {
                return new Armor("Slimeproof Wraps", "Wraps coated to resist sticky cave slime.", 45, 3);
            }
            if (monster instanceof Skeleton) {
                return new Armor("Boneplate Armor", "Armor reinforced with polished bone.", 55, 3);
            }
            if (monster instanceof Vampire) {
                return new Armor("Vampire Cloak", "A dark cloak that protects against cave winds.", 65, 4);
            }
            return new Armor("Orcish Hide Armor", "Heavy armor made from cavern beasts.", 65, 4);
        }

        if (monster instanceof Golem) {
            return new Armor("Golemplate Armor", "Stone-plated armor that absorbs heavy blows.", 95, 6);
        }
        return new Armor("Trollhide Armor", "Thick armor made from resilient troll hide.", 80, 5);
    }

}
