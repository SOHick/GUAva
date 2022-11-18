package ru.polinom.gui;

import ru.Nikita.graphics.Convector;
import ru.sohick.Painter;

import java.awt.*;

public class FunctionPainter2 implements Painter
{
    public double xMin,xMax,yMax,yMin;
    Color colorDerivative;
    public boolean stateDerivative;
    double scala = Math.pow(100,1);
    private final Convector a;
    private Function f;
    private int  yCenter;
    private int width,height;
    public  FunctionPainter2(Convector a,Color color,Function function)
    {
        this.f = function;
        this.a = a;
        this.colorDerivative = color;

    }
    @Override
    public void paint(Graphics g, int Wight, int Height)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        yCenter = a.yCrt2Scr(0);
        this.xMin = a.xMin;
        this.xMax = a.xMax;
        this.yMin = a.yMin;
        this.yMax = a.yMax;
        this.width = a.width;
        this.height = a.height;
        yCenter = a.yCrt2Scr(0);
        if(stateDerivative)
        {
            drawFunctionDerivative(g2);
        }
    }
    public  void FP(Function function)
    {
        this.f = function;
    }
    public void drawFunctionDerivative(Graphics g)
    {

        g.setColor(colorDerivative);
        for (double j = xMin; j < xMax; j+=0.01)
        {
            double x = Math.round(j * scala) / scala;
            double y = Math.round(f.invoke(x) * scala)/scala;
            double next = Math.round(f.invoke(x+0.01) * scala)/scala;
            g.drawLine(a.xCrt2Scr(x),a.yCrt2Scr(y),a.xCrt2Scr(x+0.01),a.yCrt2Scr(next));
        }
    }
    public void setColor2(Color color) {
        this.colorDerivative = color;
    }

}
