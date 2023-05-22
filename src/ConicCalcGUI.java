import javax.swing.*;
import java.awt.*;

public class ConicCalcGUI extends JFrame {
    private JTextField textField1;
    private JPanel mainPanel;
    private JButton button1;
    private ImageIcon icon;


    public ConicCalcGUI()
    {
        setTitle("Conic Section Calculator");
        setContentPane(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        icon = new ImageIcon("image1.png");
        setIconImage(icon.getImage());
        setSize(500, 500);
        setVisible(true);


    }

}

