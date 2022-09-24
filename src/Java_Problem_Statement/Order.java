package Java_Problem_Statement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Order extends JFrame implements ActionListener {
    ItemList availableItemList = new ItemList();
    List<Item> itemsInStore = availableItemList.getListOfItem();
    JButton addToCart,next;
    JTextField itemId, itemQuantity;
    int y = 115;
    int y1 = 115;
    static int [] userCart = new int[10];


    public void getPrint(Item a){
        JLabel text = new JLabel(a.itemId + ")           "+a.itemName);
        text.setFont(new Font("OSWALD",Font.BOLD,15));
        text.setBounds(30, y,500,30);
        y += 50;
        add(text);
    }
    public void getPrintPrice(Item a){
        JLabel text = new JLabel(a.price + "                       "+a.quantity);
        text.setFont(new Font("OSWALD",Font.BOLD,15));
        text.setBounds(300, y1,500,30);
        y1 += 50;
        add(text);
    }



    Order(){

        setTitle("Welcome To The Mall");
        setLayout(null);

        JLabel text = new JLabel("Welcome To The Shopping Mall");
        text.setFont(new Font("OSWALD",Font.BOLD,38));
        text.setBounds(50,5,600,60);
        add(text);

        JLabel top = new JLabel("ID              NAME                 PRICE       QUANTITY");
        top.setFont(new Font("OSWALD",Font.BOLD,20));
        top.setBounds(30, 75,500,30);
        add(top);

        JLabel lineBreak = new JLabel("___________________________________");
        lineBreak.setFont(new Font("OSWALD",Font.BOLD,25));
        lineBreak.setBounds(30, 78,500,30);
        add(lineBreak);


        availableItemList.addItems();
        for(int i=0;i<10;i++){
            getPrint(availableItemList.getListOfItem().get(i));
            getPrintPrice(availableItemList.getListOfItem().get(i));
        }

        JLabel id = new JLabel("ID :");
        id.setBounds(25,620,100,40);
        id.setFont(new Font("RaleWay",Font.BOLD,20));
        add(id);

        itemId = new JTextField();
        itemId.setBounds(60,620,50,40);
        add(itemId);

        JLabel quantity = new JLabel("QUANTITY :");
        quantity.setBounds(170,620,400,40);
        quantity.setFont(new Font("RaleWay",Font.BOLD,20));
        add(quantity);

        itemQuantity = new JTextField();
        itemQuantity.setBounds(290,620,50,40);
        add(itemQuantity);

        addToCart = new JButton("ADD TO CART");
        addToCart.setBounds(420,620,150,35);
        addToCart.addActionListener(this);
        add(addToCart);

        next = new JButton("NEXT");
        next.setBounds(550,700,100,35);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,800);
        setVisible(true);
        setLocation(400,10);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == next){
            try {
                if(userCart == null && (itemId.getText().equals("")   || itemQuantity.getText().equals(""))){
                    JOptionPane.showMessageDialog(null,"Add Items To Cart");
                }else{
                    setVisible(false);
                    new OrderComputation(userCart).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == addToCart){
            try{

                if(itemId.getText().equals("")   || itemQuantity.getText().equals("") ){
                    JOptionPane.showMessageDialog(null,"Enter ID and QUANTITY");
                }else{
                    int  quantity = Integer.parseInt(itemQuantity.getText());
                    int  id = Integer.parseInt(itemId.getText());
                    if(id>10 || id<=0){
                        JOptionPane.showMessageDialog(null,"ENTER A VALID ID");
                    }else if(itemsInStore.get(id-1).quantity==0){
                        JOptionPane.showMessageDialog(null,"ITEM IS SOLD");
                    }else if(quantity==0 || quantity > itemsInStore.get(id-1).quantity){
                        JOptionPane.showMessageDialog(null,"ENTER A VALID QUANTITY");
                    }else {
                        itemsInStore.get(id-1).quantity -= quantity;
                        if(userCart[id-1] != 0){
                            userCart[id-1] += quantity;
                        }else{
                            userCart[id-1] = quantity;
                        }
                        itemId.setText("");
                        itemQuantity.setText("");

                        setVisible(false);
                        new Order();
                    }
                }


            }catch (Exception ex){
                System.out.println(ex);
            }
        }

    }

}
