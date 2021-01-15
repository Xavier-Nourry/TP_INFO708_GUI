package TP_INFO708_GUI.src.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JFrame;

import TP_INFO708_GUI.src.model.*;
import TP_INFO708_GUI.src.view.*;
import view.ArrowLight;

public class MainFrame extends JFrame implements Observer, ActionListener{
    private boolean systemRunning;
    private Button startStopButton;
    private Label H2O_LevelLabel;
    private Label CO_LevelLabel;
    private Label CH4_LevelLabel;
    private Device fan;
    private Device pump;
    private Sensor H2O_;
    private Sensor methane;
    private Sensor carbon;
    private ArrowLight H2O_DecreasingLevelAlert;
    private ArrowLight H2O_IncreasingLevelAlert;
    private ArrowLight CO_DecreasingLevelAlert;
    private ArrowLight CO_IncreasingLevelAlert;
    private ArrowLight CH4_DecreasingLevelAlert;
    private ArrowLight CH4_IncreasingLevelAlert;
    private AlertLight fanAlert;
    private AlertLight pumpAlert;

    @Override
    public void update(Observable obj, Object arg) {
        /*################# Labels text update #################*/
        this.H2O_LevelLabel.setText(String.valueOf(this.H2O_.readValue()));
        this.CO_LevelLabel.setText(String.valueOf(this.carbon.readValue()));
        this.CH4_LevelLabel.setText(String.valueOf(this.methane.readValue()));

        /*################# H2O_ alert lights update #################*/
        if(this.H2O_.readCurrentValue() > this.H2O_.readLastMeasuredValue()){
            this.H2O_IncreasingLevelAlert.setCurrentColorToOn();
            this.H2O_DecreasingLevelAlert.setCurrentColorToOff();
            this.H2O_.updateLastMeasuredValue();
        }else if(this.H2O_.readCurrentValue() < this.H2O_.readLastMeasuredValue()){
            this.H2O_DecreasingLevelAlert.setCurrentColorToOn();
            this.H2O_IncreasingLevelAlert.setCurrentColorToOff();
            this.H2O_.updateLastMeasuredValue();
        }else{
            this.H2O_DecreasingLevelAlert.setCurrentColorToOff();
            this.H2O_IncreasingLevelAlert.setCurrentColorToOff();
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.systemRunning){
            System.out.println("Lancement du système");
            this.systemRunning = true;
            this.startStopButton.setLabel("Arrêter le système");
            // TODO : action Jinterface vers Erlang, lancement du système
        }else{
            System.out.println("Arrêt du système");
            this.systemRunning = false;
            this.startStopButton.setLabel("Lancer le système");
            // TODO : action Jinterface vers Erlang, arrêt du système
        }
    }

    public MainFrame(Device fan, Device pump, Sensor H2O_, Sensor methane, Sensor carbon){
        this.systemRunning = false;
        this.fan = fan;
        this.pump = pump;
        this.H2O_ = H2O_;
        this.methane = methane;
        this.carbon = carbon;
        
        /*################# Configuration de la fenêtre #################*/
        setSize(500, 500);
        setTitle("Système de drainage dans une mine");
        setLayout(new GridLayout(6,1));

        /*################# EAU #################*/
        Label H2O_Label = new Label("Niveau d'eau :");
        this.H2O_LevelLabel = new Label("0.0f");
        this.H2O_DecreasingLevelAlert = new ArrowLight(Color.CYAN, false);
        this.H2O_IncreasingLevelAlert = new ArrowLight(Color.CYAN, true);
        FlowLayout H2O_ElementsLayout = new FlowLayout();
        Container H2O_ElementsContainer = new Container();
        H2O_ElementsContainer.setLayout(H2O_ElementsLayout);
        H2O_ElementsContainer.add(H2O_Label, null);
        H2O_ElementsContainer.add(H2O_LevelLabel, null);
        H2O_ElementsContainer.add(H2O_DecreasingLevelAlert, null);
        H2O_ElementsContainer.add(H2O_IncreasingLevelAlert, null);
        
        /*################# CO #################*/
        Label CO_Label = new Label("Niveau de CO :");
        this.CO_LevelLabel = new Label("0.0f");
        this.CO_DecreasingLevelAlert = new ArrowLight(Color.GREEN, false);
        this.CO_IncreasingLevelAlert = new ArrowLight(Color.GREEN, true);
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
        this.CH4_DecreasingLevelAlert = new ArrowLight(Color.YELLOW, false);
        this.CH4_IncreasingLevelAlert = new ArrowLight(Color.YELLOW, true);
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
        this.startStopButton = new Button("Lancer le système");
        FlowLayout startStopButtonLayout = new FlowLayout();
        Container startStopButtonContainer = new Container();
        startStopButtonContainer.setLayout(startStopButtonLayout);
        startStopButtonContainer.add(startStopButton);

        /*################# Ajout des éléments à la fenêtre #################*/
        add(H2O_ElementsContainer);
        add(CH4_ElementsContainer);
        add(CO_ElementsContainer);
        add(fanElementsContainer);
        add(pumpElementsContainer);
        add(startStopButtonContainer);
    
        /*################# Observables configuration #################*/
        this.fan.addObserver(this);
        this.pump.addObserver(this);
        this.H2O_.addObserver(this);
        this.methane.addObserver(this);
        this.carbon.addObserver(this);
        this.startStopButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
