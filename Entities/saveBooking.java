package Entities;

import java.lang.*;
import java.util.*;
import java.io.*;
import Frames.*;


public class saveBooking {
    String bookingData;

    File myFile;
    FileWriter fwrite;
    Scanner sc;

    public saveBooking()
    {

    }
    public saveBooking(String bookingData)
    {
        this.bookingData = bookingData;
    }
    public String getBookingData()
    {
        return bookingData;
    }

    public void saveBookingInfo()
    {
        try{
            System.out.println("Saving booking: " + getBookingData()); 
            myFile = new File("Booking.txt");
            myFile.createNewFile();
            fwrite = new FileWriter(myFile, true);

            fwrite.write(getBookingData()+"\n");

            fwrite.flush();
            fwrite.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
