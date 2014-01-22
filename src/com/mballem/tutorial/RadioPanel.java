package com.mballem.tutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 20/01/14
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class RadioPanel {

    private JPanel panel;
    private JFrame frame;
    private ArrayList<JRadioButton> radioButtons;

    public void buildGUI() {
        frame = new JFrame("Serializable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        radioButtons = new ArrayList<JRadioButton>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new MySaveListener());
        buttonBox.add(btnSave);

        JButton btnLoad = new JButton("Load");
        btnLoad.addActionListener(new MyLoadListener());
        buttonBox.add(btnLoad);

        background.add(BorderLayout.EAST, buttonBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(12, 12);
        grid.setVgap(1);
        grid.setHgap(2);
        panel = new JPanel(grid);
        background.add(BorderLayout.CENTER, panel);

        for (int i = 0; i < 204; i++) {
            JRadioButton rb = new JRadioButton();
            rb.setSelected(false);
            radioButtons.add(rb);
            panel.add(rb);
        }

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Listener button save
     */
    class MySaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            RadioList radioList = new RadioList();
            radioList.setRadioButtonList(radioButtons);
            new SerializeService().toSerialize(radioList);
        }
    }

    /**
     * Listener button load
     */
    class MyLoadListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            RadioList radioList = new SerializeService().toDeserialize();
            for (int i = 0; i < radioList.getRadioButtonList().size(); i++) {
                JRadioButton radioButton = radioButtons.get(i);
                radioButton.setSelected(
                        radioList.getRadioButtonList().get(i).isSelected()
                );
            }
        }
    }

    public static void main(String[] args) {
        new RadioPanel().buildGUI();
    }
}
