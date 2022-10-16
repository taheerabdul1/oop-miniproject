import java.util.*;

public class Inventory extends KPI{
    //inventory increases and decreases revenue
    public Inventory(String name){
        super(name);
        Random random = new Random();
        this.setIndicatorNumber(random.nextInt(500)+500);
    }

    public void changeKPI(ArrayList <KPI> kpis, String text, boolean increase){
        int number = 0;
        boolean complete = false;
        boolean check=true;
        try{
            number = Integer.parseInt(text);
            complete=true;
        }
        catch(NumberFormatException exception){
            System.out.println("Error! Parse failed "+exception.getLocalizedMessage());
        }
        if(complete&&increase){
            if(number>kpis.get(0).getIndicatorNumber()){
                Dashboard.printToTextArea("Error! Inventory could not be bought as there is not enough revenue. Try again.");
                check=false;
                return;
            }
            if(check){
                kpis.get(4).increase(number);
                kpis.get(0).decrease(number);
                Dashboard.printToTextArea("Success!!");
            }
        }
        else if(complete&&!increase){
            int priorKPI = kpis.get(4).getIndicatorNumber();
            if(kpis.get(4).getIndicatorNumber()==0){
                Dashboard.printToTextArea("Error! Cannot sell as inventory is 0. Try again.");
                return;
            }
            if(number>kpis.get(4).getIndicatorNumber()){
                kpis.get(4).setIndicatorNumber(0);
                kpis.get(0).increase(priorKPI);
            }
            if(number<kpis.get(4).getIndicatorNumber()){
                kpis.get(4).decrease(number);
                kpis.get(0).increase(number);
            }
            if(kpis.get(4).getIndicatorNumber() < 0){
                kpis.get(4).setIndicatorNumber(0);
            }
            Dashboard.printToTextArea("Success!!");
        }
        else{
            Dashboard.printToTextArea("Error! Inventory could not be changed. Try again.");
        }
}
}
