import java.util.ArrayList;

public class Player extends Character {
    private static final int SPECIAL_ABILITY_COOLDOWN = 3;
    private int level = 1;
    private int experience = 0;
    private int experienceToNextLevel = 100;
    private ArrayList<InventoryEntry> inventory = new ArrayList<>();
    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private int specialCooldown = 0;

    public Player(String name, int health, int attackPower, int armor) {
        super(name, health, attackPower, armor);
    }

    @Override
    public void displayStatus() {
        System.out.println(getName() + " - Level " + level + " - Health: "
                + getHealth() + "/" + getMaxHealth() + " - Attack: " + getTotalAttackPower()
                + " - Armor: " + getArmor());
        System.out.println("Experience: " + experience + "/" + experienceToNextLevel);
    }

    public void gainExperience(int amount) {
        experience += amount;
        System.out.println(getName() + " gained " + amount + " experience.");

        while (experience >= experienceToNextLevel) {
            experience -= experienceToNextLevel;
            levelUp();
        }
    }

    public void restAtShrine() {
        setHealth(getMaxHealth());
        specialCooldown = 0;
        if (isPoisoned()) curePoison();
        System.out.println(getName() + " rests at the shrine and is fully restored.");
    }

    private void levelUp() {
        level++;
        setMaxHealth(getMaxHealth() + 10);
        setHealth(getMaxHealth());
        setAttackPower(getAttackPower() + 2);
        setBaseArmor(getBaseArmor() + 1);
        experienceToNextLevel += 75;

        System.out.println("Level up! " + getName() + " is now level " + level + ".");
        System.out.println("Max health, attack, and armor increased.");
    }

    public void addItem(Item item) {
        InventoryEntry entry = findEntry(item.getName());
        if (entry == null) inventory.add(new InventoryEntry(item));
        else entry.increaseQuantity();
        System.out.println(item.getName() + " was added to the inventory.");
    }

    public void removeItem(String itemName) {
        InventoryEntry entry = findEntry(itemName);
        if (entry == null) {
            System.out.println("You do not have a " + itemName + ".");
            return;
        }
        entry.decreaseQuantity();
        if (entry.getQuantity() <= 0) inventory.remove(entry);
        System.out.println(itemName + " was removed from the inventory.");
    }

    public boolean hasItem(String itemName) { return findEntry(itemName) != null; }

    public void displayInventory() {
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            return;
        }
        for (InventoryEntry entry : inventory) {
            Item item = entry.getItem();
            System.out.println("- " + item.getName() + " x" + entry.getQuantity());
            System.out.println("  " + item.getDescription());
        }
        System.out.println("Equipped weapon: "
                + (equippedWeapon == null ? "None" : equippedWeapon.getName()));
        System.out.println("Equipped armor: "
                + (equippedArmor == null ? "None" : equippedArmor.getName()));
    }

    public ItemUseResult useItem(String itemName) {
        InventoryEntry entry = findEntry(itemName);
        if (entry == null) {
            System.out.println("You do not have a " + itemName + ".");
            return ItemUseResult.NOT_USED;
        }

        Item item = entry.getItem();
        if (item instanceof EscapeItem) {
            removeItem(itemName);
            System.out.println(getName() + " uses a smoke bomb and escapes.");
            return ItemUseResult.ESCAPED;
        } else if (item instanceof Consumable) {
            boolean wasUsed = ((Consumable) item).use(this);
            if (!wasUsed) return ItemUseResult.NOT_USED;
            removeItem(itemName);
            return ItemUseResult.USED;
        } else if (item instanceof Weapon) {
            equipWeapon((Weapon) item);
            return ItemUseResult.USED;
        } else if (item instanceof Armor) {
            equipArmor((Armor) item);
            return ItemUseResult.USED;
        } else {
            System.out.println(item.getName() + " cannot be used right now.");
            return ItemUseResult.NOT_USED;
        }
    }

    public String getSpecialAbilityName() {
        return "Basic Attack";
    }

    public boolean canUseSpecialAbility() {
        return specialCooldown == 0;
    }

    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void startSpecialCooldown() {
        startSpecialCooldown(SPECIAL_ABILITY_COOLDOWN);
    }

    public void startSpecialCooldown(int cooldown) {
        specialCooldown = Math.max(0, cooldown);
    }

    public void reduceSpecialCooldown() {
        if (specialCooldown > 0) specialCooldown--;
    }

    public void useSpecialAbility(Character target) {
        attack(target);
    }

    public boolean heal(int amount) {
        int previousHealth = getHealth();
        setHealth(getHealth() + amount);
        int actualHealing = getHealth() - previousHealth;

        if (actualHealing == 0) {
            System.out.println(getName() + " is already at full health.");
            return false;
        } else {
            System.out.println(getName() + " heals for " + actualHealing + " health.");
            return true;
        }
    }

    public void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
        System.out.println(getName() + " equipped " + weapon.getName() + ".");
    }

    public void equipArmor(Armor armorItem) {
        equippedArmor = armorItem;
        System.out.println(getName() + " equipped " + armorItem.getName() + ".");
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public int getTotalAttackPower() {
        return getAttackPower()
                + (equippedWeapon == null ? 0 : equippedWeapon.getAttackBonus());
    }

    @Override
    public int getArmor() {
        return getBaseArmor()
                + (equippedArmor == null ? 0 : equippedArmor.getArmorBonus());
    }

    private InventoryEntry findEntry(String itemName) {
        for (InventoryEntry entry : inventory) {
            if (entry.getItem().getName().equalsIgnoreCase(itemName)) return entry;
        }
        return null;
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " attacks the monster!");
        target.takeDamage(getTotalAttackPower());
    }
}
