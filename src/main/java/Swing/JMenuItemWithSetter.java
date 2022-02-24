package Swing;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JMenuItemWithSetter extends JMenuItem {
    public void setActionListener(ActionListener actionListener){
        this.addActionListener(actionListener);
    }
}
