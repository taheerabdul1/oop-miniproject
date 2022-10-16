import java.util.*;

public class Marketing extends KPI{
    //marketing increases revenue and cost of production
    public Marketing(String name){
        super(name);
    }

    public void changeKPI(ArrayList <KPI> kpis, String text, boolean increase){
        int number = 0;
        boolean complete = false;
        try{
            number = Integer.parseInt(text);
            complete=true;
        }
        catch(NumberFormatException exception){
            System.out.println("Error! Parse failed "+exception.getLocalizedMessage());
        }
        if(complete&&increase){
            kpis.get(2).increase(number);
            kpis.get(0).increase(number);
            kpis.get(1).increase(number);
            Dashboard.printToTextArea("Success!!");
        }
        else if(complete&&!increase){
            kpis.get(2).decrease(number);
            kpis.get(0).decrease(number);
            kpis.get(1).decrease(number);
            if(kpis.get(2).getIndicatorNumber()-number < 0){
                kpis.get(2).setIndicatorNumber(0);
            }
            if (kpis.get(0).getIndicatorNumber()-number < 0){
                kpis.get(0).setIndicatorNumber(0);
            }
            if (kpis.get(1).getIndicatorNumber()-number < 0){
                kpis.get(1).setIndicatorNumber(0);
            }
            Dashboard.printToTextArea("Success!!");
        }
        else{
            Dashboard.printToTextArea("Error! Marketing could not be changed. Try again.");
        }
    }
}
                    
