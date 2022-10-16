//import necessary packages
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

//main class that runs program
public class Dashboard{
    //constructor
    public Dashboard(){
        
        //arrayList that holds all the key performance indicators(KPI's)
        ArrayList <KPI> kpis = new ArrayList<KPI>();

        //adding kpis to array
        Revenue revenueKPI = new Revenue("Revenue");
        kpis.add(revenueKPI); //0
        Production productionKPI = new Production("Costs of production");
        kpis.add(productionKPI); //1
        Marketing marketingKPI = new Marketing("Marketing");
        kpis.add(marketingKPI); //2
        HR hrKPI = new HR("HR");
        kpis.add(hrKPI); //3
        Inventory inventoryKPI = new Inventory("Inventory");
        kpis.add(inventoryKPI); //4

        //prints welcome message
        printWelcome();

        //buttons that run the program, this prints the current values
        Button printKPIsButton=new Button("Print");
        printKPIsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Print KPIs button was pressed!");
                printKPIs(kpis);
            }
        });

        //this changes the KPI
        Button changeKPIsButton = new Button("Change");
        changeKPIsButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent evt){
                System.out.println("Change KPI button was pressed!");
                Prompt2 prompt2 = new Prompt2();
                Button revButton = new Button("Revenue");
                revButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        System.out.println("Revenue button was pressed!");
                        revenueKPI.changeKPI(kpis, null, true);
                        prompt2.dispose();
                    }
                });
                Button prodButton = new Button("Production");
                prodButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        System.out.println("Production button was pressed!");
                        productionKPI.changeKPI(kpis, null, true);     
                        prompt2.dispose();
                    }
                });
                Button marketButton = new Button("Marketing");
                marketButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        System.out.println("Marketing button was pressed!");
                        changeKPIPrompt(kpis, 2, "Increase", "Decrease");
                        prompt2.dispose();
                    }
                });
                Button hrButton = new Button("HR");
                hrButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        System.out.println("HR button was pressed!");
                        changeKPIPrompt(kpis, 3, "Increase", "Decrease");
                        prompt2.dispose();
                    }
                });
                Button inveButton = new Button("Inventory");
                inveButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        System.out.println("Inventory button was pressed!");
                        changeKPIPrompt(kpis, 4, "Buy", "Sell");
                        prompt2.dispose();
                    }
                });
                prompt2.activate(revButton, prodButton, marketButton, hrButton, inveButton);
            }
        });

        //this prints detailed instructions
        Button printInstructionsButton=new Button("Instructions");
        printInstructionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Instructions button was pressed!");
                printInstructions();
            }
        });

        Button saveButton=new Button("Save Values");
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.out.println("Save Button was pressed!");
                Prompt prompt = new Prompt();
                Label label = new Label("Enter filename here:");
                TextField textfield = new TextField();
                prompt.addSubmitListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        String filename=textfield.getText();
                        try{
                            saveValues(kpis, filename);
                        }catch(FileIOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                prompt.activate(textfield, label);
            }
        });

        Button retrieveButton=new Button("Retrieve Values");
        retrieveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Retrieve Button was pressed!");
                Prompt prompt = new Prompt();
                Label label = new Label("Enter filename here:");
                TextField textField = new TextField();
                prompt.addSubmitListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        String filename=textField.getText();
                        try{
                            retrieveValues(kpis, filename);
                        }catch(FileIOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                prompt.activate(textField, label);
            }
        });

        Button deleteButton=new Button("Delete Values");
        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Delete Button was pressed!");
                Prompt prompt = new Prompt();
                Label label = new Label("Enter filename here:");
                TextField textField = new TextField();
                prompt.addSubmitListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        String filename = textField.getText();
                        try{
                            deleteValues(kpis, filename);
                        }catch(FileIOException e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                prompt.activate(textField, label);
            }
        });

        //sets the frame, makes all of the above visible to user
        DashboardFrame dashboardFrame = new DashboardFrame();
        dashboardFrame.activate(printKPIsButton, printInstructionsButton, changeKPIsButton, saveButton, retrieveButton, deleteButton);
    }

    //method that prints text to textArea
    public static void printToTextArea(String text){
        DashboardFrame.setTextArea(text);
    }

    //welcome message
    public static void printWelcome(){
        printToTextArea(
        "Welcome to this business dashboard program!" + "\n" +
        "This is designed to provide a business dashboard "+ "\n" +
        "that monitors and manages a business using key performance indicators." + "\n" +
        "Using the buttons, you can print the indicators, which are randomised at first." + "\n" +
        "Then, you can choose to change an indicator, which will affect the others as well." + "\n" +
        "To get started, click on the 'Print' button to see the starting values of each KPI" + "\n" +
        "and to see more instructions on how to use this program, click on the 'Instructions' button.");
    }

    //instructions
    public static void printInstructions(){
        printToTextArea(
        "To get started, click on the 'Print' button to see the starting values of each KPI." + "\n" +
        "This will bring up the current values of each indicator."  + "\n" +
        "Note: when the program begins these values will be generated at random." + "\n" +
        "To change an indicator, click on the 'Change' button." + "\n" +
        "This will bring up a prompt asking to click the KPI you wish to change" + "\n" +
        "and a new window will open asking to select a button to change the value of the KPI" + "\n" +
        "and after doing so another prompt will open asking to enter the value to change the KPI by." + "\n" +
        "Finally the prompt and window will close and a Success!! message should print." + "\n" +
        "To view the new KPI values, click on 'Print'." + "\n" +
        "To save, retrieve, and delete prior figures use the respective buttons and specify the file");
    }

    //print indicators
    public static void printKPIs(ArrayList <KPI> kpis){
        printToTextArea(
        kpis.get(0).getIndicatorName() + ": " + kpis.get(0).getIndicatorNumber() + "\n" +
        kpis.get(1).getIndicatorName() + ": "+kpis.get(1).getIndicatorNumber() + "\n" +
        kpis.get(2).getIndicatorName() + ": " + kpis.get(2).getIndicatorNumber() + "\n" +
        kpis.get(3).getIndicatorName() + ": " + kpis.get(3).getIndicatorNumber() + "\n" +
        kpis.get(4).getIndicatorName() + ": " + kpis.get(4).getIndicatorNumber());
    }

    //load prompt to ask what to do 
    public void changeKPIPrompt(ArrayList<KPI>kpis, int number, String button1, String button2){
        Prompt2 prompt2 = new Prompt2();
        Button increaseButton=new Button(button1);
        increaseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Increase button was pressed!");
                Prompt prompt = new Prompt();
                Label label = new Label("Enter number here");
                TextField textField2 = new TextField("");
                prompt.addSubmitListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        kpis.get(number).changeKPI(kpis, textField2.getText(), true);
                        prompt.dispose();
                        prompt2.dispose();
                    }
                });
                prompt.activate(textField2, label);
            }
        });

        Button decreaseButton=new Button(button2);
        decreaseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Decrease button was pressed!");
                Prompt prompt = new Prompt();
                Label label = new Label("Enter number here");
                TextField textField3 = new TextField("");
                prompt.addSubmitListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        kpis.get(number).changeKPI(kpis, textField3.getText(), false);
                        prompt.dispose();
                        prompt2.dispose();
                    }
                });
                prompt.activate(textField3, label);
            }
        });
        prompt2.activate(increaseButton, decreaseButton);
    }

    //file io method, save kpis to file
    public static void saveValues(ArrayList <KPI> kpis, String filename) throws FileIOException{
        boolean complete = false;
        File file=null;
        if(filename.equals("")){
            printToTextArea("Error! Please specify a filename and try again.");
            throw new FileIOException("The values could not be saved. Try again!");
        }
        try{
            file = new File(filename+".txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
        }
        try{
            PrintWriter printWriter = new PrintWriter(file);
            for(int i=0;i<kpis.size();i++){
                int number = kpis.get(i).getIndicatorNumber();
                System.out.println(number);
                printWriter.println(number);
            }
            printWriter.close();
            complete=true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
        }
        if(complete){
            System.out.println("Values saved.");
            printToTextArea("Success!!");
        }
        else{            
            printToTextArea("Error!! The file could not be saved . Try again.");
            throw new FileIOException("Error!! The values could not be saved. Try again. ");
        }
    }

    //file io method, load file from save
    public static void retrieveValues(ArrayList<KPI>kpis, String filename) throws FileIOException{
        boolean exists=false;
        boolean complete=false;
        File file = null;
        try{
            if(filename.equals("")){
                printToTextArea("Error! Please specify a filename and try again.");
                throw new FileIOException("The values could not be retrieved. Try again!");
            }
            file = new File(filename+".txt");
            if (file.createNewFile()) {
                file.delete();
                System.out.println("File does not exist, values cannot be retrieved.");
            } else {
                System.out.println("File already exists.");
                exists=true;
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
        }
        if(exists){
            try{
                BufferedReader inputStream = new BufferedReader(new FileReader(file));
                for(int i=0;i<kpis.size();i++){
                    String string = inputStream.readLine();
                    System.out.println(string);
                    int number = Integer.parseInt(string);
                    kpis.get(i).setIndicatorNumber(number);
                }
                inputStream.close();
                complete=true;
            }catch (IOException e) {
                System.out.println("An error occurred.");
                System.out.println(e.getMessage());
            }
        }
        if(complete){
            System.out.println("Values retrieved.");
            printToTextArea("Success!");
        }
        else{
            printToTextArea("Error!! The file could not be retrieved. Try again.");
            throw new FileIOException("Error!! The values could not be retrieved. Try again.");
        }
    }

    //file io method, delete save file
    public static void deleteValues(ArrayList<KPI>kpis, String filename)throws FileIOException{
        if(filename.equals("")){
            printToTextArea("Error! Please specify a filename and try again.");
            throw new FileIOException("The values could not be deleted. Try again!");
        }
        File file = new File(filename+".txt");
        if(file.delete()){
            System.out.println("Deleted the file: " + file.getName());
            printToTextArea("Save deleted!");
        }else{
            printToTextArea("Error!! The file could not be deleted. Try again.");
            throw new FileIOException("This file could not be deleted. Try again!");
        }
    }

    //main method
    public static void main(String[] args) {
        new Dashboard();
    }
}