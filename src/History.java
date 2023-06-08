import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class History extends JFrame {
    private JList list1;
    private JPanel mainPanel;
    private JLabel label;

    public History(ArrayList<String> str)
    {
        setContentPane(mainPanel);
        setTitle("History");
        DefaultListModel mod = new DefaultListModel();
        label.setFont(new Font("Monospaced", Font.PLAIN, 14));

        for (String texts : str)
        {
            mod.addElement(texts);
        }

        list1.setModel(mod);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);






        setSize(500, 500);

        setLocationRelativeTo(null);
        setVisible(true);

    }
}
