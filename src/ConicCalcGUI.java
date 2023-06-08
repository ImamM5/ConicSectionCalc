import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ConicCalcGUI extends JFrame implements ActionListener {
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton checkButton;
    private JButton clearButton;
    private JTextArea textArea1;
    private JButton historyButton;
    private JLabel label;
    private JButton clearHistory;
    private ImageIcon icon;
    private ConicCalc conicC;
    private String equation;
    private ArrayList<String> historyTexts;
    private int historyCounter;
    private History historyWindow;


    public ConicCalcGUI()
    {

        setTitle("Conic Section Calculator");
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //icon = new ImageIcon(getClass().getResource("image.png"));
        //setIconImage(icon.getImage());
        setSize(800, 550);
        getContentPane().setBackground(Color.pink);


        checkButton.setEnabled(true);
        historyButton.setEnabled(true);
        clearButton.setEnabled(true);
        clearHistory.setEnabled(true);

        historyTexts = new ArrayList<String>();
        label.setFont(new Font("Monospaced", Font.PLAIN, 25));
        setLocationRelativeTo(null);
        setVisible(true);

        setActionListener();

    }
    public void setActionListener()
    {
        checkButton.addActionListener(this);
        historyButton.addActionListener(this);
        clearButton.addActionListener(this);
        clearHistory.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source instanceof JButton)
        {
            JButton button = (JButton)source;
            String text = button.getText();

            if (text.equals("Check"))
            {
                equation = textField1.getText();
                conicC = new ConicCalc(equation);

                //removes spaces for the elements in the historyTexts arraylist
                String eqWtSpace = equation.replaceAll("\\s+","");
                String eqWtSpaceA;
                ArrayList<String> arrayListChecker = new ArrayList<String>();

                for (String t : historyTexts)
                {
                    eqWtSpaceA = t.replaceAll("\\s+","");
                    arrayListChecker.add(eqWtSpaceA);
                }

                if (historyCounter <10 && !arrayListChecker.contains(eqWtSpace)) //sets a limit for history and check for repetition
                {
                    historyTexts.add(equation);
                    historyCounter++;
                } else if (historyCounter == 10 && !arrayListChecker.contains(eqWtSpace))
                {
                    historyTexts.remove(0);
                    historyTexts.add(equation);
                }

                if (conicC.findCSection().equals("hyperbolaF"))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents a hyperbola.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                    textArea1.setText(conicC.hyperbolaCalc());
                    textArea1.setBackground(Color.CYAN);
                }
                else if (conicC.findCSection().equals("ellipseF"))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents an ellipse.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                    textArea1.setText(conicC.ellipseCalc());
                    textArea1.setBackground(Color.YELLOW);
                }
                else if (conicC.determineEquation().equals("The equation represents an ellipse."))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents an ellipse.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (conicC.determineEquation().equals("The equation represents a circle."))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents a circle.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (conicC.determineEquation().equals("The equation represents a line."))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents a line.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (text.equals("History"))
            {
                historyWindow = new History(historyTexts);



            } else if (text.equals("Clear"))
            {
                textArea1.setText("");
                textField1.setText("");
                textArea1.setBackground(Color.white);
            } else if (text.equals("Clear History"))
            {
                historyTexts.removeAll(historyTexts);
            }
        }

    }



}

