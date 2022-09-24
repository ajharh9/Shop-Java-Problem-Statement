package Java_Problem_Statement;

public class Item {

    String itemName;
    long price;
    int quantity, itemId;
    static int n = 1;
    Item(String itemName, long price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        itemId = n;
        n = n+1;
    }
}
