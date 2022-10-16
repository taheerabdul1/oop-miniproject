import java.util.*;

public class HR extends KPI{
    //increased HR can increase revenue and marketing, and decrease costs of production by a factor of 2
    public HR(String name){
        super(name);
    }

    public void changeKPI(ArrayList <KPI> kpis, String text, boolean increase){
        int number=0;
        boolean complete = false;
        try{
            number = Integer.parseInt(text);
            complete=true;
        }
        catch(NumberFormatException exception){
            System.out.println("Error! Parse failed "+exception.getLocalizedMessage());
        }
        if(complete&&increase){
            kpis.get(3).increase(number);
            kpis.get(0).increase(number);
            kpis.get(1).decrease(number*2);
            kpis.get(2).increase(number);
            if(kpis.get(1).getIndicatorNumber() < 0){
                kpis.get(1).setIndicatorNumber(0);
            }
            Dashboard.printToTextArea("Success!");
        }
        else if(complete&&!increase){
            kpis.get(3).decrease(number);
            kpis.get(0).decrease(number);
            kpis.get(1).increase(number*2);
            kpis.get(2).decrease(number);
            if(kpis.get(3).getIndicatorNumber() < 0){
                kpis.get(3).setIndicatorNumber(0);
            }
            if(kpis.get(0).getIndicatorNumber() < 0){
                kpis.get(0).setIndicatorNumber(0);
            }
            if(kpis.get(2).getIndicatorNumber() < 0){
                kpis.get(2).setIndicatorNumber(0);
            }
            if(kpis.get(1).getIndicatorNumber() > kpis.get(0).getIndicatorNumber() && kpis.get(0).getIndicatorNumber()==0){
                kpis.get(1).setIndicatorNumber(0);
            }
            Dashboard.printToTextArea("Success!!");
        }
        else{
            Dashboard.printToTextArea("Error! HR could not be decreased. Try again.");
        }
    }
}