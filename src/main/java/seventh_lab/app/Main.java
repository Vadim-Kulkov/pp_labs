package seventh_lab.app;

import seventh_lab.gui.GuiLoader;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//        JFrame jFrame = new JFrame() {
//        };
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension dimension = toolkit.getScreenSize();
//        jFrame.setBounds(dimension.width / 2 - 250,
//                dimension.height / 2 - 150, 500, 300);
//        jFrame.setTitle("Seventh lab");
//        jFrame.add(new JTextArea("Яфдг"));
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
