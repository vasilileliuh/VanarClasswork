package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Application {

    private static List<String> catsNameList = new ArrayList<>();


    public static void main(String[] args) {

//        GUI - Graphical User Interface
//        CLI - Command Line Interface

//        JavaFX (OPEN SOURCE!)  - Framework

//        Java Swing
        //   DOM -> document object model
        //   DESIGN -> layouts
        // * Composition
        // * Observers(Events ---> Actions)
        // * dynamic class / anonymous class

        initGUI();


    }

    public static void initGUI() {
        JButton saveBtn = new JButton("SAVE");
        JTextField nameInput = new JTextField();

        JFrame window = new JFrame("Cat Database App");

        window.getContentPane().add(nameInput);
        window.getContentPane().add(saveBtn);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.PAGE_AXIS));
        window.setBounds(100, 100, 400, 300);
        window.show();

//        Observer  - anonymous
//        IoC - Inversion of Control
//        следующий код привязывает обработчик к событию "нажатие на кнопку"
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                accumulate
                catsNameList.add(nameInput.getText());
//                System.out.println(catsNameList.get(catsNameList.size() - 1));
//                System.out.println("Cats in the collection= " + catsNameList.size());
                printList();
                nameInput.setText("");

            }
        });


    }

    public static void printList() {
        System.out.print("[" + catsNameList.size() + "]: ");
        for (String name : catsNameList)
            System.out.print(catsNameList.indexOf(name) == 0 ? name : "," + name);
        System.out.println();
//            System.out.println(String.join(",", catsNameList));


    }

}
