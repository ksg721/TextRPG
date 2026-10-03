public class Item {
    private String name;
    private String description;
    private int value;
    private ItemType type;

    public Item(String name, String description, int value, ItemType type) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.type = type;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getValue() { return value; }
    public ItemType getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setValue(int value) { this.value = value; }
    public void setType(ItemType type) { this.type = type; }

    public void displayInfo() {
        System.out.println(name + " (" + type + ") - " + description);
    }
}
