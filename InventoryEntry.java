public class InventoryEntry {
    private Item item;
    private int quantity;

    public InventoryEntry(Item item) {
        this.item = item;
        this.quantity = 1;
    }

    public Item getItem() { return item; }
    public int getQuantity() { return quantity; }
    public void increaseQuantity() { quantity++; }
    public void decreaseQuantity() { quantity--; }
}
