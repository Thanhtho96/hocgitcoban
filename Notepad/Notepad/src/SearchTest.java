import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class SearchTest {
    JList list;
    JLabel label;
 
    private void search(String text) {
        DefaultListModel model = (DefaultListModel)list.getModel();
        // Case–sensitive.
        if(model.contains(text)) {
            int index = model.indexOf(text);
            list.setSelectedIndex(index);
            label.setText(text + " found at index " + index);
        } else {
            list.clearSelection();
            label.setText(text + " not found");
        }
    }
 
    private JScrollPane getListComponent() {
        String[] items = { "Bob", "Ted", "Carol", "Alice" };
        DefaultListModel model = new DefaultListModel();
        for(int j = 0; j < items.length; j++)
            model.add(j, items[j]);
        list = new JList(model);
        return new JScrollPane(list);
    }
 
    private JPanel getFirst() {
        final JTextField textField = new JTextField(12);
        JButton button = new JButton("Search");
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                search(text);
            }
        };
        textField.addActionListener(al);
        button.addActionListener(al);
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);
        return panel;
    }
 
    private JLabel getLabel() {
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        Dimension d = label.getPreferredSize();
        d.height = 25;
        label.setPreferredSize(d);
        return label;
    }
 
    public static void main(String[] args) {
        SearchTest test = new SearchTest();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(test.getListComponent());
        f.add(test.getFirst(), "First");
        f.add(test.getLabel(), "Last");
        f.setSize(360,240);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}