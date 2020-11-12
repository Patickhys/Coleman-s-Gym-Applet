package ui.panels;

import model.Training;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TrainingPanel extends JPanel {
    private Training training;
    private JPanel currentPanel;
    private JTextArea textArea;
    private JButton enterButton;
    private JTextField textField;
    private ArrayList<String> answerList;

    public TrainingPanel() {
        currentPanel = new JPanel();
        enterButton = new JButton("Enter");
        answerList = new ArrayList<>();
    }



    // MODIFIES:this
    // EFFECTS: Helper method that makes a panel for the given question
    public JPanel firstQuestion() {
        return questionPanel("What exercise did you do?");
    }

    // MODIFIES:this
    // EFFECTS: Helper method that makes a panel for the given question
    public JPanel secondQuestion() {
        return questionPanel("How many calories did you burn?");
    }

    // MODIFIES:this
    // EFFECTS: Helper method that makes a panel for the given question
    public JPanel thirdQuestion() {
        return questionPanel("How long in minutes did you exercise?");
    }

    // MODIFIES:this
    // EFFECTS: Helper method that makes a panel for the given question
    private JPanel questionPanel(String question) {
        currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.Y_AXIS));
        currentPanel.setPreferredSize(new Dimension(200, 100));
        textArea = new JTextArea(question);
        textArea.setEditable(false);
        textArea.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        textField = new JTextField("Enter your answer", 10);
        textField.setFont((new Font("TimesRoman", Font.PLAIN, 22)));
        enterButton.addActionListener(new EnterButtonClickerHandler());
        currentPanel.add(textArea);
        currentPanel.add(textField);
        currentPanel.add(enterButton);
        return currentPanel;
    }


    // EFFECTS: submit an user input in the text area when the enter button is clicked
    private class EnterButtonClickerHandler implements ActionListener {


        @Override
        // if the button is pressed, save the input answer
        public void actionPerformed(ActionEvent e) {
            String answer = textField.getText();
            answerHandler(answer);
        }
    }

    // MODIFIES: this
    // EFFECTS: take in an answer string
    private void answerHandler(String answer) {
        answerList.add(answer);
    }

    public Training makeTraining() {
        return training = new Training(answerList.get(0),
                Integer.parseInt(answerList.get(1)),
                Integer.parseInt(answerList.get(2)));
    }
}
