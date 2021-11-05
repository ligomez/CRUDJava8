package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {
        setTitle("My Luber App");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResultsPanel resultsPanel = new ResultsPanel();
        setContentPane(resultsPanel);

        add(new ControlsPanel(resultsPanel));

        setSize(1020, 650);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = getSize();
        setLocation((screenSize.width  - frameSize.width)  / 2,
                (screenSize.height - frameSize.height) / 2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
