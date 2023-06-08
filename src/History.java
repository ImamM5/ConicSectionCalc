import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class History extends JFrame {
    private JList list1;
    private JPanel mainPanel;
    private JLabel label;
    private JLabel counter;

    public History(ArrayList<String> str)
    {
        setContentPane(mainPanel);
        setTitle("History");
        DefaultListModel mod = new DefaultListModel();
        label.setFont(new Font("Monospaced", Font.PLAIN, 14));

        for (int i = str.size()-1; i >= 0; i--)
        {
            mod.addElement(str.get(i));
        }

        list1.setModel(mod);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        counter.setText("You have "+ str.size() + " item(s)!");
        counter.setFont(new Font("Monospaced", Font.PLAIN, 14));
        setSize(500, 500);

        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.pink);
        setVisible(true);

    }
}
