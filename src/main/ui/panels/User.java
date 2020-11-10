package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class User extends JPanel {
    private String name;
    private  int height;
    public Scanner scanner;
    private JPanel userPanel;
    private JTextArea textArea;
    private JButton enterButton;



    //EFFECTS: construct a new user
    public User(){}

    //EFFECTS: construct a new user
    public User(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // EFFECTS: return a user panel

    public JPanel makeUserPanel() {
        userPanel = new JPanel();
        userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.Y_AXIS));
        userPanel.setPreferredSize(new Dimension(200, 100));
        String welcomeText = "Welcome to COLEMAN's \n Please enter your name!";
        textArea = new JTextArea(welcomeText);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        JTextField textField = new JTextField("Enter your name", 10);
        textField.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonClickerHandler());
        userPanel.add(textArea);
        userPanel.add(textField);
        userPanel.add(enterButton);
        return userPanel;
    }

    // MODIFIES: this
    // EFFECTS: create a new user profile
    public void initializeUser() {
        scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Please enter your height in cm!");
        scanner = new Scanner(System.in);
        height = scanner.nextInt();

    }

    // getters
    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, make input text the username
        public void actionPerformed(ActionEvent e) {
            name = textArea.getText();
        }
    }
}
