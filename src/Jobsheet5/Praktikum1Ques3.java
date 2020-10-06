/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobsheet5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */


public class Praktikum1Ques3 {
    public static void main(String[] args) {
      try {
            int desimal;
            char ascii;
            int paragraph = 1;
            Scanner charac = new Scanner(System.in);
            Scanner directory = new Scanner(System.in);
            
            System.out.print("Character that you want to find : ");
            char character = charac.next().charAt(0);
            
            System.out.println("Input The File Destination");
            System.out.println("For Example : E:/TUGAS/Jarkom/Semester 5/Stream/JavaLibrary5/Coba.txt");
            System.out.print("Destination : ");
            String input = directory.nextLine();
            
            LineNumberInputStream inputStream = new LineNumberInputStream(new FileInputStream(input));
            while ((desimal = inputStream.read()) != -1) {
                ascii = (char) desimal;             
                if ( ascii == character) {
                    System.out.println("" + character + " at line " + inputStream.getLineNumber());
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
