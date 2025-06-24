package Entities;

import java.lang.*;
import javax.swing.JOptionPane;
import java.io.*;

public class deleteBooking {

    public deleteBooking() {
    };

    public deleteBooking(String bookingNum) {
        File dataFile = new File("./Data/Booking.txt");
        File tempFile = new File("./Data/data_temp.txt");
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                    String line;
                    String searchKeyword = "Booking " + bookingNum + ":";
            while ((line = reader.readLine()) != null) {
                String line1 = line.trim();
                if (line1.startsWith(searchKeyword) || line1.toLowerCase().startsWith(searchKeyword.toLowerCase())) {
                    found = true;
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        }

        if (found) {
            if(dataFile.delete())
            {
                tempFile.renameTo(dataFile);
                JOptionPane.showMessageDialog(null, "Booking deleted successfully.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Booking number not found.");
            tempFile.delete();
        }
    }

}
