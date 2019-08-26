package de.milchreis.uibooster;

import de.milchreis.uibooster.components.*;
import de.milchreis.uibooster.model.LoginCredentials;
import de.milchreis.uibooster.model.UiBoosterOptions;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.util.List;

import static de.milchreis.uibooster.utils.ParameterValidator.nonNull;

public class UiBooster {

    public UiBooster() {
    }

    public UiBooster(UiBoosterOptions options) {
        if(options == null)
            return;

        if(options.isUseNativeLookAndFeel()) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
        }

    }

    /**
     * Shows an info dialog and blocks until the ok button was clicked.
     * '\n' is allowed as newline character for the info message.
     *
     * @param infoMessage  expects the info message
     */
    public void showInfoDialog(String infoMessage) {
        nonNull(infoMessage);
        JOptionPane.showMessageDialog(null, infoMessage);
    }

    /**
     * Shows a warning dialog and blocks until the ok button was clicked.
     * '\n' is allowed as newline character for the warn message.
     *
     * @param warningMessage  expects the warn message
     * @param title           expects the title for the window
     */
    public void showWarningDialog(String warningMessage, String title) {
        nonNull(warningMessage);
        nonNull(title);
        JOptionPane.showMessageDialog(null, warningMessage, title, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Shows an error dialog and blocks until the ok button was clicked.
     * '\n' is allowed as newline character for the error message.
     *
     * @param errorMessage    expects the error message
     * @param title           expects the title for the window
     */
    public void showErrorDialog(String errorMessage, String title) {
        nonNull(errorMessage);
        nonNull(title);
        JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Shows a dialog with text input field.
     *
     * @param message      expects a message or question for the user.
     * @return             the user input or null on cancel
     */
    public String showTextInputDialog(String message) {
        nonNull(message);
        return JOptionPane.showInputDialog(null, message);
    }

    /**
     * Shows a confirm dialog and blocks until a decision is selected.
     * '\n' is allowed as newline character for the message.
     *
     * @param message   expects the message
     * @param title     expects the window title
     * @param onConfirm expects a behaviour for a conformation
     * @param onDecline expects a behaviour for a declination
     */
    public void showConfirmDialog(String message, String title, Runnable onConfirm, Runnable onDecline) {
        nonNull(message);
        nonNull(title);
        int n = JOptionPane.showConfirmDialog(null,
                message,
                title,
                JOptionPane.YES_NO_OPTION);

        if(n == 0 && onConfirm != null)
            onConfirm.run();

        if(n == 1 && onDecline != null)
            onDecline.run();
    }

    /**
     * Shows an info dialog and blocks until the ok button was clicked.
     * '\n' is allowed as newline character for the info message.
     *
     * @param message       expects the message
     * @param title         expects the window title
     * @param possibilities expects a list with possibilities
     * @return              the selection element form possibilities list or null on close
     */
    public String showSelectionDialog(String message, String title, List<String> possibilities) {
        nonNull(message);
        nonNull(title);

        String selection = (String) JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities.toArray(),
                possibilities.get(0));

        return selection;
    }

    /**
     * Shows a simple color picker to select an RGB value.
     * @param message   optional message above the color picker
     * @param title     expects a window title
     * @return          the selected color, on close it returns null.
     */
    public Color showColorPicker(String message, String title) {
        return ColorPickerDialog.showColorPicker(message, title);
    }

    /**
     * Shows a file selection dialog. Only files are shown and selectable
     * @return returns the selection file or null on cancel
     */
    public File showFileSelection() {
        return FilesystemDialog.showFileSelectionDialog();
    }

    /**
     * Shows a directory selection dialog. Only directories are shown and selectable
     * @return returns the selection directory or null on cancel
     */
    public File showDirectorySelection() {
        return FilesystemDialog.showDirectorySelectionDialog();
    }

    /**
     * Shows a selection dialog for files and directories.
     * @return returns the selection or null on cancel
     */
    public File showFileOrDirectorySelection() {
        return FilesystemDialog.showFileOrDirectorySelectionDialog();
    }

    /**
     * Shows a login dialog with username and password.
     * @return returns the login data or null on cancel.
     */
    public LoginCredentials showLogin(String message, String title, String usernameLabel, String passwordLabel, String loginButtonLabel, String cancelButtonLabel) {
        return new LoginDialog(
                title,
                message,
                usernameLabel,
                passwordLabel,
                loginButtonLabel,
                cancelButtonLabel).showDialog();
    }

    /**
     * Shows a waiting dialog with a changeable message.
     * This dialog does not wait for any user input. Its decoupled from the rest of the application.
     * @return returns the dialog object to change the message and hide the dialog if needed.
     */
    public WaitingDialog showWaitingDialog(String message, String title) {
        return WaitingDialog.showWaitingDialog(message, title);
    }

    public Form createForm(String title) {
        return new Form(title);
    }
}
