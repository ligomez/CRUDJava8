package view;

import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    private JTable tblResults;
    private JScrollPane jScrollPane;

    public ResultsPanel() {
        initComponents();
    }

    private void initComponents() {
        this.tblResults = new JTable();
        this.tblResults.setRowHeight(22);
        this.tblResults.setGridColor(Color.gray);
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.jScrollPane = new JScrollPane(this.tblResults);
        add(jScrollPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1020,800));

    }
    public JTable getTblResults() {
        return tblResults;
    }

    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}
