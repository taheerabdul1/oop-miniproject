import java.awt.*;
import java.awt.event.*;

//frame that sets the main class up
public class DashboardFrame extends Frame{
    //buttons are placed together
    private Panel buttonsPanel; 
    //messages are printed here
    private static TextArea textArea = new TextArea("");
    
    //constructor
    public DashboardFrame(){
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt) {
                ((Frame)(evt.getSource())).dispose();
            }
        });	
    }

    //creates frame
    public void activate(Button button1, Button button2, Button button3, Button button4, Button button5, Button button6){
        //these all set out the window 
        this.setLayout(new FlowLayout());
        this.setSize(550,250);
        this.setLocationRelativeTo(null);
        textArea.setBounds(100, 300, 300, 100);
        this.add(textArea);
        textArea.setEditable(false);
        buttonsPanel = new Panel();        
        this.add(buttonsPanel);
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setVisible(true);
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        this.setVisible(true);
    }

    public static void setTextArea(String text){
        textArea.setText(text);
    }
}
