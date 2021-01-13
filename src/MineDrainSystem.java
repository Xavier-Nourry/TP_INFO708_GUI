package TP_INFO708_GUI.src;

import java.io.*;

import TP_INFO708_GUI.src.model.DataToMeasure;
import TP_INFO708_GUI.src.model.Device;
import TP_INFO708_GUI.src.model.Sensor;

public class MineDrainSystem(){
    public static void main(String[] args){
        System.out.println("Running...");
        
        Device fan = new Device("Fan", false);
        Device pump = new Device("Pump", false);
        Sensor water = new Sensor(DataToMeasure.H2O);
        Sensor methane = new Sensor(DataToMeasure.CH4);
        Sensor carbonMonoxide = new Sensor(DataToMeasure.CO);
    }
}