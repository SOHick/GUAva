package ru.polinom.gui;

import ru.Nikita.graphics.Convector;
import ru.sohick.Painter;

import java.awt.*;

public class FunctionPainter implements Painter
{
    public double xMin,xMax,yMax,yMin;
   // private final Map<Double, Double> d;
    private int yCenter;
   // private final Polynomial P;
    Color colorPolynomial;
    Color colorDerivative;
    public boolean stateFunction;
    public boolean stateDerivative;
    double scala = Math.pow(100,1);
    private final Convector a;
    private Function f;
    private  Function fd;
    private int width,height;

    public  FunctionPainter(Convector a)
    {
        this.a = a;
    }
    public  void FP(Function function)
    {
       this.f = function;
    }
    @Override
    public void paint(Graphics g, int Wight, int Height)
    {
        yCenter = a.yCrt2Scr(0);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        this.xMin = a.xMin;
        this.xMax = a.xMax;
        this.yMin = a.yMin;
        this.yMax = a.yMax;
        this.width = a.width;
        this.height = a.height;
        if(stateFunction)
        {
            drawFunction(g2);
        }
        if(stateDerivative)
        {
            drawFunctionDerivative(g);
        }

    }
    // У меня создаётся полином через цикл нужно посчитать значение этого многочлена в точке через цикл с шагом +-0.001
    public void drawFunction(Graphics g)
    {
        g.setColor(colorPolynomial);
        for (double j = xMin; j < xMax; j+=0.01)
        {

            double x = Math.round(j * scala) / scala;
            double y = Math.round(f.invoke(x) * scala)/scala;
            double next = Math.round(f.invoke(x+0.01) * scala)/scala;
            g.drawLine(a.xCrt2Scr(x),a.yCrt2Scr(y),a.xCrt2Scr(x+0.01),a.yCrt2Scr(next));


        }

    }
    public void setColor1(Color color) {
        this.colorPolynomial = color;
    }
    public  void FPD(Function function)
    {
        this.fd = function;
    }
    public void drawFunctionDerivative(Graphics g)
    {
        g.setColor(colorDerivative);
        for (double j = xMin; j < xMax; j+=0.01)
        {
            double x = Math.round(j * scala) / scala;
            double y = Math.round(fd.invoke(x) * scala)/scala;
            double next = Math.round(fd.invoke(x+0.01) * scala)/scala;
            g.drawLine(a.xCrt2Scr(x),a.yCrt2Scr(y),a.xCrt2Scr(x+0.01),a.yCrt2Scr(next));
        }
    }
    public void setColor2(Color color) {
        this.colorDerivative = color;
    }

}
