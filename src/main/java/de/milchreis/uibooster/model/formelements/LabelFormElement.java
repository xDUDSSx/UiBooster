package de.milchreis.uibooster.model.formelements;

import de.milchreis.uibooster.components.Form;
import de.milchreis.uibooster.model.FormElement;
import de.milchreis.uibooster.model.FormElementChangeListener;

import javax.swing.*;

public class LabelFormElement extends FormElement {

    private final JLabel label;

    public LabelFormElement(String label, int formIndex) {
        super(null, Form.InputType.LABEL, formIndex);
        this.label = new JLabel(label);
    }

    @Override
    public JComponent createComponent(FormElementChangeListener onChange) {
        return label;
    }

    @Override
    public String getValue() {
        return label.getText();
    }

    @Override
    public void setValue(Object value) {
        label.setText(value.toString());
    }

}
