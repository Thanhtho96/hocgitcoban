package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

/**
 *
 * @author ngockhuong
 */
public class DlAbout extends javax.swing.JDialog {
    public DlAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/font/Filxgirl.TTF").openStream());
        } catch (IOException | FontFormatException ex) {
            ex.getMessage();
        }
        
        setLocationRelativeTo(parent);
        lbTitle.setFont(font.deriveFont(Font.BOLD, 50));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        sprtTop = new javax.swing.JSeparator();
        pnLeft = new javax.swing.JPanel();
        lbIcon = new javax.swing.JLabel();
        pnBottom = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About JNotepad");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("aboutNotepad"); // NOI18N
        setResizable(false);

        pnTop.setLayout(new java.awt.GridBagLayout());

        lbTitle.setBackground(new java.awt.Color(255, 255, 255));
        lbTitle.setFont(new java.awt.Font("Fiolex Girls", 1, 50)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 102, 255));
        lbTitle.setText(" JNotepad");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        pnTop.add(lbTitle, gridBagConstraints);

        sprtTop.setPreferredSize(new java.awt.Dimension(400, 10));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnTop.add(sprtTop, gridBagConstraints);

        getContentPane().add(pnTop, java.awt.BorderLayout.NORTH);

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon.png"))); // NOI18N

        javax.swing.GroupLayout pnLeftLayout = new javax.swing.GroupLayout(pnLeft);
        pnLeft.setLayout(pnLeftLayout);
        pnLeftLayout.setHorizontalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbIcon)
                .addContainerGap())
        );
        pnLeftLayout.setVerticalGroup(
            pnLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        getContentPane().add(pnLeft, java.awt.BorderLayout.WEST);

        btOK.setText("OK");
        btOK.setFocusable(false);
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomLayout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btOK)
                .addContainerGap())
        );

        getContentPane().add(pnBottom, java.awt.BorderLayout.SOUTH);

        lb1.setText("<html><b>JNotepad</b> is a text editor program<br><br>Version: 1.0<br>Create by Lam Ngoc Khuong<br><br><br>Contact Information:<br>- Website: <a href='http://ngockhuong.com' target='_blank'><span style='color: blue'>http://ngockhuong.com</span></a><br>- Email: lamngockhuong@gmail.com</html>");

        javax.swing.GroupLayout pnCenterLayout = new javax.swing.GroupLayout(pnCenter);
        pnCenter.setLayout(pnCenterLayout);
        pnCenterLayout.setHorizontalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        pnCenterLayout.setVerticalGroup(
            pnCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        getContentPane().add(pnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        dispose();
    }//GEN-LAST:event_btOKActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOK;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnLeft;
    private javax.swing.JPanel pnTop;
    private javax.swing.JSeparator sprtTop;
    // End of variables declaration//GEN-END:variables
}
