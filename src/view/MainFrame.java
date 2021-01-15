package TP_INFO708_GUI.src.view;

import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JFrame;

import TP_INFO708_GUI.src.model.*;
import TP_INFO708_GUI.src.view.*;

public class MainFrame extends JFrame implements Observer{
    private Label waterLevelLabel;
    private Label CO_LevelLabel;
    private Label CH4_LevelLabel;
    private Device fan;
    private Device pump;
    private Sensor water;
    private Sensor methane;
    private Sensor carbon;
    private AlertLight waterDecreasingLevelAlert;
    private AlertLight waterIncreasingLevelAlert;
    private AlertLight CO_DecreasingLevelAlert;
    private AlertLight CO_IncreasingLevelAlert;
    private AlertLight CH4_DecreasingLevelAlert;
    private AlertLight CH4_IncreasingLevelAlert;
    private AlertLight fanAlert;
    private AlertLight pumpAlert;

    @Override
    public void update(Observable obj, Object arg) {
        /*################# Labels text update #################*/
        this.waterLevelLabel.setText(String.valueOf(this.water.readValue()));
        this.CO_LevelLabel.setText(String.valueOf(this.carbon.readValue()));
        this.CH4_LevelLabel.setText(String.valueOf(this.methane.readValue()));

        /*################# Water alert lights update #################*/
        if(this.water.readCurrentValue() > this.water.readLastMeasuredValue()){
            this.waterIncreasingLevelAlert.setCurrentColorToOn();
            this.waterDecreasingLevelAlert.setCurrentColorToOff();
            this.water.updateLastMeasuredValue();
        }else if(this.water.readCurrentValue() < this.water.readLastMeasuredValue()){
            this.waterDecreasingLevelAlert.setCurrentColorToOn();
            this.waterIncreasingLevelAlert.setCurrentColorToOff();
            this.water.updateLastMeasuredValue();
        }else{
            this.waterDecreasingLevelAlert.setCurrentColorToOff();
            this.waterIncreasingLevelAlert.setCurrentColorToOff();
        }

        /*################# Carbon monoxide alert lights update #################*/
        if(this.carbon.readCurrentValue() > this.carbon.readLastMeasuredValue()){
            this.CO_IncreasingLevelAlert.setCurrentColorToOn();
            this.CO_DecreasingLevelAlert.setCurrentColorToOff();
            this.carbon.updateLastMeasuredValue();
        }else if(this.carbon.readCurrentValue() < this.carbon.readLastMeasuredValue()){
            this.CO_DecreasingLevelAlert.setCurrentColorToOn();
            this.CO_IncreasingLevelAlert.setCurrentColorToOff();
            this.carbon.updateLastMeasuredValue();
        }else{
            this.CO_DecreasingLevelAlert.setCurrentColorToOff();
            this.CO_IncreasingLevelAlert.setCurrentColorToOff();
        }

        /*################# Methane alert lights update #################*/
        if(this.methane.readCurrentValue() > this.methane.readLastMeasuredValue()){
            this.CH4_IncreasingLevelAlert.setCurrentColorToOn();
            this.CH4_DecreasingLevelAlert.setCurrentColorToOff();
            this.methane.updateLastMeasuredValue();
        }else if(this.methane.readCurrentValue() < this.methane.readLastMeasuredValue()){
            this.CH4_DecreasingLevelAlert.setCurrentColorToOn();
            this.CH4_IncreasingLevelAlert.setCurrentColorToOff();
            this.methane.updateLastMeasuredValue();
        }else{
            this.CH4_DecreasingLevelAlert.setCurrentColorToOff();
            this.CH4_IncreasingLevelAlert.setCurrentColorToOff();
        }

        /*################# Fan alert light update #################*/
        if(this.fan.getState()){
            this.fanAlert.setCurrentColorToOn();
        }else{
            this.fanAlert.setCurrentColorToOff();
        }

        /*################# Pump alert light update #################*/
        if(this.pump.getState()){
            this.pumpAlert.setCurrentColorToOn();
        }else{
            this.pumpAlert.setCurrentColorToOff();
        }
    }
    
    public MainFrame(Device fan, Device pump, Sensor water, Sensor methane, Sensor carbon){
        this.fan = fan;
        this.pump = pump;
        this.water = water;
        this.methane = methane;
        this.carbon = carbon;    
        
        /*################# Configuration de la fenêtre #################*/
        setSize(500, 500);
        setTitle("Système de drainage dans une mine");
        setLayout(new GridLayout(6,1));

        /*################# EAU #################*/
        Label waterLabel = new Label("Niveau d'eau :");
        this.waterLevelLabel = new Label("0.0f");
        this.waterDecreasingLevelAlert = new AlertLight(Color.CYAN);
        this.waterIncreasingLevelAlert = new AlertLight(Color.CYAN);
        FlowLayout waterElementsLayout = new FlowLayout();
        Container waterElementsContainer = new Container();
        waterElementsContainer.setLayout(waterElementsLayout);
        waterElementsContainer.add(waterLabel, null);
        waterElementsContainer.add(waterLevelLabel, null);
        waterElementsContainer.add(waterDecreasingLevelAlert, null);
        waterElementsContainer.add(waterIncreasingLevelAlert, null);
        
        /*################# CO #################*/
        Label CO_Label = new Label("Niveau de CO :");
        this.CO_LevelLabel = new Label("0.0f");
        this.CO_DecreasingLevelAlert = new AlertLight(Color.GREEN);
        this.CO_IncreasingLevelAlert = new AlertLight(Color.GREEN);
        FlowLayout CO_ElementsLayout = new FlowLayout();
        Container CO_ElementsContainer = new Container();
        CO_ElementsContainer.setLayout(CO_ElementsLayout);
        CO_ElementsContainer.add(CO_Label, null);
        CO_ElementsContainer.add(CO_LevelLabel, null);
        CO_ElementsContainer.add(CO_DecreasingLevelAlert, null);
        CO_ElementsContainer.add(CO_IncreasingLevelAlert, null);

        /*################# CH4 #################*/
        Label CH4_Label = new Label("Niveau de CH4 :");
        this.CH4_LevelLabel = new Label("0.0f");
        this.CH4_DecreasingLevelAlert = new AlertLight(Color.YELLOW);
        this.CH4_IncreasingLevelAlert = new AlertLight(Color.YELLOW);
        FlowLayout CH4_ElementsLayout = new FlowLayout();
        Container CH4_ElementsContainer = new Container();
        CH4_ElementsContainer.setLayout(CH4_ElementsLayout);
        CH4_ElementsContainer.add(CH4_Label, null);
        CH4_ElementsContainer.add(CH4_LevelLabel, null);
        CH4_ElementsContainer.add(CH4_DecreasingLevelAlert, null);
        CH4_ElementsContainer.add(CH4_IncreasingLevelAlert, null);
        
        /*################# Fan #################*/
        Label fanLabel = new Label("Ventilateur :");
        this.fanAlert = new AlertLight(Color.RED);
        FlowLayout fanElementsLayout = new FlowLayout();
        Container fanElementsContainer = new Container();
        fanElementsContainer.setLayout(fanElementsLayout);
        fanElementsContainer.add(fanLabel, null);
        fanElementsContainer.add(fanAlert, null);

        /*################# Pump #################*/
        Label pumpLabel = new Label("Pompe :");
        this.pumpAlert = new AlertLight(Color.RED);
        FlowLayout pumpElementsLayout = new FlowLayout();
        Container pumpElementsContainer = new Container();
        pumpElementsContainer.setLayout(pumpElementsLayout);
        pumpElementsContainer.add(pumpLabel, null);
        pumpElementsContainer.add(pumpAlert, null);

        /*################# Bouton de lancement et d'arrêt du système #################*/
        Button startStopButton = new Button("Lancer le système");
        FlowLayout startStopButtonLayout = new FlowLayout();
        Container startStopButtonContainer = new Container();
        startStopButtonContainer.setLayout(startStopButtonLayout);
        startStopButtonContainer.add(startStopButton);

        /*################# Ajout des éléments à la fenêtre #################*/
        add(waterElementsContainer);
        add(CH4_ElementsContainer);
        add(CO_ElementsContainer);
        add(fanElementsContainer);
        add(pumpElementsContainer);
        add(startStopButtonContainer);
    
        /*################# Observables configuration #################*/
        fan.addObserver(this);
        pump.addObserver(this);
        water.addObserver(this);
        methane.addObserver(this);
        carbon.addObserver(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
