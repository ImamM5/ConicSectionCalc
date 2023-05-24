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
        icon = new ImageIcon(getClass().getResource("image.png"));
        setIconImage(icon.getImage());
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
                    ImageIcon parabola = new ImageIcon(getClass().getResource("parabola.png"));
                    JOptionPane.showMessageDialog(null,"The equation represents a parabola.", "Calculation results", JOptionPane.INFORMATION_MESSAGE, parabola);
                }
                else if (conicC.determineEquation().equals("The equation represents a hyperbola."))
                {
                    ImageIcon hyperbola = new ImageIcon(getClass().getResource("hyperbola.png"));
                    JOptionPane.showMessageDialog(null,"The equation represents a hyperbola.", "Calculation results", JOptionPane.INFORMATION_MESSAGE, hyperbola);
                }
                else if (conicC.determineEquation().equals("The equation represents an ellipse."))
                {
                    ImageIcon ellipse = new ImageIcon(getClass().getResource("ellipse.png"));
                    JOptionPane.showMessageDialog(null,"The equation represents an ellipse.", "Calculation results", JOptionPane.INFORMATION_MESSAGE, ellipse);
                }
                else if (conicC.determineEquation().equals("The equation represents a circle."))
                {
                    ImageIcon circle = new ImageIcon(getClass().getResource("image1.jpg"));
                    JOptionPane.showMessageDialog(null,"The equation represents a circle.", "Calculation results", JOptionPane.INFORMATION_MESSAGE, circle);
                }
                else if (conicC.determineEquation().equals("The equation represents a line."))
                {
                    ImageIcon line = new ImageIcon(getClass().getResource("line.jpg"));
                    JOptionPane.showMessageDialog(null,"The equation represents a line.", "Calculation results", JOptionPane.INFORMATION_MESSAGE, line);
                }

            }
        }

    }



}

