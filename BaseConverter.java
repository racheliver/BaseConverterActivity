package com.racheli.baseconverter;

/*************************************
 * Created by racheli on 02/05/2017. *
 * Id:305710071                      *
 * ***********************************
 *
 * The method convertFrom10 in the Program BaseConverter
 * get as number num parameters in the decimal and the base to which you want to convert,
 * and return a string that represents the base base number.
 *For bases with a number of digits greater than 10
 *(such as base 16) the method will add "digits" which are large English letters, in order. For example,
 *if the base of the conversion is base 20, the method will use the digits
 *0-9 and A-J to represent a total of 20 digits, and the base for conversion is assumed to be no greater than 36.
 */

public class BaseConverter
{
        final static int RESET=0;

    public static String convertFrom10(int num, int base)
    {
        int rest =RESET;
        int division=num;
        String str="";

        while (division!=RESET)
        {
            rest=division%base;
            division=division/base;
            if ((rest>=RESET && rest<=9) || rest>20)
                str+=Integer.toString(rest);
            else if (rest>9 && rest<=20)
            {
                str+=BaseMoreThen10(rest);
            }
            else
                break;
        }
        return reverse(str);
    }
    private static String BaseMoreThen10(int rest)
    {
        String str="";
        char chr;
        if (rest>=10 &&rest <=20)
            for (int i = 10; i <= 20; i++)
            {
                if (rest ==i)
                {
                    rest=rest+55;
                    chr=(char)rest;
                    str=str.valueOf(chr);
                }
            }
        return  str;
    }
    private static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=RESET;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

}

