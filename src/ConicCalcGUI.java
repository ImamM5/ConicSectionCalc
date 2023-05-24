import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ConicCalcGUI extends JFrame implements ActionListener {
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton checkButton;
    private JTextArea textArea1;
    private ImageIcon icon;
    private ConicCalc conicC;
    private String equation;


    public ConicCalcGUI()
    {

        setTitle("Conic Section Calculator");
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //icon = new ImageIcon(getClass().getResource("image.png"));
        //setIconImage(icon.getImage());
        setSize(500, 500);
        checkButton.setEnabled(true);
        setVisible(true);

        setActionListener();

    }
    public void setActionListener()
    {
        checkButton.addActionListener(this);
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
                equation = textArea1.getText();
                conicC = new ConicCalc(equation);
                if (conicC.determineEquation().equals("The equation represents a parabola."))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents a parabola.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
                }
                else if (conicC.determineEquation().equals("The equation represents a hyperbola."))
                {
                    JOptionPane.showMessageDialog(null,"The equation represents a hyperbola.", "Calculation results", JOptionPane.INFORMATION_MESSAGE);
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

            }
        }

    }



}

