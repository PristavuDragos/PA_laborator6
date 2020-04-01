package com.company;

import java.awt.*;

public class Star
{
    public Star(int x0,int y0,int radius,Graphics2D g,int nPoints)
    {
        int[] X = new int[nPoints];
        int[] Y = new int[nPoints];

        float angle = 360/nPoints;

        for (int i = 0; i < nPoints; i++) {
            if (i%2==0)
            {
                X[i] = (int) (Math.cos( Math.toRadians( angle * i )) * radius)+x0;
                Y[i] = (int) (Math.sin( Math.toRadians( angle * i )) * radius)+y0;
            }
            else
            {
                X[i] = (int) (Math.cos( Math.toRadians( angle * i )) * radius/2)+x0;
                Y[i] = (int) (Math.sin( Math.toRadians( angle * i )) * radius/2)+y0;
            }
        }
        g.fillPolygon(X, Y, nPoints);
    }
}
