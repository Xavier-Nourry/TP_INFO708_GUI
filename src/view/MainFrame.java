package TP_INFO708_GUI.src.view;

import java.awt.*;
import javax.swing.JFrame;
import TP_INFO708_GUI.src.view.AlertLight;

public class MainFrame extends JFrame{
    public MainFrame(){
        /*################# Configuration de la fenêtre #################*/
        setSize(300, 300);
        setTitle("Système de drainage dans une mine");
        setLayout(new GridLayout(5,1));

        /*################# EAU #################*/
        Label waterLabel = new Label("Niveau d'eau :");
        Label waterLevelLabel = new Label("0.0f");
        AlertLight waterDecreasingLevelAlert = new AlertLight(Color.CYAN);
        AlertLight waterIncreasingLevelAlert = new AlertLight(Color.CYAN);
        FlowLayout waterElementsLayout = new FlowLayout();
        Container waterElementsContainer = new Container();
        waterElementsContainer.setLayout(waterElementsLayout);
        waterElementsContainer.add(waterLabel, null);
        waterElementsContainer.add(waterLevelLabel, null);
        waterElementsContainer.add(waterDecreasingLevelAlert, null);
        waterElementsContainer.add(waterIncreasingLevelAlert, null);
        
        /*################# CO #################*/
        Label CO_Label = new Label("Niveau de CO :");
        Label CO_LevelLabel = new Label("0.0f");
        AlertLight CO_DecreasingLevelAlert = new AlertLight(Color.GREEN);
        AlertLight CO_IncreasingLevelAlert = new AlertLight(Color.GREEN);
        FlowLayout CO_ElementsLayout = new FlowLayout();
        Container CO_ElementsContainer = new Container();
        CO_ElementsContainer.setLayout(CO_ElementsLayout);
        CO_ElementsContainer.add(CO_Label, null);
        CO_ElementsContainer.add(CO_LevelLabel, null);
        CO_ElementsContainer.add(CO_DecreasingLevelAlert, null);
        CO_ElementsContainer.add(CO_IncreasingLevelAlert, null);

        /*################# CH4 #################*/
        Label CH4_Label = new Label("Niveau de CH4 :");
        Label CH4_LevelLabel = new Label("0.0f");
        AlertLight CH4_DecreasingLevelAlert = new AlertLight(Color.YELLOW);
        AlertLight CH4_IncreasingLevelAlert = new AlertLight(Color.YELLOW);
        FlowLayout CH4_ElementsLayout = new FlowLayout();
        Container CH4_ElementsContainer = new Container();
        CH4_ElementsContainer.setLayout(CH4_ElementsLayout);
        CH4_ElementsContainer.add(CH4_Label, null);
        CH4_ElementsContainer.add(CH4_LevelLabel, null);
        CH4_ElementsContainer.add(CH4_DecreasingLevelAlert, null);
        CH4_ElementsContainer.add(CH4_IncreasingLevelAlert, null);
        
        /*################# Ajout des éléments à la fenêtre #################*/
        add(waterElementsContainer);
        add(CH4_ElementsContainer);
        add(CO_ElementsContainer);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
