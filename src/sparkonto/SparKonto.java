/*
SparKonto ist ein app, mit dem man seine Ersparnis berechnen kann.
Es berechnet den Schlusssaldo oder die monatliche Einzahlung wenn die anderen Daten eingegeben ist
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
 JButton anzahlmonateButton = new JButton();
 JButton schlusssaldoButton = new JButton();
 JLabel erklarungLabel = new JLabel();
 JTextArea erklarungTextArea = new JTextArea();
 
 Font meinFont = new Font("Arial", Font.PLAIN, 16);
 Color lightYellow = new Color(255, 255, 128);
 boolean schlusssaldoBerechnen;
 
    public static void main(String[] args) {
        
        // Erschaffung des Frames
        new SparKonto().show();
        
    }
     public SparKonto()
     {
         
      // Erstellung des Frames 
         setTitle("Ersparnis  Assistant"
                 + "");
         addWindowListener(new WindowAdapter()
         {
             public void windowClosing(WindowEvent e)
             { 
                 exitForm(e);
             }
         });
         
        // Der GridBagLayout ist hier benutzt  
         getContentPane().setLayout(new GridBagLayout());
         getContentPane().setBackground(new Color(204, 204, 204));
         
         
         GridBagConstraints gridPlatz = new GridBagConstraints();
         
         einzahlungLabel.setText("Monatliche Einzahlung");
         einzahlungLabel.setFont(meinFont);
         gridPlatz .gridx = 0;
         gridPlatz .gridy = 0;
         gridPlatz.anchor = GridBagConstraints.WEST;
         gridPlatz .insets = new Insets(30, 20, 0, 20);
         getContentPane().add(einzahlungLabel, gridPlatz );
         
         zinsenLabel.setText("Jährliche Zinszahlung");
         zinsenLabel.setFont(meinFont);
         gridPlatz .gridx = 0;
         gridPlatz .gridy = 1;
         gridPlatz.anchor = GridBagConstraints.WEST;
         getContentPane().add(zinsenLabel, gridPlatz );
         
         monateLabel.setText("Anzahl der Monate");
         monateLabel.setFont(meinFont);
         gridPlatz .gridx = 0;
         gridPlatz .gridy =2;
         gridPlatz.anchor = GridBagConstraints.WEST;
         getContentPane().add(monateLabel, gridPlatz );
         
        schlussLabel.setText("Schlusssaldo");
        schlussLabel.setFont(meinFont);
         gridPlatz .gridx = 0;
         gridPlatz .gridy =3;
         gridPlatz.anchor = GridBagConstraints.WEST;
         getContentPane().add(schlussLabel, gridPlatz );
         
         einzahlungTextField.setText("");
         einzahlungTextField.setColumns(10);
         einzahlungTextField.setPreferredSize(new Dimension(100, 25));
         einzahlungTextField.setHorizontalAlignment(SwingConstants.RIGHT);
         einzahlungTextField.setFont(meinFont);
         //einzahlungTextField.setBackground(new Color(102, 255, 102));
         einzahlungTextField.setForeground(Color.BLUE);
         gridPlatz .gridx = 1;
         gridPlatz .gridy = 0;
         gridPlatz.anchor = GridBagConstraints.NORTHWEST;
        // gridPlatz .insets = new Insets(30, 10, 0, 20);
         getContentPane().add(einzahlungTextField, gridPlatz );
         einzahlungTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 einzahlungTextFieldActionPerformed(e);
             }
         });
         
         zinsenTextField.setText("");
         zinsenTextField.setColumns(10);
         zinsenTextField.setPreferredSize(new Dimension(100, 25));
         zinsenTextField.setHorizontalAlignment(SwingConstants.RIGHT);
         zinsenTextField.setFont(meinFont);
         //zinsenTextField.setBackground(new Color(102, 255, 102));
         zinsenTextField.setForeground(Color.BLUE);
         gridPlatz .gridx = 1;
         gridPlatz .gridy = 1;
         gridPlatz.anchor = GridBagConstraints.NORTHWEST;
        // gridPlatz .insets = new Insets(25, 10, 0, 20);
         getContentPane().add(zinsenTextField, gridPlatz );
         zinsenTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 zinsenTextFieldActionPerformed(e);
             }
         });
         
         monateTextField.setText("");
         monateTextField.setColumns(10);
         monateTextField.setPreferredSize(new Dimension(100, 25));
         monateTextField.setHorizontalAlignment(SwingConstants.RIGHT);
         monateTextField.setFont(meinFont);
        // monateTextField.setBackground(new Color(102, 255, 102));
         gridPlatz .gridx = 1;
         gridPlatz .gridy = 2;
         gridPlatz.anchor = GridBagConstraints.NORTHWEST;
         //gridPlatz .insets = new Insets(30, 0, 10, 20);
         getContentPane().add(monateTextField, gridPlatz );
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
         schlussTextField.setPreferredSize(new Dimension(100, 25));
         schlussTextField.setHorizontalAlignment(SwingConstants.RIGHT);
         schlussTextField.setFont(meinFont);
         //schlussTextField.setBackground(new Color(102, 255, 102));
         //Hier entferne ich Das TransversalPolicy aus dem schlussTextField 
         schlussTextField.setFocusable(true);
         gridPlatz .gridx = 1;
         gridPlatz .gridy = 3;
         //gridPlatz.anchor = GridBagConstraints.NORTHWEST;
         //gridPlatz .insets = new Insets(0, 20, 0, 20);
         getContentPane().add(schlussTextField, gridPlatz );
         schlussTextField.setForeground(Color.BLUE);
         schlussTextField.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 schlussTextFieldActionPerformed(e);
             }
         });
         
         
         berechnenButton.setText("Berechnen");
       //rechnenButton.setBackground(Color.ORANGE);
         gridPlatz .gridx = 0;
         gridPlatz .gridy = 5;
         // gridPlatz.gridwidth =2;
         gridPlatz.anchor = GridBagConstraints.SOUTHEAST;
        gridPlatz .insets = new Insets(20, 0, 10, 0);
         getContentPane().add(berechnenButton, gridPlatz );
         berechnenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 berechnenButtonActionPerformed(e);
             }
         });
                 
         
        beendenButton.setText("Beenden");
        beendenButton.setFocusable(false);
        //beendenButton.setBackground(Color.CYAN);
         gridPlatz .gridx = 2;
         gridPlatz .gridy = 5;
        
         gridPlatz.anchor = GridBagConstraints.SOUTHWEST;
        // gridPlatz .insets = new Insets(10, 0, 10, 0);
         getContentPane().add(beendenButton, gridPlatz );
         beendenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 beendenButtonActionPerformed(e);
             }
         });
         
         loschenButton.setText("Reset");
         loschenButton.setFocusable(false);
         loschenButton.setEnabled(false);
        // loschenButton.setBackground(Color.GREEN);
        gridPlatz .gridx = 1;
         gridPlatz .gridy = 5;
        // gridPlatz.gridwidth =2;
         
         gridPlatz.anchor = GridBagConstraints.SOUTH;
         //gridPlatz .insets = new Insets(10, 0, 10, 0);
         getContentPane().add(loschenButton, gridPlatz );
         loschenButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 loschenButtonActionPerformed(e);
             }
             
         });
         
         anzahlmonateButton.setText("M");
         gridPlatz.gridx = 2;
         gridPlatz.gridy= 2;
         gridPlatz.anchor = GridBagConstraints.SOUTHWEST;
         gridPlatz.insets = new Insets(5, 20, 0, 20);
         getContentPane().add(anzahlmonateButton, gridPlatz);
         anzahlmonateButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {             
                     anzahlmonateButtonActionPerformed(e);
                 }
              });
         schlusssaldoButton.setText("S");
         gridPlatz.gridx = 2;
         gridPlatz.gridy= 3;
         gridPlatz.anchor = GridBagConstraints.CENTER;
         gridPlatz.anchor = GridBagConstraints.SOUTHWEST;
         //gridPlatz.insets = new Insets(15, 0, 0 , 0);
         getContentPane().add(schlusssaldoButton, gridPlatz);
         schlusssaldoButton.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {             
                     schlusssaldoButtonActionPerformed(e);
                 }
              });
         erklarungLabel.setText("Analysis:");
         erklarungLabel.setFont(meinFont);
         gridPlatz = new GridBagConstraints();
         gridPlatz.gridx = 3;
         gridPlatz.gridy = 0;
         gridPlatz.anchor = GridBagConstraints.WEST;
         gridPlatz.insets = new Insets( 30, 10, 0,0);
         getContentPane().add(erklarungLabel, gridPlatz);
         
         erklarungTextArea.setPreferredSize(new Dimension(250, 150));
         erklarungTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         erklarungTextArea.setFont(new Font("Courrier New", Font.PLAIN, 14));
         erklarungTextArea.setEditable(false);
         erklarungTextArea.setBackground(Color.white);
         gridPlatz = new GridBagConstraints();
         gridPlatz.gridx = 3;
         gridPlatz.gridy = 1;
         gridPlatz.gridheight = 4;
         gridPlatz.insets = new Insets(0, 10, 0, 10);
         getContentPane().add(erklarungTextArea, gridPlatz);
         
         
         pack();   
         
         // Mit diesem QuelleText wird das Fenster in Bildschirmmitte erscheinen
         Dimension bildschirmgröße = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (0.5*(bildschirmgröße.width - getWidth())), (int) (0.5*(bildschirmgröße.height - getHeight())), getWidth(), getHeight());
         
        schlusssaldoButton.doClick();
     }
         
     private void berechnenButtonActionPerformed(ActionEvent e)
     {
         // Initiation der Variable Einzahlung, Zinsen, Monate, Sclusssaldo, MonatlichenZinsen
         double einzahlung;
         double zinsen;
         double monate;
         double schlusssaldo;
         double monatlichenZinsen;
         double finaleBerechnung, intChange;
         int intDirection;
         loschenButton.setEnabled(true);
         
    /*Eingabe validierung.
    Bestimmen welche Daten fehlt un dann das fehlende Daten rechnen */
    
    if (einzahlungTextField.getText().equals(""))
            {
                 // Eingabe Validierung
                if (!validateDecimalNumber(monateTextField) ||
                    !validateDecimalNumber(zinsenTextField) ||
                    !validateDecimalNumber(schlussTextField))
                
                {
                     // Wenn ein oder mehr Felder kein valid Nummer hat, dann Program beenden
                    return;
                }
              
                
        zinsen = Double.valueOf(zinsenTextField.getText()).doubleValue();
        monatlichenZinsen = zinsen / 1200;
        monate = Double.valueOf(monateTextField.getText()).doubleValue();
        schlusssaldo = Double.valueOf(schlussTextField.getText()).doubleValue();
       
        if (zinsen == 0)
        {
            einzahlung = schlusssaldo / monate;
                }
        else
        {
            einzahlung = schlusssaldo / ((Math.pow((1 + monatlichenZinsen), monate)-1)/monatlichenZinsen);
        }
                     
        einzahlungTextField.setText(new DecimalFormat("0.00").format(einzahlung));
       
            }
        else if (zinsenTextField.getText().trim().equals(""))
    {
        /*Wenn es kein Zinsenwert 
        intChange = wie andert sich das zinsen
        intDirection = erhöhung oder verringerung
        Andere Werte benutzen      */  
        
      
        if (!validateDecimalNumber(monateTextField) || 
            !validateDecimalNumber(einzahlungTextField) ||
             !validateDecimalNumber(schlussTextField))
        { 
            return;
        }
        
        einzahlung = Double.valueOf(einzahlungTextField.getText()).doubleValue();
        monate = Double.valueOf(monateTextField.getText()).doubleValue();
        schlusssaldo = Double.valueOf(schlussTextField.getText()).doubleValue();
        
        zinsen = 0;
        intChange = 1;
        intDirection = 1;
        do
        {
            zinsen += intDirection*intChange;
            monatlichenZinsen = zinsen / 1200;
            finaleBerechnung = einzahlung*(Math.pow((1 + monatlichenZinsen), monate)-1) / monatlichenZinsen;
            if(intDirection == 1)
            {           
                if(finaleBerechnung > schlusssaldo)
                {
                    intDirection = -1;
                    intChange /= 10;
                }
            }
                else 
                {
                        if(finaleBerechnung < schlusssaldo)
                            {
                                intDirection = 1;
                                intChange /= 10;
                            }
                        }
                }
        
                while (Math.abs(finaleBerechnung- schlusssaldo) >= 0.005);
                zinsenTextField.setText(new DecimalFormat("0.00").format(zinsen));
        } 
                 else if (monateTextField.getText().trim().equals(""))
                 {
                if (!validateDecimalNumber(einzahlungTextField) ||
                    !validateDecimalNumber(zinsenTextField) ||
                    !validateDecimalNumber(schlussTextField))
                {
                    return;
                }
                
                // Brechnung von derAnzahl der Monate
            einzahlung = Double.valueOf(einzahlungTextField.getText()).doubleValue();
            zinsen = Double.valueOf(zinsenTextField.getText()).doubleValue();
            monatlichenZinsen = zinsen/1200;
            schlusssaldo = Double.valueOf(schlussTextField.getText()).doubleValue();
            if (zinsen == 0)
            {
                monate = schlusssaldo / einzahlung;
            }
            else
            {
                monate = Math.log(schlusssaldo* monatlichenZinsen / einzahlung +1) / Math.log(1 + monatlichenZinsen);
            }
            
           monateTextField.setText(new DecimalFormat("0.00").format(monate));
          
        // Analysis auf den Analysis TextFled zeigen
           
           erklarungTextArea.setText(" Total einzahlung: $" + new DecimalFormat("0.00").format(einzahlung));
           erklarungTextArea.append("\n" + " Jährlich Zinsen: " + zinsen + "%");
           erklarungTextArea.append("\n" + " Monatlichen Zinsen: " + new DecimalFormat("0.00").format(monatlichenZinsen) + "%");
           erklarungTextArea.append("\n" + " Schlusssaldo:  $" + new DecimalFormat("0.00").format(schlusssaldo));  
           erklarungTextArea.append("\n\n" + " Der gesamt Zins auf $" + new DecimalFormat("0.0").format(schlusssaldo - einzahlung ) + " habe ich");
           erklarungTextArea.append("\n" + " nach " + new DecimalFormat("0").format(monate) + " Monate Einsparung bekommt." );
                       
            }
                 
                 
     else if (schlussTextField.getText().trim().equals(""))
        {  
            // Berechnung von Schlusssaldo
        if(!validateDecimalNumber(monateTextField) || 
        !validateDecimalNumber(zinsenTextField) ||
        !validateDecimalNumber(einzahlungTextField))
         {
            
             return;
             
         }       
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
              erklarungTextArea.setText(" Einzahlung: $" + new DecimalFormat("0.00").format(einzahlung));
              erklarungTextArea.append("\n" + " Monatlichen Zinsen: " + new DecimalFormat("0.00").format(monatlichenZinsen) + "%");
              erklarungTextArea.append("\n" + " Dauer : " +  new DecimalFormat("0").format(monate) + " Monate");
              erklarungTextArea.append("\n" + " Total Einzahlung : $ " + einzahlung*monate );
              erklarungTextArea.append("\n\n" + " Mein Schlusssaldo ist  $" + new DecimalFormat("0.00").format(schlusssaldo));
              erklarungTextArea.append("\n" + " Ich habe $" + new DecimalFormat("0.00").format(schlusssaldo-einzahlung) + " Zins bekomt." );
              
             
             
        }
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
    
    private void schlusssaldoButtonActionPerformed(ActionEvent e)
    {
        //Schlusssaldo berechnen
         schlusssaldoBerechnen  = true;
         schlusssaldoButton.setVisible(false);
         monateTextField.setEditable(true);
         monateTextField.setBackground(Color.WHITE);
         einzahlungTextField.setText("");
          zinsenTextField.setText("");
          monateTextField.setText("");
          schlussTextField.setText("");
         schlussTextField.setBackground(lightYellow);
         berechnenButton.setText("Schlussaldo");
         anzahlmonateButton.setVisible(true);
         schlussTextField.setFocusable(false);
         monateTextField.setFocusable(true);
    }
    
    private void anzahlmonateButtonActionPerformed(ActionEvent e)
    {
        // Anzahl monate berechnen
        schlusssaldoBerechnen = false;
        schlusssaldoButton.setVisible(true);
        anzahlmonateButton.setVisible(false);
        monateTextField.setText("");
        schlussTextField.setText("");
        zinsenTextField.setText("");
        einzahlungTextField.setText("");
        schlussTextField.setEditable(true);
        schlussTextField.setBackground(Color.WHITE);
        monateTextField.setBackground(lightYellow);
        berechnenButton.setText("Anzahl Monate");
        monateTextField.setFocusable(false);
        schlussTextField.setFocusable(true);
        erklarungTextArea.setText("");
        loschenButton.setEnabled(false);
        
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
         erklarungTextArea.setText("");
     }
}