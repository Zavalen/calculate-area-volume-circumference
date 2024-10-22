/*
Zava
CS2050
Program2
02/08/2024
 */

import java.io.*;
import java.util.Scanner;

public class Program2 {

    // User input for file name
    static String userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file name");

        String fileName = scanner.nextLine();

        return fileName;
    }

    // Method determining number of lines
    static int numLines(String fileName) {
        int numInt = 0;
        int numLines = 0;

        try {
            File numFile = new File(fileName);
            Scanner myReader = new Scanner(numFile);
            while(myReader.hasNextInt()) {
                numInt++;
                myReader.nextInt();
            }
            numLines = numInt/2;
            myReader.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("Unable to find the file correctly :'(");
            e.printStackTrace();

        }

        return numLines;

    }

    // Creates/resets Program2.out
    static void pOut() {
        try {
            File out = new File("Program2.out");
            if (out.createNewFile()) {
                System.out.println("Created the file: Program2.out");
            }
            else {
                System.out.println("Already have existing file: Program2.out");
                out.delete();
                out.createNewFile();
                System.out.println("Created a new file: Program2.out");
            }

        }

        catch(IOException e) {
            System.out.println("Error in creating/deleting the file");
        }

    }

    public static void main(String[] args) {

        String fileName = userInput();
        Geometry shapes[] = new Geometry[numLines(fileName)];

        try {
            File numFile = new File(fileName);
            Scanner myReader = new Scanner(numFile);
            for (int i = 0; i < shapes.length; i++) {
                int radius = myReader.nextInt();
                int height = myReader.nextInt();
                shapes[i] = new Geometry(radius, height);

            }
            myReader.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("Unable to find the file correctly :'(");
            e.printStackTrace();

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("A line is missing the other half from the pair of numbers");
            e.printStackTrace();
        }
        pOut();

        try {
            FileWriter fw = new FileWriter("Program2.out");
            fw.write(String.format("%-9s%-13s%-22s%-17s%-7s%n","radius","height", "circumference", "area", "volume"));

            for(int i =0; i < shapes.length; i++) {
                fw.write(String.format("%s%4.2f%8.2f%16.4f%20.4f%20.4f %n", " ",
                        shapes[i].getRadius(),
                        shapes[i].getHeight(),
                        shapes[i].getCircumference(),
                        shapes[i].getArea(),
                        shapes[i].getVolume()));
            }
            fw.close();
        }
        catch(IOException e) {
            System.out.println("Trouble trying to write to Program2.out");
            e.printStackTrace();
        }


    }
}