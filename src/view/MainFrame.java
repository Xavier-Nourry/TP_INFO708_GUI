package TP_INFO708_GUI.src.view;

import java.awt.*;

public class MainFrame extends Frame{
    public MainFrame(){
        setSize(800, 600);
        setTitle("Système de drainage dans une mine");
        setLayout(new GridLayout(5,4));

        Label waterLabel = new Label("Niveau d'eau :");
        Label waterLevelLabel = new Label("0.0f");
        Label CO_Label = new Label("Niveau de CO :");
        Label CO_LevelLabel = new Label("0.0f");
        Label CH4_Label = new Label("Niveau de CH4 :");
        Label CH4_LevelLabel = new Label("0.0f");
        
        add(waterLabel);
        add(waterLevelLabel);
        add(CO_Label);
        add(CO_LevelLabel);
        add(CH4_Label);
        add(CH4_LevelLabel);
        
        setVisible(true);
    }
}
