package ru.polinom.gui;

import ru.Nikita.graphics.Convector;
import ru.sohick.Painter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PointPainter implements Painter
{
    public double xMin,xMax,yMax,yMin;
    private  int width,height;
    private final Map<Double, Double> d;
    Color color;
    public boolean statePoint;
    private final Convector a;

// Попробовать написать удаление точки
    public PointPainter(Map<Double,Double> Point,Convector a,Color color)
    {
        this.a = a;
        this.d = Point;
        this.color = color;

    }
    @Override
    public void paint(Graphics g, int width, int height)
    {
        this.xMin = a.xMin;
        this.xMax = a.xMax;
        this.yMin = a.yMin;
        this.yMax = a.yMax;
        this.width = a.width;
        this.height = a.height;
        if(statePoint)
        {
            AddPoint(g);
        }
}
    public void AddPoint(Graphics g)
    {
        g.setColor(color);
        for(double x: d.keySet())
        {
            double y = d.get(x);
            g.fillRect(a.xCrt2Scr(x)-2,a.yCrt2Scr(y)-2,4,4);
        }
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void  RemovePoint(double x, double y)
    {
        var r  = new HashMap<Double,Double>();
        for(double s :d.keySet())
        {
            if((a.xDistCrt2Scr(x, s) <
                    a.xDistCrt2Scr(Math.min((xMax - xMin) / 100., 0.05),0.0) &&
                    a.yDistCrt2Scr(y, d.get(s)) <
                            a.xDistCrt2Scr(Math.min((xMax - xMin) / 100., 0.05),0.0))) // Записать нормально условие
            {
                r.put(s, d.get(s));
            }
        }
        for(double v: r.keySet())
        {
            d.remove(v, r.get(v));
        }
    }
}
