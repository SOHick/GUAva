package ru.polinom.gui;
import ru.Nikita.graphics.Convector;
import ru.sohick.Painter;

import javax.swing.*;
import java.awt.*;


public class CrtPainter implements Painter
{
    private double xMin, xMax, yMin, yMax;
    private int xCenter, yCenter;
    private int width, height;
    int th = 2;
    private JSpinner xMins, xMaxs, yMins, yMaxs;
    // Храним только декартовые координаты
    // Добавить функ в конвертор, который конвертирует длину пикселей в декартовую
    double scala = Math.pow(10,1);
    String Ox;
    String Oy;
    private Convector a;
    public CrtPainter(JSpinner xmins, JSpinner xmaxs, JSpinner ymins, JSpinner ymaxs)
    {
        this.xMins = xmins;
        this.xMaxs = xmaxs;
        this.yMins = ymins;
        this.yMaxs = ymaxs;
    }

    @Override
    public void paint(Graphics g, int width, int height)
    {

        // g.fillRect( 100 ,100 ,100 ,100);
        xMin = (Double)xMins.getValue();
        xMax = (Double)xMaxs.getValue();
        yMin = (Double)yMins.getValue();
        yMax = (Double)yMaxs.getValue();
        a = new Convector(xMin, xMax, yMin, yMax, width, height);
        xCenter = a.xCrt2Scr(0);
        yCenter = a.yCrt2Scr(0);
        g.setColor(Color.black);
        g.drawLine(xCenter, 0, xCenter, height);
        g.drawLine(0, yCenter, width, yCenter);// Почему то при height рисует на краю панельки   // Почему то при height рисует на краю панельки
        DrawYAxis(width, g);
        DrawXAxis(height,g);
    }
    public void DrawXAxis (int height,Graphics g)
    {
        g.setColor(Color.black);
        Color oldColor = g.getColor();
        Color newColor = new Color(200,0,0);
        if (yMax * yMin < 0)
        {
            //рисуем штрихи на оси х
            for(double i = xMin; i<xMax;i+=0.1)
            {
                double j = Math.round(i * scala) / scala;
                Ox = Double.toString(j);
                double X2 = g.getFontMetrics().getStringBounds(Ox,g).getWidth(); //x-w/2
                double Y2 = g.getFontMetrics().getStringBounds(Ox,g).getHeight(); //y+th+1+h
                if((Math.round(10*j)%10 == 0))
                {
                    if(j<0)
                    {
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2) , yCenter+th+1+(int)Y2);

                    }
                    else if(j>0)
                    {
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2), yCenter+th+1+(int)Y2);
                    }
                    else
                    {
                        g.drawString("0.0",a.xCrt2Scr(j)-(int)(1.5*X2), yCenter+th+1+(int)Y2); //22
                    }
                    //g.drawLine(a.xCrt2Scr(j), 0, a.xCrt2Scr(j), height);
                    th+=4;
                }
                else if(Math.round(10*j)%5 == 0)
                {
                    th+=2;
                }

                g.setColor(newColor);
                g.drawLine(a.xCrt2Scr(j), yCenter-th, a.xCrt2Scr(j), yCenter+th);
                g.setColor(oldColor);

                th = 2;
            }
        }
        else {
            //рисуем штрихи сверху и снизу
            for(double i = xMin; i<xMax;i+=0.1)
            {
                double j = Math.round(i * scala) / scala;
                Ox = Double.toString(j);
                double X2 = g.getFontMetrics().getStringBounds(Ox,g).getWidth(); //x-w/2
                double Y2 = g.getFontMetrics().getStringBounds(Ox,g).getHeight(); //y+th+1+h
                if((Math.round(10*i)%10 == 0))
                {
                    th+=4;
                    if (j<0)
                    {
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2) ,th+(int)Y2+1);
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2), height-th-1);

                    }
                    else if(j>0)
                    {
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2) ,th+(int)Y2+1);
                        g.drawString(Ox,a.xCrt2Scr(j)-(int)(X2/2), height-th-2);

                    }
                    else
                    {
                        g.drawString("0.0",a.xCrt2Scr(j)-(int)(X2)-th ,th+(int)Y2+1);
                        g.drawString("0.0",a.xCrt2Scr(j)-(int)(X2)-th, height-th-2);
                    }
                }
                else if(Math.round(10*i)%5==0)
                {
                    th+=2;
                }

                g.setColor(newColor);
                g.drawLine(a.xCrt2Scr(j), 0, a.xCrt2Scr(j), th);
                g.drawLine(a.xCrt2Scr(j), height-th-1, a.xCrt2Scr(j), height);
                g.setColor(oldColor);
                th = 2;
            }
        }

    }
    public void DrawYAxis (int width,Graphics g)
    {
        g.setColor(Color.black);
        Color oldColor = g.getColor();
        Color newColor = new Color(200,0,0);
        if (xMax * xMin < 0)
        {
            //рисуем штрихи на оси у
                for(double i = yMin; i < yMax; i+=0.1)
                {
                    double j = Math.round(i * scala) / scala;
                    Oy = Double.toString(j);
                    if((10*j)%10 == 0 && (j != 0))
                    {
                        th+=4;
                        double X1 = g.getFontMetrics().getStringBounds(Oy,g).getWidth(); //x-w/2
                        double Y1 = g.getFontMetrics().getStringBounds(Oy,g).getHeight(); //y+th+1+h
                        if(j<0)
                        {

                            g.drawString(Oy,xCenter-1-th-(int)X1 , a.yCrt2Scr(j)+(int)(Y1*0.25));
                        }
                        else if(j>0)
                        {
                            g.drawString(Oy,xCenter-1-th-(int)X1, a.yCrt2Scr(j)+(int)(Y1*0.25));
                        }
                    }
                    else if(Math.round(10*j)%5==0)
                    {
                        th+=2;
                    }
                    // g.drawLine(0, a.yCrt2Scr(j), width, a.yCrt2Scr(j));
                    g.setColor(newColor);
                    g.drawLine(xCenter-th, a.yCrt2Scr(j), xCenter+th, a.yCrt2Scr(j));
                    th = 2;
                    g.setColor(oldColor);
                }
        }
        else {
            //рисуем штрихи по бокам
            for(double i = yMin; i<yMax;i+=0.1)
            {
                double j = Math.round(i * scala) / scala;
                double X1 = g.getFontMetrics().getStringBounds(Oy,g).getWidth(); //x-w/2
                double Y1 = g.getFontMetrics().getStringBounds(Oy,g).getHeight(); //y+th+1+h
                Oy = Double.toString(j);

                if(Math.round(10*j)%10 == 0)
                {
                    th+=4;
                    if(j<0)
                    {
                        g.drawString(Oy,th+2, a.yCrt2Scr(j)+(int)(Y1/2));
                        g.drawString(Oy,width-th-(int)X1, a.yCrt2Scr(j)+(int)(Y1/2));
                    }
                    else if(j>0)
                    {
                        g.drawString(Oy,th+2, a.yCrt2Scr(j)+(int)(Y1/2));
                        g.drawString(Oy,width-th-(int)X1, a.yCrt2Scr(j)+(int)(Y1/2));
                    }
                }
                else if(Math.round(10*j)%5==0)
                {
                    th+=2;
                }
                g.setColor(newColor);
                g.drawLine(0, a.yCrt2Scr(j), th, a.yCrt2Scr(j));
                g.drawLine(width-th, a.yCrt2Scr(j), width, a.yCrt2Scr(j));
                g.setColor(oldColor);
                th = 2;
            }
        }
    }
}