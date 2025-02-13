package de.milchreis.uibooster.model;

import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 * Abstract base class for user defined look and feel of the application.
 */
public abstract class UiBoosterOptions {

    public enum Theme {
        DARK_THEME, LIGHT_THEME, SWING, OS_NATIVE, DEFAULT;
    }

    public static final String defaultIconPath = "/uibooster-default-icon.png";
    public static final String defaultLoadingImage = "/loading-75.gif";

    protected final BasicLookAndFeel lookAndFeel;
    protected final String iconPath;
    protected final String loadingImage;

    public UiBoosterOptions(BasicLookAndFeel lookAndFeel, String iconPath, String loadingImage) {
        this.lookAndFeel = lookAndFeel;
        this.iconPath = iconPath == null ? defaultIconPath : iconPath;
        this.loadingImage = loadingImage;
    }

    public BasicLookAndFeel getLookAndFeel() {
        return lookAndFeel;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getLoadingImage() {
        return loadingImage;
    }
}
