package com.company;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class Main
{

    public static <in> void main(String[] args)
    {
        String fname = "list";
        LinkedList <Integer> numberList = new LinkedList<>();

        for( int i = 0; i < 1000;i++)
        {
            numberList.add(i);
        }

        try (RandomAccessFile out = new RandomAccessFile (fname, "rw"))
        {
            for( int in = 0; in < 1000;in++)
                out.writeInt(numberList.get(in));
        }
        catch(Exception e) {System.out.println(e);}

        LinkedList <Integer> newList = new LinkedList<>();
        try (RandomAccessFile in = new RandomAccessFile (fname, "r"))
        {
            for (int q = 100; q < 1000; q = q + 100)
            {
                in.seek(q * Integer.BYTES);
                newList.add(in.readInt());
            }
        }
        catch(Exception e) {System.out.println(e);}
        System.out.println(newList);
    }
}
