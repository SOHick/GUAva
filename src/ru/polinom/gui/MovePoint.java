package ru.polinom.gui;

import ru.Nikita.graphics.Convector;
import ru.sohick.Painter;

import java.awt.*;

public class MovePoint implements Painter
{
   public int x,y;
    private final Convector a;
    public MovePoint(Convector a)
    {
        this.a = a;
    }
    @Override
    public void paint(Graphics g, int Wight, int Height)
    {
        MovePoints(g);

    }
    public void XY (int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public  void MovePoints (Graphics g)
    {
       g.setColor(Color.LIGHT_GRAY);
        int dx = -17;
        int dy = 30;
        int gal = 12;
        double coordx = a.xScr2Crt(x);
        double coordy = a.yScr2Crt(y);
        String pixelStr = (x + " " + y);
        String builder = "(" +
                String.format("%.1f", coordx) +  ";" +
                String.format("%.1f", coordy) +

                ")";
        g.drawString(pixelStr,x+dx,y+dy);
        g.drawString(builder,x+dx,y+dy+gal);
       // g.fillRect(x,y,50,50);

    }

}
