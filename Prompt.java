import java.awt.*;
import java.awt.event.*;

//Prompt is taken from week5 lab, used to create a frame to submit a string or number
public class Prompt extends Frame{
    private Button submit;
    
    public Prompt(){	
	this.setLayout(new GridLayout(0,3));

	submit = new Button("Submit");
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Submit button was pressed!");
		    dispose();
		}
	    });
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent evt) {
		    ((Frame)(evt.getSource())).dispose();
		}
	    });	
    }

    public void addSubmitListener(ActionListener listener){
	submit.addActionListener(listener);
    }

    public void activate(TextField textfield, Label label){
		this.add(label);
		this.add(textfield);
        this.add(submit);
		this.pack();// Resizes to tightly fit all its components
		this.setLocationRelativeTo(null); // Centers the window on the screen
		this.setVisible(true);
    }
}
