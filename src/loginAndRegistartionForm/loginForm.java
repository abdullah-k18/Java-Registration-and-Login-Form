package loginAndRegistartionForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class loginForm extends JFrame implements ActionListener {

    JLabel label1, label2, label3;   //label for email and password

    JTextField textField_Username; // email field

    JButton btn_Login; // login button

    JPasswordField passwordField; // password field

    File f = new File("C:\\Files");   //file path
    int ln;
    // create folder in which record is save
    void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }
    //check file is exist or not
    void readFile() {
        try {
            FileReader fr = new FileReader(f + "\\logins.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
            }
        }

    }
    // login logic 
    void logic(String usr, String pswd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\logins.txt", "rw");
            for (int i = 0; i < ln; i += 7) {
                System.out.println("count " + i);

                String forUser = raf.readLine().substring(6);
                String forPswd = raf.readLine().substring(9);
                System.out.println(forUser + forPswd);
                if (usr.equals(forUser) & pswd.equals(forPswd)) {
                    JOptionPane.showMessageDialog(null, "Login Successfully!!");
                    break;
                } else if (i == (ln - 6)) {
                    JOptionPane.showMessageDialog(null, "incorrect username/password");
                    break;
                }
                for (int k = 1; k <= 5; k++) {
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }
    //count the number of lines from file
    void countLines() {
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f + "\\logins.txt", "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    loginForm() {

        setVisible(true);

        setSize(800, 800);

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("LOGIN");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setBounds(221, 29, 400, 30);
        getContentPane().add(label1);
        
        label2 = new JLabel("Username");
        label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        label2.setBounds(80, 70, 200, 30);
        getContentPane().add(label2);
        
        label3 = new JLabel("Password");
        label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        label3.setBounds(80, 110, 200, 30);
        getContentPane().add(label3);
        
        textField_Username = new JTextField();
        textField_Username.setBounds(300, 70, 200, 30);
        getContentPane().add(textField_Username);
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 110, 200, 30);
        getContentPane().add(passwordField);
        
        btn_Login = new JButton("Login");
        btn_Login.setBounds(400, 151, 100, 30);
        getContentPane().add(btn_Login);
        btn_Login.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        showData();

    }

    public void showData() {

        JFrame f1 = new JFrame();

        JLabel l, l0;

        String str1 = textField_Username.getText();

        char[] p = passwordField.getPassword();

        String str2 = new String(p);

        try {

            createFolder();
            readFile();
            countLines();
            logic(str1, str2);
            JOptionPane.showMessageDialog(btn_Login, "Login Successful");   

        } catch (Exception ex) {

            System.out.println(ex);

        }
    }
    public static void NewScreen() {

    }

}