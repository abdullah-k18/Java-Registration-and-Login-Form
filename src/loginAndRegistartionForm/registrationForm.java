package loginAndRegistartionForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registrationForm extends JFrame implements ActionListener   {
   JLabel Label1, Label2, Label3, Label4, Label5, Label6, Label7;  //all labels for textField
    JTextField textField_Name, textField_Email, textField_Username, textField_PhoneNumber;   // others fields
    JButton btn_Register;  //buttons for signup and clear
    JPasswordField passwordField_1, passwordField_2;  // password fields
    File f = new File("C:\\Files");
    int ln;
   
    
    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\logins.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
               // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    void addData(String usr,String pswd,String mail,String con,String state,String Phn){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;i<ln;i++){
                raf.readLine();
            }
            //if condition added after video to have no lines on first entry
            if(ln>0){
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            }
            raf.writeBytes("Email:"+mail+ "\r\n");
            raf.writeBytes("Password:"+pswd+ "\r\n");
            raf.writeBytes("Username:"+usr+ "\r\n");
            raf.writeBytes("Country:"+con+ "\r\n");
            raf.writeBytes("State:"+state+ "\r\n");
            raf.writeBytes("Phone No:"+Phn);
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void countLines(){
        try {
            ln=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                ln++;
            }
            System.out.println("number of lines:"+ln);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    registrationForm()  
    {  
        setVisible(true);  
        setSize(700, 700);  
        getContentPane().setLayout(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Label1 = new JLabel("REGISTRATION");  
        Label1.setForeground(Color.BLACK);  
        Label1.setFont(new Font("Serif", Font.BOLD, 30));
        Label1.setBounds(206, 11, 400, 48);
        getContentPane().add(Label1);
        
        Label2 = new JLabel("Name");  
        Label2.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label2.setBounds(80, 70, 200, 30);
        getContentPane().add(Label2);
        
        Label3 = new JLabel("Email");  
        Label3.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label3.setBounds(80, 110, 200, 30);  
        getContentPane().add(Label3);
        
        Label4 = new JLabel("Passowrd");  
        Label4.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label4.setBounds(80, 150, 200, 30);
        getContentPane().add(Label4);
        
        Label5 = new JLabel("Confirm Password");  
        Label5.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label5.setBounds(80, 190, 200, 30);
        getContentPane().add(Label5);
        
        Label6 = new JLabel("Username");  
        Label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label6.setBounds(80, 230, 200, 30);
        getContentPane().add(Label6);
        
        Label7 = new JLabel("Phone Number");   
        Label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        Label7.setBounds(80, 271, 200, 30);
        getContentPane().add(Label7);
        
        textField_Name = new JTextField();  
        textField_Name.setBounds(300, 70, 200, 30);
        getContentPane().add(textField_Name);
        
        textField_Email = new JTextField();
        textField_Email.setBounds(300, 110, 200, 30);
        getContentPane().add(textField_Email);
        
        passwordField_1 = new JPasswordField();  
        passwordField_1.setBounds(300, 150, 200, 30);  
        getContentPane().add(passwordField_1);
        
        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(300, 190, 200, 30);
        getContentPane().add(passwordField_2);
        
        textField_Username = new JTextField();
        textField_Username.setBounds(300, 230, 200, 30);
        getContentPane().add(textField_Username);
        
        textField_PhoneNumber = new JTextField();
        textField_PhoneNumber.setBounds(300, 271, 200, 30);
        getContentPane().add(textField_PhoneNumber);
        
        btn_Register = new JButton("Register");
        btn_Register.addActionListener(this);
        btn_Register.setBounds(400, 312, 100, 30);
        getContentPane().add(btn_Register);
    }  
    public void actionPerformed(ActionEvent e)   
    {  
        if (e.getSource() == btn_Register)  
         {  
            int x = 0;  
            String s1 = textField_Name.getText();  
            String s2 = textField_Email.getText();  
            char[] s3 = passwordField_1.getPassword();  
            char[] s4 = passwordField_2.getPassword();   
            String s8 = new String(s3);  
            String s9 = new String(s4);  
            String s5 = textField_Username.getText();
            String s7 = textField_PhoneNumber.getText();  
            if (s8.equals(s9))  
            {  
                try  
                {  
                   createFolder();
                   readFile();
                   countLines();
                   addData(s1,s8,s2,s5,s7);
                       
                     
                        JOptionPane.showMessageDialog(btn_Register, "Registration Successful");   
                }  
                catch (Exception ex)   
                {  
                    System.out.println(ex);  
                }  
            }  
            else  
            {  
                JOptionPane.showMessageDialog(btn_Register, "Password Does Not Match");  
            }   
          }   
          else  
          {  
            textField_Name.setText("");  
            textField_Email.setText("");  
            passwordField_1.setText("");  
            passwordField_2.setText("");  
            textField_Username.setText("");
            textField_PhoneNumber.setText("");  
          }  
    } 
    private void addData(String s1, String s8, String s2, String s5, String s7) {
		// TODO Auto-generated method stub
		
	}

	public static void NewScreen()  
    {
    }  

}