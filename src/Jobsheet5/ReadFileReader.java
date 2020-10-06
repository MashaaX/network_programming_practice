/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobsheet5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Asus
 */
public class ReadFileReader {
    public static void main(String[] args) {
        try {
                 int countword = 0;
                 char ascii;
                 String word;
                 int countchar = 0;
                 int paragraph = 0;

                 LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("Coba.txt"));
                 while ((word = lineNumberReader.readLine()) != null) {
                     
                     String[] wording = word.split("\\s+");
                     System.out.println("" + word + " at line " + lineNumberReader.getLineNumber());
                     
                     countword += wording.length;
                     countchar += word.length();
                     
                 }
                 paragraph += lineNumberReader.getLineNumber();
                 System.out.println("Word Count : " + countword);
                 System.out.println("Character Count : " + countchar);
                 System.out.println("Lines Count : " + paragraph);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(ReadFileReader.class.getName()).log(Level.SEVERE, null, ex);
             }
    }
}
