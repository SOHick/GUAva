package ru.Nikita.graphics;

public class Convector
{
    //(width)/(xMax-xMin)*(x-xMinx)
    //(width)/(xMax-xMin) = D
    //x3:d + xMin
    //x3 пусть 750 пикселей
    // Подправить другие методы
    //Надо чтобы конвектировалось из экранного(то есть пиксели) в декартовое и наоборот
    public double xMin,xMax,yMax,yMin;

    public int width,height;
    public Convector(double xMin,double xMax,double yMin,double yMax,int width,int height)
    {
        this.width = width;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax  = yMax;
        this.height = height;

    }
    public double getXDen() {return (width) / (xMax-xMin);}
    public double getYDen() {return (height)/ (yMax-yMin);}
    public int xDistCrt2Scr(double x1, double x2){
        return (int)(getXDen()*Math.abs(x1-x2));
    }
    public int yDistCrt2Scr(double y1, double y2){
        return (int)(getYDen()*Math.abs(y1-y2));
    }
    public int xCrt2Scr(double x)
    {
        int v = (int)(getXDen()*(x-xMin));
        if (v < -width) v = -width;
        if(v> 2*width) v=2*width;
        return v;
    }
    public int yCrt2Scr(double y)
    {
        int v = (int)(getYDen()*(yMax-y));
        if (v < -height) v = -height;
        if(v> 2*height) v=2*height;
        return v;
    }
    public void SetXEdges (Double xMin,Double xMax)
    {
        this.xMin = xMin;
        this.xMax = xMax;
    }

    public void SetYEdges (Double yMin,Double yMax)
    {
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public  void  setWidth(int width){this.width = width;}
    public  void  setHeight(int height){this.height = height;}

    public double xScr2Crt(int x)
    {
      return x / getXDen() + xMin;
    }
    public double yScr2Crt(int y)
    {
         return  yMax - y / getYDen();
    }
}
