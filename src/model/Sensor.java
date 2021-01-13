package TP_INFO708_GUI.src.model;

public class Sensor {
    public DataToMeasure objectObserved;
    private float valueMeasured;

    public Sensor(DataToMeasure objectObserved){
        this.objectObserved = objectObserved;
        this.valueMeasured = 0.0f;
    }

    public void writeValue(float value){ this.valueMeasured = value; }

    public float readValue(){ return this.valueMeasured; }
}
