package TP_INFO708_GUI.src.model;

public class Device {
    public String name;
    private boolean state;

    public Device(String name, boolean state){
        this.name = name;
        this.state = state;
    }

    public boolean getState(){ return this.state; }
    
    public void setState(boolean newState){ this.state = newState; }
}
