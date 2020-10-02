/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_filter_stream_practice;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rizky
 */
public class ReadInputKeyboard {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Masukan karakter apapun, [tekan keluar ketik `q`]: ");
        String input = null;
        do {
            input = scan.nextLine();
            System.out.println("" + input);
        } while (!input.equalsIgnoreCase("q"));
    }

}
