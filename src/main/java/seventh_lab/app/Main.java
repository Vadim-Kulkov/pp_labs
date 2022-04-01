package seventh_lab.app;

import seventh_lab.gui.GuiLoader;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        GuiLoader guiLoader = new GuiLoader();
        guiLoader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiLoader.setVisible(true);
    }
}
