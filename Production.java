import java.util.*;

public class Production extends KPI{
    //costs of production can't be manipulated directly
    public Production(String name){
        super(name);
        Random random = new Random();
        setIndicatorNumber(random.nextInt(500)+1000);
    }

    public void changeKPI(ArrayList<KPI> kpis, String text, boolean increase) {
        Dashboard.printToTextArea("You can't change the costs of production! Change another KPI.");        
    }
}