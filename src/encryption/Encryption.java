/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
 

/**
 *
 * @author KOTRESHA
 */
public class Encryption extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fframe f1=new fframe();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2;i<=600;i+=4,x+=1)
        {
            f1.setLocation(800-((i+x)/2),500-(i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }
            catch(Exception e){}
            
        }
    }
    
}
class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        super("Digital Encryption System");
        setLayout(new FlowLayout());
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("pic/logo.jpg"));
        Image i1=c1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        
        JLabel l1=new JLabel(i2);
        add(l1);
        JLabel l2=new JLabel("WELCOME");
                l2.setBounds(50,-200,1200,500);
                l2.setForeground(Color.WHITE);
                l2.setFont(new Font("serif",Font.PLAIN,80));
                l1.add(l2);
        t1=new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(4000);
            this.setVisible(false);
            dashboard l=new dashboard();
            l.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}