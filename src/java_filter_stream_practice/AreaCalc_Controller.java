/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_filter_stream_practice;

/**
 *
 * @author rizky
 */
public class AreaCalc_Controller {
    private double length;
    private double width;
    private final AreaCalc view;

    public AreaCalc_Controller(AreaCalc view) {
        this.view = view;
    }
    
    
    public double getArea(){
        String strLength=view.getTxtLength().getText();
        String strWidth=view.getTxtWidth().getText();
        this.length = Double.valueOf(strLength);
        this.width = Double.valueOf(strWidth);
        return length * width;
    }
    public double getPerimeter(){
        String strLength=view.getTxtLength().getText();
        String strWidth=view.getTxtWidth().getText();
        this.length = Double.valueOf(strLength);
        this.width = Double.valueOf(strWidth);
        return (2*length)+(2*width);
    }
    
}
