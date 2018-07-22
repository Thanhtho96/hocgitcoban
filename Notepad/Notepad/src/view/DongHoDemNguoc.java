package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ngockhuong
 * Lâm Ngọc Khương
 * ĐH Sư Phạm Đà Nẵng
 */
public class DongHoDemNguoc extends JFrame implements ActionListener {

    private JTextField tfTime;
    private JButton btStart;
    private JLabel lbTime;
    private int hour = 0, min = 0, sec = 0;
    private String gio, phut, giay;
    private Timer time = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 02 : 02 : 59
            if (sec == 0 && min == 0 && hour == 0) {
                time.stop();
                btStart.setEnabled(true);
            } else {
                sec--;
                if (sec == -1) {
                    sec = 59;
                    min--;
                    if (min == -1) {
                        min = 59;
                        hour--;
                        if (hour == -1) {
                            hour = 0;
                        }
                    }
                }
            }
            if (sec < 10) {
                giay = "0" + String.valueOf(sec);
            } else {
                giay = String.valueOf(sec);
            }
            if (min < 10) {
                phut = "0" + String.valueOf(min);
            } else {
                phut = String.valueOf(min);
            }
            if (hour < 10) {
                gio = "0" + String.valueOf(hour);
            } else {
                gio = String.valueOf(hour);
            }
            lbTime.setText(gio + " : " + phut + " : " + giay);
        }
    });

    public DongHoDemNguoc() {
        setTitle("Đồng hồ đếm ngược - Code by Lâm Ngọc Khương");
        setPreferredSize(new Dimension(480, 150));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());

        JPanel pn1 = new JPanel();
        pn1.setLayout(new FlowLayout());

        lbTime = new JLabel();
        lbTime.setText("00 : 00 : 00");
        lbTime.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbTime.setForeground(Color.red);
        pn1.add(lbTime);

        pnMain.add(pn1, BorderLayout.NORTH);

        JPanel pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());

        tfTime = new JTextField();
        tfTime.setColumns(10);

        pn2.add(tfTime);

        btStart = new JButton();
        btStart.setText("Start");
        pn2.add(btStart);

        pnMain.add(pn2, BorderLayout.SOUTH);

        getContentPane().add(pnMain, BorderLayout.CENTER);

        pack();

        // ActionListener
        btStart.addActionListener(this);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DongHoDemNguoc().setVisible(true);
            }
        });
    }

    public boolean preparedTimer(String timenow) {
        boolean check = true;
        try {
            String[] arrtime = timenow.split(":");
            if (arrtime.length == 3) {
                hour = Integer.parseInt(arrtime[0]);
                min = Integer.parseInt(arrtime[1]);
                sec = Integer.parseInt(arrtime[2]);
                if (hour > 23 || min > 59 || sec > 59) {
                    check = false;
                    throw new Exception("Định dạng giờ không đúng!");
                }
            } else {
                check = false;
            }
        } catch (Exception e) {
            check = false;
        }
        return check;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btStart) {
            if (!preparedTimer(tfTime.getText())) {
                JOptionPane.showMessageDialog(null, "Định dạng ngày giờ nhập vào không đúng! (hh:mm:ss)");
                return;
            }
            sec++;
            time.start();
            btStart.setEnabled(false);
        }
    }
}
