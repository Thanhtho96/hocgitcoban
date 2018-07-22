package bean;

/**
 *
 * @author ngockhuong
 */
public class FontStyle {

    private int style;
    private String styleName;

    public FontStyle(int style, String styleName) {
        this.style = style;
        this.styleName = styleName;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    @Override
    public String toString() {
        return styleName;
    }

}
