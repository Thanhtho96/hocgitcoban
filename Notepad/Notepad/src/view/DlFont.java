package view;

import bean.FontStyle;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Position;
import model.ListModelFontStyle;

/**
 *
 * @author ngockhuong
 */
public class DlFont extends javax.swing.JDialog implements ActionListener, ListSelectionListener {

    private String fontSelected = "";
    private int fontStyleSelected = 0;
    private int sizeSelected = 12;

    public DlFont(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        addListFont();
        addFontStyle();
        addListSize();
        setPreview();

        lFont.addListSelectionListener(this);
        lFontStyle.addListSelectionListener(this);
        lSize.addListSelectionListener(this);

        tfFont.addActionListener(this);
        tfFont.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int index = lFont.getNextMatch(tfFont.getText(), 0, Position.Bias.Forward);
                index = (index > 0) ? index : 0;
                lFont.ensureIndexIsVisible(index);
            }
        });
        tfFont.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfFont.selectAll();
            }
        });
        tfFontStyle.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int index = lFontStyle.getNextMatch(tfFontStyle.getText(), 0, Position.Bias.Forward);
                index = (index > 0) ? index : 0;
                lFontStyle.ensureIndexIsVisible(index);
            }
        });
        tfFontStyle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfFontStyle.selectAll();
            }
        });
        tfSize.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int index = lSize.getNextMatch(tfSize.getText(), 0, Position.Bias.Forward);
                index = (index > 0) ? index : 0;
                lSize.ensureIndexIsVisible(index);
            }
        });
        tfSize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tfSize.selectAll();
            }
        });
        
        btOK.addActionListener(this);
        btCancel.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbFont = new javax.swing.JLabel();
        lbFontStyle = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        tfFont = new javax.swing.JTextField();
        tfFontStyle = new javax.swing.JTextField();
        tfSize = new javax.swing.JTextField();
        spListFont = new javax.swing.JScrollPane();
        lFont = new javax.swing.JList();
        spListFontStyle = new javax.swing.JScrollPane();
        lFontStyle = new javax.swing.JList();
        spListSize = new javax.swing.JScrollPane();
        lSize = new javax.swing.JList();
        pnSample = new javax.swing.JPanel();
        lbSample = new javax.swing.JLabel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Font");
        setResizable(false);

        lbFont.setText("Font:");

        lbFontStyle.setText("Font style:");

        lbSize.setText("Size:");

        spListFont.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spListFont.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lFont.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spListFont.setViewportView(lFont);

        spListFontStyle.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spListFontStyle.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lFontStyle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spListFontStyle.setViewportView(lFontStyle);

        spListSize.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spListSize.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lSize.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        spListSize.setViewportView(lSize);

        pnSample.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Sample"));
        pnSample.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnSample.setMaximumSize(null);
        pnSample.setMinimumSize(null);
        pnSample.setRequestFocusEnabled(false);
        pnSample.setVerifyInputWhenFocusTarget(false);

        lbSample.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSample.setText("AaBbYyZz");

        javax.swing.GroupLayout pnSampleLayout = new javax.swing.GroupLayout(pnSample);
        pnSample.setLayout(pnSampleLayout);
        pnSampleLayout.setHorizontalGroup(
            pnSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSampleLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbSample, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        pnSampleLayout.setVerticalGroup(
            pnSampleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbSample, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btOK.setText("OK");

        btCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbFont)
                            .addComponent(spListFont, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tfFont, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbFontStyle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(spListFontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tfFontStyle))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbSize)
                            .addComponent(tfSize, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(spListSize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnSample, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFont)
                    .addComponent(lbFontStyle)
                    .addComponent(lbSize))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFontStyle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spListFontStyle, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addComponent(spListSize, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(spListFont, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(pnSample, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JList lFont;
    private javax.swing.JList lFontStyle;
    private javax.swing.JList lSize;
    private javax.swing.JLabel lbFont;
    private javax.swing.JLabel lbFontStyle;
    private javax.swing.JLabel lbSample;
    private javax.swing.JLabel lbSize;
    private javax.swing.JPanel pnSample;
    private javax.swing.JScrollPane spListFont;
    private javax.swing.JScrollPane spListFontStyle;
    private javax.swing.JScrollPane spListSize;
    private javax.swing.JTextField tfFont;
    private javax.swing.JTextField tfFontStyle;
    private javax.swing.JTextField tfSize;
    // End of variables declaration//GEN-END:variables
    private void setPreview() {
        Font f = ((FrNotepad) getParent()).getTaText().getFont();
        fontSelected = f.getFontName();
        fontStyleSelected = f.getStyle();
        sizeSelected = f.getSize();

        tfFont.setText(fontSelected);
        lFont.setSelectedValue(fontSelected, true);
        tfFont.selectAll();

        ListModelFontStyle listStyle = new ListModelFontStyle();
        tfFontStyle.setText(((FontStyle) listStyle.getElementAt(fontStyleSelected)).getStyleName());
        lFontStyle.setSelectedIndex(fontStyleSelected);

        tfSize.setText(String.valueOf(sizeSelected));
        lSize.setSelectedValue(sizeSelected, true);

        invalidateSample();

    }

    private void addListFont() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = g.getAvailableFontFamilyNames();
        DefaultListModel listFont = new DefaultListModel();

        for (String font : fonts) {
            listFont.addElement(font);
        }
        lFont.setModel(listFont);
    }

    private void addFontStyle() {
        ListModelFontStyle listStyle = new ListModelFontStyle();
        lFontStyle.setModel(listStyle);
    }

    private void addListSize() {
        DefaultListModel sizeModel = new DefaultListModel();
        for (int i = 8; i <= 72; i++) {
            if (i > 12) {
                i++;
                if (i > 28) {
                    i += 6;
                    if (i > 36) {
                        i += 4;
                        if (i > 48) {
                            i += 12;
                        }
                    }
                }
            }
            sizeModel.addElement(i);
        }
        lSize.setModel(sizeModel);
    }

    private void invalidateSample() {
        lbSample.setFont(new Font(fontSelected, fontStyleSelected, sizeSelected));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btOK) {
            ((FrNotepad)getParent()).setFont(fontSelected, fontStyleSelected, sizeSelected);
            ((FrNotepad)getParent()).getTaText().setFont(new Font(fontSelected, fontStyleSelected, sizeSelected));
            ((FrNotepad)getParent()).invalidate();
            dispose();
        } else if (e.getSource() == btCancel) {
            dispose();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == lFont) {
            fontSelected = (String) lFont.getSelectedValue();
            tfFont.setText(fontSelected);
            invalidateSample();
        } else if (e.getSource() == lFontStyle) {
            fontStyleSelected = ((FontStyle) lFontStyle.getSelectedValue()).getStyle();
            tfFontStyle.setText(((FontStyle) lFontStyle.getSelectedValue()).getStyleName());
            invalidateSample();
        } else if (e.getSource() == lSize) {
            sizeSelected = (int) lSize.getSelectedValue();
            tfSize.setText(String.valueOf(sizeSelected));
            invalidateSample();
        }
    }
}
