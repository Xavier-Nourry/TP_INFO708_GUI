package TP_INFO708_GUI.src.view;

import java.awt.*;

public class AlertLight extends Canvas{
    public Color colorOn;
    public Color colorOff;
    private Color currentColor;

    public AlertLight(Color color){ 
        this.colorOn = color; 
        this.colorOff = colorOn.darker();
        this.currentColor = this.colorOff;
        setSize(32, 32);
    }

    public void paint(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(0, 0, 32, 32);
        g.setColor(this.currentColor);
        g.fillOval(5, 5, 22, 22);
    }

    public void setCurrentColorToOn() { this.currentColor = this.colorOn; }

    public void setCurrentColorToOff() { this.currentColor = this.colorOff; }
}
