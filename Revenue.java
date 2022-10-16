import java.util.*;

public class Revenue extends KPI{
    /*revenue can't be manipulated directly, and the contructor is made
    such that there is always more revenue than costs of production*/
    public Revenue(String name){
        super(name);
        Random random = new Random();
        setIndicatorNumber(random.nextInt(1000)+1500);
    }

    public void changeKPI(ArrayList<KPI>kpis, String text, boolean increase){
        Dashboard.printToTextArea("You can't change revenue! Change another KPI.");
    }
}