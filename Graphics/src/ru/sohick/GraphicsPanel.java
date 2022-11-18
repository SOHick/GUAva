package ru.sohick;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;



public class GraphicsPanel extends JPanel
{
    private ArrayList<Painter> p = new ArrayList<>();
    public GraphicsPanel(Collection<Painter> pts )
    {
        p.addAll(pts);
    }
    public GraphicsPanel(Painter p)
    {
        this.p.add(p);
    }
    public void add (Painter p)
    {
        this.p.add(p);
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        for(var ptr: this.p)
        {

            ptr.paint(g,getWidth(),getHeight());

        }
    }
    // передаю значение JSpinner, попробовать с помошью них сделать разбиение

}
