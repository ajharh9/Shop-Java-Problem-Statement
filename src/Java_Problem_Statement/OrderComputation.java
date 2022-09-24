package Java_Problem_Statement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderComputation extends JFrame {
    ItemList itemListInStore = new ItemList();

    // itemInStore variable is used to see the list of item present in the item-list class, the quantity of item
    // get decreases automatically after each item add to cart
    List<Item> itemsInStore = itemListInStore.getListOfItem();
    int[] itemIdAndQuantity;
    int y = 76, y1 = 76;
    long totalPrice = 0;

    public void getPrint(int id) {
        Item selectedItem = itemsInStore.get((id));
        JLabel text = new JLabel(selectedItem.itemId + ")           " + selectedItem.itemName);
        text.setFont(new Font("OSWALD", Font.BOLD, 15));
        y += 50;
        text.setBounds(30, y, 500, 30);

        add(text);
    }

    public void getPrintPrice(int id, int quantity) {
        Item selectedItem = itemsInStore.get((id));
        totalPrice += selectedItem.price * quantity;
        JLabel text = new JLabel(selectedItem.price + "                      " + quantity + "                              " + (selectedItem.price) * (quantity));
        text.setFont(new Font("OSWALD", Font.BOLD, 15));
        y1 += 50;
        text.setBounds(270, y1, 500, 30);

        add(text);
    }


    void line(int y) {
        JLabel lineBreak = new JLabel("___________________________________________________");
        lineBreak.setFont(new Font("OSWALD", Font.BOLD, 25));
        lineBreak.setBounds(30, y + 1, 700, 30);
        add(lineBreak);
    }


    //
    OrderComputation(int[] userCart) {
        itemIdAndQuantity = userCart;
        setLayout(null);

        JLabel text = new JLabel("INVOICE");
        text.setFont(new Font("OSWALD", Font.BOLD, 38));
        text.setBounds(250, 10, 600, 60);
        add(text);

        JLabel top = new JLabel("ID              NAME             PRICE         QUANTITY       AMOUNT");
        top.setFont(new Font("OSWALD", Font.BOLD, 20));
        top.setBounds(30, 75, 600, 30);
        add(top);

        line(y);

        for (int i = 0; i < itemIdAndQuantity.length; i++) {
            if (itemIdAndQuantity[i] != 0) {
                getPrint(i);
                getPrintPrice(i, itemIdAndQuantity[i]);
            }
        }

        line(y1);

        JLabel totalPriceText = new JLabel("TOTAL AMOUNT:      " + totalPrice);
        totalPriceText.setFont(new Font("OSWALD", Font.BOLD, 20));
        y += 50;
        totalPriceText.setBounds(300, y, 400, 40);
        add(totalPriceText);

        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setVisible(true);
        setLocation(400, 10);
    }
}
