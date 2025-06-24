package Entities;

import java.io.*;
import java.lang.*;


public class saveBooking {
    String bookingData, lastLine, currentLine, bookingNumberPart, formattedbookingData;
    File myFile, myFile2;
    FileWriter fwrite;
    static int bookingCounter = 1;

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


    public void updatebookingCounter()
    {
        myFile2 = new File("./Data/Booking.txt");

        if(myFile2.exists())
        {
            try(BufferedReader reader = new BufferedReader(new FileReader(myFile2)))
            {
                lastLine = "";
                while((currentLine = reader.readLine()) != null)
                {
                    lastLine = currentLine;
                }

                if(lastLine != null && lastLine.startsWith("Booking"))
                {
                    String[] parts = lastLine.split(":");
                    if(parts.length > 1)
                    {
                        bookingNumberPart = parts[0].trim();
                        String[] bookingNumber = bookingNumberPart.split(" ");
                        bookingCounter = Integer.parseInt(bookingNumber[1]) + 1;
                    }
                }
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }

    }


    public void saveBookingInfo()
    {
        updatebookingCounter();

        try{
            myFile = new File("./Data/Booking.txt");
            myFile.createNewFile();
            fwrite = new FileWriter(myFile, true);

            formattedbookingData = "Booking " + bookingCounter + ":" + getBookingData();

            fwrite.write(formattedbookingData +"\n");

            fwrite.flush();
            fwrite.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
