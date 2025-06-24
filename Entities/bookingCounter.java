package Entities;

import java.lang.*;
import java.io.*;
import java.awt.*;

public class bookingCounter {
    public static int countLine() {
        int lineCnt = 0;
        File file = new File("./Data/Booking.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("Booking "))
                {
                    lineCnt++;
                }
            }

        } 
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        return lineCnt;
    }
}
