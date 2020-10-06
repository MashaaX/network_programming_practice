/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jobsheet5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class TugasController {

    private tugas view;
    private List<Integer> list = new ArrayList<>();

    public TugasController(tugas view) {
        this.view = view;
        this.view.getjButtonBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
         this.view.getjButtonSimpan().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 save();
             }
         });
    }

     private void proses() {
              JFileChooser loadFile = view.getLoadFile();
             StyledDocument doc = view.getjTextPane().getStyledDocument();
             if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
                 BufferedInputStream reader = null;
                 try {
                     reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
                     doc.insertString(0, "", null);
                     int temp = 0;
                     List<Integer> list = new ArrayList<>();
                     while ((temp=reader.read()) != -1) {                    
                         list.add(temp);
                     }
                     int countword = 0;
                    char ascii;
                    String word;
                    int countchar = 0;
                    int lines = 0;
                     LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
                     while ((word = lineNumberReader.readLine()) != null) {
                     
                     String[] wording = word.split("\\s+");
                     System.out.println("" + word + " at line " + lineNumberReader.getLineNumber());
                     
                     countword += wording.length;
                     countchar += word.length();
                 }
                     lines += lineNumberReader.getLineNumber(); 
                     if (!list.isEmpty()) {
                         byte[] dt = new byte[list.size()];
                         int i = 0;
                         for (Integer integer : list) {
                             dt[i]=integer.byteValue();
                             i++;
                         }
                         doc.insertString(doc.getLength(), new String(dt), null);
                         JOptionPane.showMessageDialog(view, "File berhasil dibaca\n"
                                 + "Numbers of line : " + lines 
                                 + "\nNumber of Word : " + countword 
                                 + "\nNumber of Char : " + countchar, "Informasi", JOptionPane.INFORMATION_MESSAGE);
                     }
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException | BadLocationException ex) {
                     Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                 } finally {
                     if (reader != null) {
                         try {
                             reader.close();
                         } catch (IOException ex) {
                             Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                 }
             }
     }

     private void save() {
         JFileChooser loadFile = view.getLoadFile();
         if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
             BufferedOutputStream writer = null;
             try {
                 String contents = view.getjTextPane().getText();
                 if (contents != null && !contents.isEmpty()) {
                     writer = new BufferedOutputStream(new FileOutputStream(loadFile.getSelectedFile()));
                     writer.write(contents.getBytes());
                     JOptionPane.showMessageDialog(view, "File berhasil ditulis.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                 }

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (writer != null) {
                     try {
                         writer.flush();
                         writer.close();
                         view.getjTextPane().setText("");
                     } catch (IOException ex) {
                         Logger.getLogger(TugasController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         }
     }

}
