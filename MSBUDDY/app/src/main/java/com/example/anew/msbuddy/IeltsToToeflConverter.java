package com.example.anew.msbuddy;

/**
 * Created by New on 09/04/2018.
 */
public class IeltsToToeflConverter {

    public  int convert(float value)
    {
        int result=0;
        if(value==9)
        {
            result= 30;
        }
        else  if(value==8.5)
        {
            result=29;

        }
        else  if(value==8)
        {
            result=28;

        }
        else  if(value==7.5)
        {
            result=27;

        }
        else  if(value==7)
        {
            result=25;

        }
        else  if(value==6.5)
        {
            result=19;

        }
        else  if(value==6)
        {
            result=15;

        }
        else  if(value==5.5)
        {
            result=9;

        }
        else  if(value==5)
        {
            result=5;

        }
        else  if(value==4.5)
        {
            result=3;

        }
        else {
            result=1;
        }
        return  result;

    }

}
