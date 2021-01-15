package TP_INFO708_GUI.src.model;

import java.util.Observable;

public class Sensor extends Observable{
    public DataToMeasure objectObserved;
    private float valueMeasured;
    private float lastValueMeasured;

    public Sensor(DataToMeasure objectObserved){
        this.objectObserved = objectObserved;
        this.valueMeasured = 0.0f;
        this.lastValueMeasured = 0.0f;
    }

    public void writeValue(float value){ 
        this.valueMeasured = value;
        setChanged();
        notifyObservers();
    }

    public void updateLastMeasuredValue() { this.lastValueMeasured = this.valueMeasured; }

    public float readCurrentValue(){ return this.valueMeasured; }

    public float readLastMeasuredValue(){ return this.lastValueMeasured; }
}
