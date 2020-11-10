package ui.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MealPanel extends JPanel {
    private JPanel mealPanel;
    private JTextArea textArea;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enterButton;
    private String text;

    // EFFECTS: make a new meal panel
    public MealPanel(){
    }


    // EFFECTS: return a user panel
    public JPanel makeMealPanel() {
        mealPanel = new JPanel();
        mealPanel.setLayout(new BoxLayout(mealPanel, BoxLayout.Y_AXIS));
        mealPanel.setPreferredSize(new Dimension(200, 100));
        makeQandAArea();
        enterButton.addActionListener(new EnterButtonClickerHandler());
        mealPanel.add(textArea);
        mealPanel.add(textField1);
        mealPanel.add(textField2);
        mealPanel.add(textField3);
        mealPanel.add(enterButton);
        return mealPanel;
    }

    private void makeQandAArea() {
        String question = "Please enter your carbs,protein and fat intake in grams!";
        textArea = new JTextArea(question);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        textField1 = new JTextField("Enter your carbs intake", 10);
        textField1.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        textField2 = new JTextField("Enter your protein intake", 10);
        textField2.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        textField3 = new JTextField("Enter your fat intake", 10);
        textField3.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton = new JButton("Enter");
    }

    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, make input text the username
        public void actionPerformed(ActionEvent e) {
            text = textArea.getText();
        }
    }
}
