
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.WeakHashMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JTextArea ta = new JTextArea(10, 20);
                ta.setWrapStyleWord(true);
                ta.setLineWrap(true);
                MoveToTheBottom.install(ta);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(ta));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ta.append(new Date().toString() + "\n");
                    }
                });
                timer.start();
            }
        });
    }

    public static class MoveToTheBottom implements DocumentListener {

        private static WeakHashMap<JTextComponent, DocumentListener> registry = new WeakHashMap<>(25);
        private JTextComponent parent;

        protected MoveToTheBottom(JTextComponent parent) {
            this.parent = parent;
            parent.getDocument().addDocumentListener(this);
        }

        public static void install(JTextComponent parent) {
            MoveToTheBottom bottom = new MoveToTheBottom(parent);
            registry.put(parent, bottom);
        }

        public static void uninstall(JTextComponent parent) {
            DocumentListener listener = registry.remove(parent);
            if (listener != null) {
                parent.getDocument().removeDocumentListener(listener);
            }
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            parent.setCaretPosition(e.getDocument().getLength());
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            parent.setCaretPosition(e.getDocument().getLength());
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            parent.setCaretPosition(e.getDocument().getLength());
        }

    }

}
