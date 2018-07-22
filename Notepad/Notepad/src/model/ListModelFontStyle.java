package model;

import bean.FontStyle;
import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author ngockhuong
 */
public class ListModelFontStyle implements ListModel {
    private ArrayList<FontStyle> styles = new ArrayList<>();
    public ListModelFontStyle() {
        FontStyle s0 = new FontStyle(0, "Regular");
        FontStyle s1 = new FontStyle(1, "Bold");
        FontStyle s2 = new FontStyle(2, "Italic");
        FontStyle s3 = new FontStyle(3, "Bold Italic");
        
        styles.add(s0);
        styles.add(s1);
        styles.add(s2);
        styles.add(s3);
    }

    
    @Override
    public int getSize() {
        return styles.size();
    }

    @Override
    public Object getElementAt(int index) {
        return styles.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
