import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame implements ActionListener {
    private JButton closeButton;
    private JLabel label;
    private JPanel mainPanel;


    public WelcomeGUI()
    {
        setContentPane(mainPanel);
        setTitle("Conic Section Calculator");
        setSize(500, 300);
        closeButton.setEnabled(true);
        closeButton.addActionListener(this);
        label.setFont(new Font("Monospaced", Font.PLAIN, 20));
        getContentPane().setBackground(Color.pink);
        closeButton.setBackground(Color.CYAN);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (source instanceof JButton)
        {
            if (text.equals("Close"))
            {
                ConicCalcGUI file = new ConicCalcGUI();
                dispose();
            }
        }
    }
}
