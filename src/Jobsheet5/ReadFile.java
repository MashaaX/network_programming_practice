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
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Asus
 */

//Edited for Praktikum 1 Question 1 and 2

public class ReadFile {

    public static void main(String[] args) {
        try {
            int desimal;
            char ascii;
            int paragraph = 1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Input The File Destination");
            System.out.println("For Example : E:/TUGAS/Jarkom/Semester 5/Stream/JavaLibrary5/Coba.txt");
            System.out.println("Destination : ");
            String input = sc.nextLine();
            LineNumberInputStream inputStream = new LineNumberInputStream(new FileInputStream(input));
            while ((desimal = inputStream.read()) != -1) {
                ascii = (char) desimal;
                System.out.println("" + ascii + " at line " + inputStream.getLineNumber());
                
            }
            paragraph += inputStream.getLineNumber(); 
            
            System.out.println("Lines total : " + paragraph);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
