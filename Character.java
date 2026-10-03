public abstract class Character {
    private String name;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int armor;
    private int poisonTurns;
    private int poisonDamage;
    private int nextDamageReductionPercent;

    public Character(String name, int health, int attackPower, int armor) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
        this.armor = armor;
    }

    public void displayStatus() {
        System.out.println(name + " has " + health + "/" + maxHealth + " health.");
        if (poisonTurns > 0) {
            System.out.println(name + " is poisoned for " + poisonTurns + " more turn(s).");
        }
    }

    public void takeDamage(int damage) {
        int damageAfterArmor = Math.max(0, damage - getArmor());
        int actualDamage;

        if (nextDamageReductionPercent >= 100) {
            actualDamage = 0;
            System.out.println(name + " blocks the attack completely!");
        } else if (nextDamageReductionPercent > 0) {
            int reduction = nextDamageReductionPercent;
            actualDamage = Math.max(1,
                    (damageAfterArmor * (100 - reduction) + 99) / 100);
            System.out.println(name + " reduces the incoming damage by "
                    + reduction + "%. ");
        } else {
            actualDamage = Math.max(1, damageAfterArmor);
        }

        nextDamageReductionPercent = 0;
        health = Math.max(0, health - actualDamage);
        System.out.println(name + " takes " + actualDamage + " damage.");
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = Math.max(0, armor);
    }

    public int getBaseArmor() {
        return armor;
    }

    public void setBaseArmor(int armor) {
        setArmor(armor);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = Math.max(1, maxHealth);
        if (health > this.maxHealth) health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = Math.max(0, attackPower);
    }

    public int getPoisonTurns() {
        return poisonTurns;
    }

    public void setPoisonTurns(int poisonTurns) {
        this.poisonTurns = Math.max(0, poisonTurns);
    }

    public int getPoisonDamage() {
        return poisonDamage;
    }

    public void setPoisonDamage(int poisonDamage) {
        this.poisonDamage = Math.max(0, poisonDamage);
    }

    public int getNextDamageReductionPercent() {
        return nextDamageReductionPercent;
    }

    public void setNextDamageReductionPercent(int reductionPercent) {
        nextDamageReductionPercent = Math.max(0, Math.min(100, reductionPercent));
    }

    public void reduceNextDamage(int reductionPercent) {
        setNextDamageReductionPercent(
                Math.max(nextDamageReductionPercent, reductionPercent));
    }

    public void blockNextAttack() {
        setNextDamageReductionPercent(100);
    }

    public void applyPoison(int damage, int turns) {
        poisonDamage = Math.max(poisonDamage, damage);
        poisonTurns = Math.max(poisonTurns, turns);
        System.out.println(name + " is poisoned!");
    }

    public void processStatusEffects() {
        if (poisonTurns > 0 && isAlive()) {
            System.out.println(name + " takes " + poisonDamage + " poison damage.");
            health = Math.max(0, health - poisonDamage);
            poisonTurns--;
            if (poisonTurns == 0) poisonDamage = 0;
        }
    }

    public void curePoison() {
        if (poisonTurns > 0) {
            poisonTurns = 0;
            poisonDamage = 0;
            System.out.println(name + " is no longer poisoned.");
        } else {
            System.out.println(name + " is not poisoned.");
        }
    }

    public boolean isPoisoned() {
        return poisonTurns > 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void attack(Character target);
}
