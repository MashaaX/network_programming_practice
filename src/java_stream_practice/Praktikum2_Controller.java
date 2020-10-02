/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_stream_practice;

/**
 *
 * @author rizky
 */
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class Praktikum2_Controller {

    private final Praktikum1 view;
    private java.util.List<Integer> list = new ArrayList<>();

    public Praktikum2_Controller(Praktikum1 view) {
        this.view = view;
        this.view.getBtnSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        this.view.getBtnRead().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
    }

    private void save() {
        JFileChooser loadFile = view.getLoadFile();
        if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(view)) {
            BufferedWriter writer = null;
            try {
                String contents = view.getTxtPane().getText();
                if (contents != null && !contents.isEmpty()) {
                    writer = new BufferedWriter(new FileWriter(loadFile.getSelectedFile()));
                    writer.write(contents);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (writer != null) {
                    try {
                        writer.flush();
                        writer.close();
                        view.getTxtPane().setText("");
                        JOptionPane.showMessageDialog(view, "File Successfully Saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(view, "Failed to Save File!", "Failed", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }

    private void proses() {
        JFileChooser loadFile = view.getLoadFile();
        StyledDocument doc = view.getTxtPane().getStyledDocument();
        if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(view)) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(loadFile.getSelectedFile()));
                String data = null;
                doc.insertString(0, "", null);
                while ((data = reader.readLine()) != null) {
                    doc.insertString(doc.getLength(), data + "\n", null); // add "\n" where the line ends
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, "File Not Found!", "Failed", JOptionPane.WARNING_MESSAGE);
            } catch (IOException | BadLocationException ex) {
                Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Praktikum2_Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
