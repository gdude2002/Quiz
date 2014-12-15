package com.github.quiz;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GUI {
    JFrame panel;

    public GUI () {
        this.panel = new JFrame();
        this.panel.setLayout(new MigLayout("", "[][grow][][grow]"));
        this.panel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.panel.setTitle("Quiz");
        this.panel.setSize(500, 100);

        this.initUI();
    }

    public void initUI(){
        JLabel firstnameLabel = new JLabel("First name");
        JLabel lastnameLabel = new JLabel("Last name");
        JLabel addressLabel = new JLabel("Address name");

        JTextField firstnameField = new JTextField();
        JTextField lastnameField = new JTextField();
        JTextField addressField = new JTextField();

        this.panel.add(firstnameLabel);
        this.panel.add(firstnameField, "grow");
        this.panel.add(lastnameLabel, "gap unrelated");
        this.panel.add(lastnameField, "grow, wrap");
        this.panel.add(addressLabel);
        this.panel.add(addressField, "span, grow");
    }
}
