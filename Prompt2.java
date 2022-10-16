import java.awt.*;
import java.awt.event.*;

//Prompt2 is similar to Prompt, used for displaying options that user can pick from
public class Prompt2 extends Frame{
	private Label label = new Label("Choose a button");
    
    public Prompt2(){
	this.setLayout(new FlowLayout());

	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent evt) {
		    ((Frame)(evt.getSource())).dispose();
		}
	    });	
    }

    public void activate(Button button1, Button button2, Button button3, Button button4, Button button5){
		this.add(label);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.pack(); // Resizes to tightly fit all its components
		this.setLocationRelativeTo(null); // Centers the window on the screen
		this.setVisible(true);
    }
	
    public void activate(Button button1, Button button2){
        this.add(label);
        this.add(button1);
        this.add(button2);
        this.pack();
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);
    }

}
