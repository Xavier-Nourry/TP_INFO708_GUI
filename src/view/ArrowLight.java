package view;

import java.awt.*;
import TP_INFO708_GUI.src.view.AlertLight;

public class ArrowLight extends Canvas{
    public Color colorOn;
    public Color colorOff;
    private Color currentColor;
    private int[] xpoints;
    private int[] ypoints;
    private int nbPoints;

    public ArrowLight(Color color, boolean direction){
        this.colorOn = color; 
        this.colorOff = colorOn.darker();
        this.currentColor = this.colorOff;
        setSize(32, 32);

        xpoints = new int[] {16, 5, 10, 11, 21, 21, 27};
        ypoints = new int[] {5, 16, 16, 31, 31, 16, 16};
        nbPoints = 7;
        
        if(!direction){
            invertArrow();
        }
    }

    private void invertArrow(){
        for (int i = 0; i < 7; i++) {
            this.ypoints[i] = 31 - this.ypoints[i];
        }
    }

    public void paint(Graphics g){
        g.setColor(this.currentColor);
        g.fillPolygon(xpoints, ypoints, nbPoints);
    }
}

