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
        equation = textField1.getText();
        conicC = new ConicCalc(equation);
        checkButton.addActionListener(this);
        setVisible(true);

    }

    public void popUp()
    {
        String msg ="";
        if (conicC.doMath(equation))
        {
            JOptionPane.showMessageDialog(null, "This is an equation for a circle!", "Calculator", JOptionPane.INFORMATION_MESSAGE);

        }

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
                popUp();

            }
        }

    }



}

