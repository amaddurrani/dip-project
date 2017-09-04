/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dip;

/**
 *
 * @author amada
 */
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Dip {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
       BufferedImage img = null;
       File f;
       try
       {
           JFileChooser j = new JFileChooser();
           j.showOpenDialog(j);
           String a =j.getSelectedFile().toString();
           System.out.println(a);
           f = new File(a);
           img= ImageIO.read(f);
       }
       catch(IOException e)
       {
           System.out.println(e);
       }
       int width = img.getWidth();
       int height = img.getHeight();
       for(int y=0; y<height;y++)
           for(int x=0;x<width;x++)
           {
               int p= img.getRGB(x, y);
               
               
               int a= (p>>24)&0xff;
               //int r= (p>>16)&0xff;
               int g=(p>>8)&0xff;
               int b= p&0xff;
              
               
               int avg=(g+b)/2;
               
               p= (a<<24) | (avg<<16) | (avg<<8) |avg;
               
               img.setRGB(x, y, p);
           }
//    try
//    {
        JFrame J = new JFrame("output");
          J.setSize(img.getWidth(),img.getHeight());
        JLabel jp = new JLabel();
        ImageIcon i = new ImageIcon(img);
        jp.setSize(img.getWidth(),img.getHeight());
        jp.setIcon(i);
        J.add(jp);
        J.setVisible(true);
      J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        f= new File("C:\\Users\\amada\\Desktop\\output.jpg");
//        ImageIO.write(img, "jpg", f);
//    }
//    catch(IOException e)
//    {
//           System.out.println(e);
//    }   
    }
}
