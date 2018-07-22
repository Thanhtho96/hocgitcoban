package view;

import action.FileAction;
import action.PrintSupport;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

/**
 *
 * @author ngockhuong
 */
public class FrNotepad extends javax.swing.JFrame implements ActionListener, MouseListener, WindowListener, KeyListener {

    private FileAction fileAction = new FileAction();
    private Preferences prefsRoot = null;
    private Preferences userPrefs = null;
    String[] key = null;

    private PrinterJob pj;
    private String fileTitle = "";
    private String textTmp = "";
    private String textSelectd = "";
    private String textOriginal = "";
    private String filePath = "";
    private String lastDir = "";
    
    private String fontName = "";
    private int fontStyle;
    private int fontSize;
    
    private int beginSelected;
    private int endSelected;
    private boolean isNewFile = true;
    private boolean isTextChanged = false;
    private boolean statusBar = true;
    private boolean wordWrap = false;

    private JFileChooser fc;

    public FrNotepad() {
        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        setLocationRelativeTo(null);
        // Setting Font Default
        fontName = "Consolas";
        fontStyle = Font.PLAIN;
        fontSize = 14;
        
        // Store Preferences
        prefsRoot = Preferences.userRoot();
        userPrefs = prefsRoot.node("ngockhuong/notepad");
        try {
            key = userPrefs.keys();
        } catch (BackingStoreException ex) {
            System.out.println(ex);
        }
        if (key == null || key.length == 0) {
            lastDir = (System.getProperty("user.home"));
            userPrefs.put("LastDir", lastDir);
            userPrefs.putBoolean("StatusBar", statusBar);
            userPrefs.putBoolean("WordWrap", wordWrap);
            userPrefs.put("fontName", fontName);
            userPrefs.putInt("fontStyle", fontStyle);
            userPrefs.putInt("fontSize", fontSize);
        } else {
            lastDir = userPrefs.get("LastDir", "");
            statusBar = userPrefs.getBoolean("StatusBar", true);
            wordWrap = userPrefs.getBoolean("WordWrap", false);
            fontName = userPrefs.get("fontName", "Consolas");
            fontStyle = userPrefs.getInt("fontStyle", Font.PLAIN);
            fontSize = userPrefs.getInt("fontSize", 14);
        }
        // Set Font
        taText.setFont(new Font(fontName, fontStyle, fontSize));
        
        pnStatusBar.setVisible(statusBar);
        if (wordWrap == true) {
            cbmniWordWrap.setSelected(wordWrap);
            pnStatusBar.setVisible(false);
            spText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            cbmniStatusBar.setSelected(false);
            cbmniStatusBar.setEnabled(false);
        } else {
            cbmniWordWrap.setSelected(wordWrap);
            spText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            pnStatusBar.setVisible(statusBar);
            cbmniStatusBar.setSelected(statusBar);
            cbmniStatusBar.setEnabled(true);
        }

        fc = new JFileChooser() {

            @Override
            public void approveSelection() {
                File f = getSelectedFile();
                if (f.exists() && getDialogType() == SAVE_DIALOG) {
                    int result = JOptionPane.showConfirmDialog(this, "<html>" + f.getName() + " already exists.<br>Do you want to replace it?</html>", "Confirm Save", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                    }
                }
                super.approveSelection();
            }
        };
        fc.setCurrentDirectory(new File(lastDir));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setFileFilter(new FileNameExtensionFilter("Text Documents (*.txt)", "txt"));
        fc.setAcceptAllFileFilterUsed(true);

        taText.setTabSize(4);
        taText.setWrapStyleWord(wordWrap);
        taText.setLineWrap(wordWrap);
        taText.addKeyListener(this);
        taText.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                int dot = e.getDot();
                int mark = e.getMark();
                if (dot != mark) {
                    mniCut.setEnabled(true);
                    mniCopy.setEnabled(true);
                    mniDelete.setEnabled(true);

                    textSelectd = taText.getSelectedText();
                    textTmp = taText.getText();
                    if (endSelected == 0 && beginSelected == 0 && !textSelectd.isEmpty()) {
                        beginSelected = taText.getSelectionStart();
                        endSelected = taText.getSelectionEnd();
                    }
                } else {
                    mniCut.setEnabled(false);
                    mniCopy.setEnabled(false);
                    mniDelete.setEnabled(false);
                }
                if (statusBar) {
                    updateLineColumnStatus(mark);
                }
            }
        });
        // ActionListener
        mniNew.addActionListener(this);
        mniOpen.addActionListener(this);
        mniSave.addActionListener(this);
        mniSaveAs.addActionListener(this);
        mniPageSetup.addActionListener(this);
        mniPrint.addActionListener(this);
        mniExit.addActionListener(this);

        mniUndo.addActionListener(this);
        mniCut.addActionListener(this);
        mniCopy.addActionListener(this);
        mniPaste.addActionListener(this);
        mniDelete.addActionListener(this);
        mniFind.addActionListener(this);
        mniFintNext.addActionListener(this);
        mniReplace.addActionListener(this);
        mniGoTo.addActionListener(this);
        mniSelectAll.addActionListener(this);
        mniTimeDate.addActionListener(this);

        cbmniWordWrap.addActionListener(this);
        mniFont.addActionListener(this);

        cbmniStatusBar.addActionListener(this);

        mniViewHelp.addActionListener(this);
        mniAboutNotepad.addActionListener(this);
        // MouseListener

        // WindowListener
        addWindowListener(this);
        // DocumentListener
        textEvent();
    }

    public JTextArea getTaText() {
        return taText;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnText = new javax.swing.JPanel();
        spText = new javax.swing.JScrollPane();
        taText = new javax.swing.JTextArea();
        pnStatusBar = new javax.swing.JPanel();
        pnLeftStatus = new javax.swing.JPanel();
        pnRightStatus = new javax.swing.JPanel();
        sprtStatusBar = new javax.swing.JSeparator();
        lbStatus = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mniNew = new javax.swing.JMenuItem();
        mniOpen = new javax.swing.JMenuItem();
        mniSave = new javax.swing.JMenuItem();
        mniSaveAs = new javax.swing.JMenuItem();
        sprtMenuFile1 = new javax.swing.JPopupMenu.Separator();
        mniPageSetup = new javax.swing.JMenuItem();
        mniPrint = new javax.swing.JMenuItem();
        sprtMenuFile2 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mniUndo = new javax.swing.JMenuItem();
        sprtMenuEdit1 = new javax.swing.JPopupMenu.Separator();
        mniCut = new javax.swing.JMenuItem();
        mniCopy = new javax.swing.JMenuItem();
        mniPaste = new javax.swing.JMenuItem();
        mniDelete = new javax.swing.JMenuItem();
        sprtMenuEdit2 = new javax.swing.JPopupMenu.Separator();
        mniFind = new javax.swing.JMenuItem();
        mniFintNext = new javax.swing.JMenuItem();
        mniReplace = new javax.swing.JMenuItem();
        mniGoTo = new javax.swing.JMenuItem();
        sprtMenuFile6 = new javax.swing.JPopupMenu.Separator();
        mniSelectAll = new javax.swing.JMenuItem();
        mniTimeDate = new javax.swing.JMenuItem();
        mnFormat = new javax.swing.JMenu();
        cbmniWordWrap = new javax.swing.JCheckBoxMenuItem();
        mniFont = new javax.swing.JMenuItem();
        mnView = new javax.swing.JMenu();
        cbmniStatusBar = new javax.swing.JCheckBoxMenuItem();
        mnHelp = new javax.swing.JMenu();
        mniViewHelp = new javax.swing.JMenuItem();
        sprtMenuHelp = new javax.swing.JPopupMenu.Separator();
        mniAboutNotepad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Untitled");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(950, 500));

        pnText.setBackground(new java.awt.Color(255, 255, 255));
        pnText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        spText.setBackground(new java.awt.Color(255, 255, 255));
        spText.setBorder(null);
        spText.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spText.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        taText.setColumns(20);
        taText.setRows(5);
        taText.setTabSize(4);
        taText.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        spText.setViewportView(taText);

        javax.swing.GroupLayout pnTextLayout = new javax.swing.GroupLayout(pnText);
        pnText.setLayout(pnTextLayout);
        pnTextLayout.setHorizontalGroup(
            pnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
        pnTextLayout.setVerticalGroup(
            pnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spText, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        getContentPane().add(pnText, java.awt.BorderLayout.CENTER);

        pnStatusBar.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnLeftStatusLayout = new javax.swing.GroupLayout(pnLeftStatus);
        pnLeftStatus.setLayout(pnLeftStatusLayout);
        pnLeftStatusLayout.setHorizontalGroup(
            pnLeftStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 536, Short.MAX_VALUE)
        );
        pnLeftStatusLayout.setVerticalGroup(
            pnLeftStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnStatusBar.add(pnLeftStatus, java.awt.BorderLayout.CENTER);

        sprtStatusBar.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lbStatus.setText("Ln 1, Col 1");

        javax.swing.GroupLayout pnRightStatusLayout = new javax.swing.GroupLayout(pnRightStatus);
        pnRightStatus.setLayout(pnRightStatusLayout);
        pnRightStatusLayout.setHorizontalGroup(
            pnRightStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRightStatusLayout.createSequentialGroup()
                .addComponent(sprtStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbStatus)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        pnRightStatusLayout.setVerticalGroup(
            pnRightStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprtStatusBar)
            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnStatusBar.add(pnRightStatus, java.awt.BorderLayout.EAST);

        getContentPane().add(pnStatusBar, java.awt.BorderLayout.SOUTH);

        menuBar.setBorderPainted(false);

        mnFile.setText("File");
        mnFile.setMargin(new java.awt.Insets(0, 5, 0, 5));

        mniNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNew.setText("New");
        mnFile.add(mniNew);

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setText("Open...");
        mnFile.add(mniOpen);

        mniSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSave.setText("Save");
        mnFile.add(mniSave);

        mniSaveAs.setText("Save As...");
        mnFile.add(mniSaveAs);
        mnFile.add(sprtMenuFile1);

        mniPageSetup.setText("Page Setup...");
        mnFile.add(mniPageSetup);

        mniPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mniPrint.setText("Print...");
        mnFile.add(mniPrint);
        mnFile.add(sprtMenuFile2);

        mniExit.setText("Exit");
        mnFile.add(mniExit);

        menuBar.add(mnFile);

        mnEdit.setText("Edit");
        mnEdit.setMargin(new java.awt.Insets(0, 5, 0, 5));

        mniUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mniUndo.setText("Undo");
        mnEdit.add(mniUndo);
        mnEdit.add(sprtMenuEdit1);

        mniCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mniCut.setText("Cut");
        mnEdit.add(mniCut);

        mniCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mniCopy.setText("Copy");
        mnEdit.add(mniCopy);

        mniPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mniPaste.setText("Paste");
        mnEdit.add(mniPaste);

        mniDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        mniDelete.setText("Delete");
        mnEdit.add(mniDelete);
        mnEdit.add(sprtMenuEdit2);

        mniFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mniFind.setText("Find...");
        mnEdit.add(mniFind);

        mniFintNext.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mniFintNext.setText("Find Next");
        mnEdit.add(mniFintNext);

        mniReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mniReplace.setText("Replace...");
        mnEdit.add(mniReplace);

        mniGoTo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        mniGoTo.setText("Go To...");
        mnEdit.add(mniGoTo);
        mnEdit.add(sprtMenuFile6);

        mniSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mniSelectAll.setText("Select All");
        mnEdit.add(mniSelectAll);

        mniTimeDate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mniTimeDate.setText("Time/Date");
        mnEdit.add(mniTimeDate);

        menuBar.add(mnEdit);

        mnFormat.setText("Format");
        mnFormat.setMargin(new java.awt.Insets(0, 5, 0, 5));

        cbmniWordWrap.setText("Word Wrap");
        mnFormat.add(cbmniWordWrap);

        mniFont.setText("Font...");
        mnFormat.add(mniFont);

        menuBar.add(mnFormat);

        mnView.setText("View");
        mnView.setMargin(new java.awt.Insets(0, 5, 0, 5));

        cbmniStatusBar.setText("Status Bar");
        mnView.add(cbmniStatusBar);

        menuBar.add(mnView);

        mnHelp.setText("Help");
        mnHelp.setMargin(new java.awt.Insets(0, 5, 0, 5));

        mniViewHelp.setText("View Help");
        mnHelp.add(mniViewHelp);
        mnHelp.add(sprtMenuHelp);

        mniAboutNotepad.setText("About JNotepad");
        mnHelp.add(mniAboutNotepad);

        menuBar.add(mnHelp);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrNotepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem cbmniStatusBar;
    private javax.swing.JCheckBoxMenuItem cbmniWordWrap;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnFormat;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenu mnView;
    private javax.swing.JMenuItem mniAboutNotepad;
    private javax.swing.JMenuItem mniCopy;
    private javax.swing.JMenuItem mniCut;
    private javax.swing.JMenuItem mniDelete;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniFind;
    private javax.swing.JMenuItem mniFintNext;
    private javax.swing.JMenuItem mniFont;
    private javax.swing.JMenuItem mniGoTo;
    private javax.swing.JMenuItem mniNew;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniPageSetup;
    private javax.swing.JMenuItem mniPaste;
    private javax.swing.JMenuItem mniPrint;
    private javax.swing.JMenuItem mniReplace;
    private javax.swing.JMenuItem mniSave;
    private javax.swing.JMenuItem mniSaveAs;
    private javax.swing.JMenuItem mniSelectAll;
    private javax.swing.JMenuItem mniTimeDate;
    private javax.swing.JMenuItem mniUndo;
    private javax.swing.JMenuItem mniViewHelp;
    private javax.swing.JPanel pnLeftStatus;
    private javax.swing.JPanel pnRightStatus;
    private javax.swing.JPanel pnStatusBar;
    private javax.swing.JPanel pnText;
    private javax.swing.JScrollPane spText;
    private javax.swing.JPopupMenu.Separator sprtMenuEdit1;
    private javax.swing.JPopupMenu.Separator sprtMenuEdit2;
    private javax.swing.JPopupMenu.Separator sprtMenuFile1;
    private javax.swing.JPopupMenu.Separator sprtMenuFile2;
    private javax.swing.JPopupMenu.Separator sprtMenuFile6;
    private javax.swing.JPopupMenu.Separator sprtMenuHelp;
    private javax.swing.JSeparator sprtStatusBar;
    private javax.swing.JTextArea taText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTitle(String title) {
        super.setTitle(title + " - JNotepad");
    }

    public void setFont(String fontName, int fontStyle, int fontSize) {
        this.fontName = fontName;
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
    }
    
    private void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    private void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException ex) {
            System.out.println(ex);
        }
    }

    private void updateLineColumnStatus(int index) {
        //int index = 0;
        int indexLineNow = 0;
        int indexColumnNow = 0;
        int indexStartOfLine = 0;
        try {
            //index = taText.getCaretPosition();
            indexLineNow = taText.getLineOfOffset(index);
            indexStartOfLine = taText.getLineStartOffset(indexLineNow);
            indexColumnNow = index - indexStartOfLine + 1;
        } catch (BadLocationException ex) {
        }
        String column = String.valueOf(indexColumnNow);
        String line = String.valueOf(indexLineNow + 1);
        lbStatus.setText("Ln " + line + ", Col " + column);
    }

    private boolean verifyToSave() {
        int result = 0;
        String fileTmp = "Untitled";
        String[] options = {"Save", "Don't Save", "Cancel"};
        if (!isNewFile) {
            fileTmp = "<br>" + filePath;
        }
        result = JOptionPane.showOptionDialog(this, "<html>Do you want to save changes to " + fileTmp + "?</html>", "JNotepad", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.YES_OPTION) {
            if (isNewFile) {
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    filePath = fc.getSelectedFile().getAbsolutePath();
                    // Set current Directory
                    lastDir = fc.getSelectedFile().getParent();
                    fc.setCurrentDirectory(fc.getSelectedFile().getParentFile());

                    fileAction.writeFile(filePath, taText.getText());
                    setTitle(fc.getSelectedFile().getName());
                    // Sau khi lưu tệp, Text sẽ quay về tình trạng chưa thay đổi
                    isTextChanged = false;
                    isNewFile = false;
                }
                return false;
            } else {
                fileAction.writeFile(filePath, taText.getText());
                // Sau khi lưu tệp, Text sẽ quay về tình trạng chưa thay đổi
                isTextChanged = false;
                isNewFile = false;
            }
        } else if (result == JOptionPane.CANCEL_OPTION) {
            return false;
        }
        return true;
    }

    public void textEvent() {
        taText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isTextChanged = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isTextChanged = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isTextChanged = true;
            }
        });
    }

    public void savePrefs() {
        if (key != null || key.length != 0) {
            userPrefs.put("LastDir", fc.getCurrentDirectory().getPath());
            userPrefs.putBoolean("StatusBar", statusBar);
            userPrefs.putBoolean("WordWrap", wordWrap);
            userPrefs.put("fontName", fontName);
            userPrefs.putInt("fontStyle", fontStyle);
            userPrefs.putInt("fontSize", fontSize);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mniNew) {
            if ((isTextChanged && !taText.getText().equals(textOriginal) && !taText.getText().isEmpty()) || (isTextChanged && !filePath.isEmpty())) {
                if (!verifyToSave()) {
                    return;
                }
            }
            taText.setText("");
            isNewFile = true;
            isTextChanged = false;
            filePath = "";
            textOriginal = "";
            fileTitle = "Untitled";
            setTitle(fileTitle);
        } else if (e.getSource() == mniOpen) {
            if (isTextChanged) {
                if (!verifyToSave()) {
                    return;
                }
            }
            int choose = fc.showDialog(this, "Open");
            if (choose == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filePath = file.getAbsolutePath();
                // Set current Directory
                lastDir = file.getParent();
                fc.setCurrentDirectory(file.getParentFile());
                if (file.exists()) {
                    // Update Frame Name
                    fileTitle = file.getName();
                    setTitle(fileTitle);
                    // Read and Update Text
                    textOriginal = fileAction.readFile(file);
                    textTmp = textOriginal;
                    taText.setText(textOriginal);
                    // 
                    isNewFile = false;
                    isTextChanged = false;
                } else {
                    JOptionPane.showMessageDialog(this, "Can't open file", "JNotepad", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getSource() == mniSave) {
            if (isNewFile) {
                if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    filePath = fc.getSelectedFile().getAbsolutePath();
                    // Set current Directory
                    lastDir = fc.getSelectedFile().getParent();
                    fc.setCurrentDirectory(fc.getSelectedFile().getParentFile());

                    fileAction.writeFile(filePath, taText.getText());
                    setTitle(fc.getSelectedFile().getName());
                    // Sau khi lưu tệp, Text sẽ quay về tình trạng chưa thay đổi
                    isTextChanged = false;
                    isNewFile = false;
                }
            } else {
                fileAction.writeFile(filePath, taText.getText());
                // Sau khi lưu tệp, Text sẽ quay về tình trạng chưa thay đổi
                isTextChanged = false;
                isNewFile = false;
            }
        } else if (e.getSource() == mniSaveAs) {
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                filePath = fc.getSelectedFile().getAbsolutePath();
                // Set current Directory
                lastDir = fc.getSelectedFile().getParent();
                fc.setCurrentDirectory(fc.getSelectedFile().getParentFile());

                fileAction.writeFile(filePath, taText.getText());
                setTitle(fc.getSelectedFile().getName());
                // Sau khi lưu tệp, Text sẽ quay về tình trạng chưa thay đổi
                isTextChanged = false;
                isNewFile = false;
            }
        } else if (e.getSource() == mniPageSetup) {
            if (pj == null) {
                pj = PrinterJob.getPrinterJob();
            }
            PageFormat pf = pj.pageDialog(pj.defaultPage());
            pf.setOrientation(PageFormat.PORTRAIT);
        } else if (e.getSource() == mniPrint) {
            if (pj == null) {
                pj = PrinterJob.getPrinterJob();
            }
            PrintSupport.printComponent(taText, pj);
        } else if (e.getSource() == mniExit) {
            savePrefs();
            if (isTextChanged && !taText.getText().equals(textOriginal) && !taText.getText().isEmpty()) {
                if (!verifyToSave()) {
                    return;
                }
            }
            System.exit(0);
        } else if (e.getSource() == mniUndo) {
            taText.setText(textTmp);
            taText.setSelectionStart(beginSelected);
            taText.setSelectionEnd(endSelected);
            textTmp = "";
            beginSelected = 0;
            endSelected = 0;
//            Highlighter h = taText.getHighlighter();
//            h.removeAllHighlights();
//            try {
//                taText.setSelectedTextColor(Color.white);
//                h.addHighlight(beginSelected, endSelected, new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
//            } catch (BadLocationException ex) {
//            }
        } else if (e.getSource() == mniCut) {
            textTmp = taText.getText();
            taText.cut();
        } else if (e.getSource() == mniCopy) {
            textTmp = taText.getText();
            taText.copy();
        } else if (e.getSource() == mniPaste) {
            taText.paste();
        } else if (e.getSource() == mniDelete) {
            beginSelected = taText.getSelectionStart();
            endSelected = taText.getSelectionEnd();
            textTmp = taText.getText();
            taText.replaceSelection("");
        } else if (e.getSource() == mniFind) {

        } else if (e.getSource() == mniFintNext) {

        } else if (e.getSource() == mniReplace) {

        } else if (e.getSource() == mniGoTo) {

        } else if (e.getSource() == mniSelectAll) {
            taText.selectAll();
        } else if (e.getSource() == mniTimeDate) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a dd/MM/yyyy");
            taText.setText(taText.getText() + sdf.format(new Date()));
        } else if (e.getSource() == cbmniWordWrap) {
            if (cbmniWordWrap.isSelected()) {
                wordWrap = true;
                spText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                pnStatusBar.setVisible(false);
                cbmniStatusBar.setSelected(false);
                cbmniStatusBar.setEnabled(false);
            } else {
                wordWrap = false;
                spText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                pnStatusBar.setVisible(statusBar);
                cbmniStatusBar.setSelected(statusBar);
                cbmniStatusBar.setEnabled(true);
            }
            taText.setWrapStyleWord(wordWrap);
            taText.setLineWrap(wordWrap);
        } else if (e.getSource() == mniFont) {
            DlFont font = new DlFont(this, true);
            font.setVisible(true);
        } else if (e.getSource() == cbmniStatusBar) {
            if (cbmniStatusBar.isSelected()) {
                statusBar = true;
                pnStatusBar.setVisible(true);
            } else {
                statusBar = false;
                pnStatusBar.setVisible(false);
            }
        } else if (e.getSource() == mniViewHelp) {
            try {
                openWebpage(new URL("http://ngockhuong.com"));
            } catch (MalformedURLException ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == mniAboutNotepad) {
            DlAbout about = new DlAbout(this, true);
            about.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        savePrefs();
        if (isTextChanged && !taText.getText().equals(textOriginal) && !taText.getText().isEmpty()) {
            if (!verifyToSave()) {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                return;
            }
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        pnText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 1, true));
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        pnText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            beginSelected = taText.getSelectionStart();
            endSelected = taText.getSelectionEnd();
            textTmp = taText.getText();
            taText.replaceSelection("");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
