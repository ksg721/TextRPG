public class Bard extends Player {
    private int battleSongUses = 0;

    public Bard(String name) { super(name, 95, 9, 2); }

    public void battleSong() {
        System.out.println(getName() + " plays a Battle Song!");
        battleSongUses++;
        setAttackPower(getAttackPower() + 1);
        if (battleSongUses % 2 == 0) {
            setBaseArmor(getBaseArmor() + 1);
            System.out.println(getName() + " gains 1 attack power and 1 armor. The song can grow stronger over time.");
        } else {
            System.out.println(getName() + " gains 1 attack power. The song can grow stronger over time.");
        }
    }

    @Override
    public String getSpecialAbilityName() { return "Battle Song"; }

    @Override
    public void useSpecialAbility(Character target) { battleSong(); }
}
