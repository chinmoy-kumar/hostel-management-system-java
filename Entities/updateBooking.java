package Entities;

import java.lang.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;

public class updateBooking {

    public updateBooking(String bookingDetails, String userName) {
        try {
            File f1 = new File("Booking.txt");
            File tempF1 = new File("temp_booking.txt");

            Scanner sc = new Scanner(f1);
            PrintWriter fw = new PrintWriter(new FileWriter(tempF1));

            boolean update = false;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(";");

                if (parts.length > 0 && !update) {
                    fw.println("Booking 1:" + bookingDetails);
                    update = true;
                } else {
                    fw.println(line);
                }
            }
            sc.close();
            fw.flush();
            fw.close();

            
            if (f1.delete()) {
                tempF1.renameTo(f1);
            }

        }

        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}