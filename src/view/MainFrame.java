package TP_INFO708_GUI.src.view;

import java.awt.*;

public class MainFrame extends Frame{
    public MainFrame(){
        Label waterLabel = new Label("Niveau d'eau :");
        Label waterLevelLabel = new Label("0.0f");
        Label CO_Label = new Label("Niveau de CO :");
        Label CO_LevelLabel = new Label("0.0f");
        Label CH4_Label = new Label("Niveau de CH4 :");
        Label CH4_LevelLabel = new Label("0.0f");
        
        setLayout(null);
        setVisible(true);
    }
}