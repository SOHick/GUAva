package ru.polinom.gui;

import ru.Nikita.graphics.Convector;

public class MoveSpinner
{
    public double xMinJ,xMax,yMax,yMinJ;
    private final Convector a;
    public MoveSpinner(Convector a)
    {

        this.a = a;

    }
    public double MoveX (Double xMin)
    {
        return this.xMinJ = xMin +0.1;
    }
    public double MoveY (Double yMin)
{

    return this.yMinJ = yMin +0.1;
}
}
