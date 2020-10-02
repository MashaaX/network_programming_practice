/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_stream_practice;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author rizky
 */
public class Praktikum1_Controller {

    private Praktikum1 view;
   private java.util.List<Integer> list=new ArrayList<>();

    public Praktikum1_Controller(Praktikum1 view) {
        this.view = view;
        this.view.getBtnRead().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
    }

    private void proses() {
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(loadFile.getSelectedFile());
                int read = inputStream.read();
                doc.insertString(0, "", null);
                while (read != -1) {
                    list.add(read);// tambahkan 1 baris
                    doc.insertString(doc.getLength(), "" + read, null);
                    System.out.println("" + read);
                    read = inputStream.read();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum1_Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(Praktikum1_Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum1_Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }
    
    
}
