package seventh_lab.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuiLoader extends JFrame {

    private JButton inputBounds = new JButton("Input Bounds");
    private JButton lessThan = new JButton("Less");
    private JButton equalsVithUserValue = new JButton("Equals");
    private JButton moreThan = new JButton("Greater");
    private JButton oneMoteTimeInCheat = new JButton("Start a new game");
    private JButton oneMoteTimeInVictory = new JButton("Start a new game");

    private JTextField firstBound = new JTextField("", 10);
    private JTextField secondBound = new JTextField("", 10);

    JTextArea generatedNum = new JTextArea();

    private JButton radioPick = new JButton("Pick style");
    private JRadioButton metalStyle = new JRadioButton("Metal");
    private JRadioButton nimbusStyle = new JRadioButton("Nimbus");
    private JRadioButton motifStyle = new JRadioButton("Motif");
    private JRadioButton gtkStyle = new JRadioButton("GTK");

    private int leftBound;
    private int rightBound;
    private int generatedValue;
    Random random = new Random();
    JFrame secondWindow;
    JFrame firstWindow;

    public GuiLoader() {

        super("Greater-less");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds(dimension.width / 2 - 250,
                dimension.height / 2 - 150, 500, 300);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 4, 1, 1));

        container.add(firstBound);
        container.add(secondBound);
        inputBounds.addActionListener(new InputBoundsEventListener());
        container.add(inputBounds);

        container.add(generatedNum);
        lessThan.addActionListener(new LessThenUserValue());
        container.add(lessThan);
        moreThan.addActionListener(new GreaterThenUserValue());
        container.add(moreThan);
        equalsVithUserValue.addActionListener(new EqualsWithUserValue());
        container.add(equalsVithUserValue);

        ButtonGroup groupRadios = new ButtonGroup();
        groupRadios.add(metalStyle);
        groupRadios.add(nimbusStyle);
        groupRadios.add(motifStyle);
        groupRadios.add(gtkStyle);
        container.add(metalStyle);
        container.add(nimbusStyle);
        container.add(motifStyle);
        container.add(gtkStyle);
        nimbusStyle.setSelected(true);
        radioPick.addActionListener(new RadioButtonEventListener());
        container.add(radioPick);
    }

    class RadioButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (metalStyle.isSelected()) {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    System.err.println(UIManager.getLookAndFeel());
                } else if (nimbusStyle.isSelected()) {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    System.err.println(UIManager.getLookAndFeel());
                } else if (motifStyle.isSelected()) {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    System.err.println(UIManager.getLookAndFeel());
                } else if (gtkStyle.isSelected()) {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    System.err.println(UIManager.getLookAndFeel());
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class InputBoundsEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int left = Integer.parseInt(firstBound.getText());
            int right = Integer.parseInt(secondBound.getText());
            if (left > right) {
                throw new IllegalArgumentException();
            }
            leftBound = left;
            rightBound = right;

            System.err.println("Initialized left bound: " + leftBound);
            System.err.println("Initialized right bound: " + rightBound);
            generatedValue = random.ints(leftBound, rightBound).findFirst().getAsInt();
            generatedNum.setText(String.valueOf(generatedValue));
        }
    }

    class LessThenUserValue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (generatedValue <= leftBound) {
                new OneMoreTimeInCheat().actionPerformed();
            }
            generatedValue = random.ints(leftBound, generatedValue).findFirst().getAsInt();
            generatedNum.setText(String.valueOf(generatedValue));
        }
    }

    class GreaterThenUserValue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (generatedValue >= rightBound - 1) {
                new OneMoreTimeInCheat().actionPerformed();
            }
            generatedValue = random.ints(generatedValue, rightBound).findFirst().getAsInt();
            generatedNum.setText(String.valueOf(generatedValue));
        }
    }

    class EqualsWithUserValue implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            secondWindow = new JFrame() {
            };
            secondWindow.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            secondWindow.setBounds(dimension.width / 2 - 250,
                    dimension.height / 2 - 150, 400, 200);
            secondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            secondWindow.setTitle("Victory!");
            oneMoteTimeInVictory.addActionListener(new OneMoreTimeInVictory());
            secondWindow.add(oneMoteTimeInVictory);
        }
    }

    class OneMoreTimeInVictory implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            secondWindow.setVisible(false);
            secondWindow.dispose();
            generatedNum.setText("");
            firstBound.setText("");
            secondBound.setText("");
        }
    }

    class OneMoreTimeInCheating implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            firstWindow.setVisible(false);
            firstWindow.dispose();
            generatedNum.setText("");
            firstBound.setText("");
            secondBound.setText("");
        }
    }

    class OneMoreTimeInCheat {

        public void actionPerformed() {
            firstWindow = new JFrame() {
            };
            firstWindow.setVisible(true);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            firstWindow.setBounds(dimension.width / 2 - 250,
                    dimension.height / 2 - 100, 400, 200);
            firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            oneMoteTimeInCheat.addActionListener(new OneMoreTimeInCheating());
            firstWindow.setTitle("You're cheating!");
            firstWindow.add(oneMoteTimeInCheat);
        }
    }
}
