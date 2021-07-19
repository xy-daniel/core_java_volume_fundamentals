package com.daniel.corejava.two;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @author daniel
 */
public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImagerViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImagerViewerFrame extends JFrame {

    private final JLabel label;
    private final JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 1000;

    public ImagerViewerFrame() {
        System.out.println(123);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

//        use a label to display the image
        label = new JLabel();
        add(label);

//        set up the file chooser
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

//        set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu();
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem();
        menu.add(openItem);

        openItem.addActionListener(e -> {
//            show file chooser dialog
            int result = chooser.showOpenDialog(null);

//            if file selected, set it as icon of the label
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exitItem = new JMenuItem();
        menu.add(exitItem);
        exitItem.addActionListener(e -> {
            System.exit(0);
        });
    }

}
