/*
SparKonto ist ein app, mit dem man seine Ersparnis berechnen kann.
 */
/*
Sparkonto berechnen den Schlusssaldo einer Einzahlung mit x Zinsen und x Monateeiner
 */
package sparkonto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class SparKonto extends JFrame {
 JLabel einzahlungLabel = new JLabel();
 JLabel zinsenLabel = new JLabel();
 JLabel monateLabel = new JLabel();
 JLabel schlussLabel = new JLabel();
 JTextField einzahlungTextField = new JTextField();
JTextField zinsenTextField = new JTextField();
 JTextField  monateTextField = new JTextField();
 JTextField schlussTextField = new JTextField();
 JButton berechnenButton = new JButton();
 JButton beendenButton = new JButton();
 JButton loschenButton = new JButton();
 
 
    public static void main(String[] args) {
        
        // Erschaffung des Frames
        new SparKonto().show();
        
    }
     public SparKonto()
     {
         
      // Erstellung des Frames 
         setTitle("SparKonto");
         addWindowListener(new WindowAdapter()
         {
             public void windowClosing(WindowEvent e)
             { 
                 exitForm(e);
             }
         });
         
        // Der GridBagLayout ist hier benutzt  
         getContentPane().setLayout(new GridBagLayout());
         getContentPane().setBackground(Color.LIGHT_GRAY);
         
         
         GridBagConstraints gridBedingung = new GridBagConstraints();
         
         einzahlungLabel.setText("Monatliche Einzahlung");
         gridBedingung.gridx = 0;
         gridBedingung.gridy = 0;
         getContentPane().add(einzahlungLabel, gridBedingung);
         
         zinsenLabel.setText("Jährliche Zinszahlung");
         gridBedingung.gridx = 0;
         gridBedingung.gridy = 1;
         getContentPane().add(zinsenLabel, gridBedingung);
         
         monateLabel.setText("Anzahl der Monate");
         gridBedingung.gridx = 0;
         gridBedingung.gridy =2;
         getContentPane().add(monateLabel, gridBedingung);
         
        schlussLabel.setText("Schlusssaldo");
         gridBedingung.gridx = 0;
         gridBedingung.gridy =3;
         getContentPane().add(schlussLabel, gridBedingung);
         
         einzahlungTextField.setText("");
         einzahlungTextField.setColumns(10);
         einzahlungTextField.setBackground(Color.LIGHT_GRAY);
         einzahlungTextField.setForeground(Color.BLUE);
         gridBedingung.gridx = 2;
         gridBedingung.gridy = 0;
         getContentPane().add(einzahlungTextField, gridBedingung);
         einzahlungTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 einzahlungTextFieldActionPerformed(e);
             }
         });
         
         zinsenTextField.setText("");
         zinsenTextField.setColumns(10);
         zinsenTextField.setBackground(Color.LIGHT_GRAY);
         zinsenTextField.setForeground(Color.BLUE);
         gridBedingung.gridx = 2;
         gridBedingung.gridy = 1;
         getContentPane().add(zinsenTextField, gridBedingung);
         zinsenTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 zinsenTextFieldActionPerformed(e);
             }
         });
         
         monateTextField.setText("");
         monateTextField.setColumns(10);
         monateTextField.setBackground(Color.LIGHT_GRAY);
         gridBedingung.gridx = 2;
         gridBedingung.gridy = 2;
         getContentPane().add(monateTextField, gridBedingung);
         monateTextField.setForeground(Color.BLUE);
         monateTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 zinsenTextFieldActionPerformed(e);
             }
         });
         
         schlussTextField.setText("");
         schlussTextField.setColumns(10);
         schlussTextField.setBackground(Color.LIGHT_GRAY);
         //Hier entferne ich Das TransversalPolicy aus dem schlussTextField 
         schlussTextField.setFocusable(true);
         gridBedingung.gridx = 2;
         gridBedingung.gridy = 3;
         getContentPane().add(schlussTextField, gridBedingung);
         schlussTextField.setForeground(Color.BLUE);
         schlussTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 schlussTextFieldActionPerformed(e);
             }
         });
         
         
         berechnenButton.setText("Berechnen");
         berechnenButton.setBackground(Color.ORANGE);
         gridBedingung.gridx = 0;
         gridBedingung.gridy = 5;
         getContentPane().add(berechnenButton, gridBedingung);
         berechnenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 berechnenButtonActionPerformed(e);
             }
         });
                 
         
        beendenButton.setText("Beenden");
        beendenButton.setFocusable(false);
        beendenButton.setBackground(Color.CYAN);
         gridBedingung.gridx = 2;
         gridBedingung.gridy = 5;
         getContentPane().add(beendenButton, gridBedingung);
         beendenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 beendenButtonActionPerformed(e);
             }
         });
         
         loschenButton.setText("Löschen");
         loschenButton.setFocusable(false);
         loschenButton.setBackground(Color.GREEN);
         gridBedingung.gridx = 1;
         gridBedingung.gridy = 5;
         getContentPane().add(loschenButton, gridBedingung);
         loschenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 loschenButtonActionPerformed(e);
             }
             
         });
         
         pack();
         
         
     }
     private void berechnenButtonActionPerformed(ActionEvent e)
     {
         // Initiation der Variable Einzahlung, Zinsen, Monate, Sclusssaldo, MonatlichenZinsen
         double einzahlung;
         double zinsen;
         double monate;
         double schlusssaldo;
         double monatlichenZinsen;
         
        
         
         // Eingabe Validierung
         
         if(!validateDecimalNumber(monateTextField) || 
            !validateDecimalNumber(zinsenTextField) ||
            !validateDecimalNumber(einzahlungTextField))
         {
             // Wenn ein oder mehr Felder nich valid Nummer hat, dann Method beenden
             return;
             
         }
         
          /* Benutzung der Werte von TextFields. Diese Werte werden in
         Double umwandelen.
         */
         
              einzahlung = Double.valueOf(einzahlungTextField.getText()).doubleValue();
              zinsen = Double.valueOf(zinsenTextField.getText()).doubleValue();
              monatlichenZinsen = zinsen/1200;
              monate = Double.valueOf(monateTextField.getText()).doubleValue();
         
              // Berechnung von Schlusssaldo, den wird dannach im TextField eingefugt
              if(zinsen == 0)
              {
                  schlusssaldo = einzahlung * monate;
              }
              else
              {
              schlusssaldo = einzahlung * (Math.pow((1 + monatlichenZinsen), monate) -1)/ monatlichenZinsen;
              }
              
              schlussTextField.setText(new DecimalFormat("0.00").format(schlusssaldo));
              
        }
      
    
    private void beendenButtonActionPerformed(ActionEvent e)
    {
    System.exit(0);
    }
    private void einzahlungTextFieldActionPerformed(ActionEvent e)
    {
        einzahlungTextField.transferFocus();
    }
    
    private void zinsenTextFieldActionPerformed(ActionEvent e)
    {
        zinsenTextField.transferFocus();
    }
    
    private void monateTextFieldActionPerformed(ActionEvent e)
    {
        monateTextField.transferFocus();
    }
    
    
    private void schlussTextFieldActionPerformed(ActionEvent e)
    {
        schlussTextField.transferFocus();
    }
    
    private void exitForm(WindowEvent e)
    {
    System.exit(0);
    }
    
     public boolean validateDecimalNumber(JTextField tf)
     {
         // Hier prüfe ich, ob die TextFeldern valid Nummer mit lediglich Ziffer und einzige Dezimalpunkt
        String s = tf.getText().trim();
        boolean hatDezimal = false;
        boolean valid = true;
        if(s.length() == 0)
        {
            valid = false;
        }
        else
        {
            for(int i=0; i<s.length(); i++)
            {
                char c = s.charAt(i);
                if(c>='0' && c<='9')
                {
                    continue;
                }
                else if (c == '.' && !hatDezimal)
                {
                    hatDezimal = true;
                }
                else
                {
                    // ungültige Zeichen gefunden
                    valid = false;
                }
            }
        }
            if(valid)
            {
            tf.setText(s);
        }
        else
        {
                tf.setText("");
                tf.requestFocus();
                }
        return(valid);
     }
     
     private void loschenButtonActionPerformed(ActionEvent e)
     {
         // die Inhalte der TextFields löschen
         einzahlungTextField.setText("");
         zinsenTextField.setText("");
         monateTextField.setText("");
         schlussTextField.setText("");
         einzahlungTextField.requestFocus();
     }
}