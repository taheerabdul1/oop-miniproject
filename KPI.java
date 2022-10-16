//import packages
import java.util.*;

//abstract class = objects of type KPI can't be created
public abstract class KPI implements Actions{
    private String name;
    //indicator number that is changed by user
    private int indicatorNumber;

    //constructor, indicator number is random at first, but always above 500
    public KPI(String name){
        this.name=name;
        Random random = new Random();
        this.setIndicatorNumber(random.nextInt(1000)+500);
    }

    //getter
    public String getIndicatorName() {
        return name;
    }

    //getter
    public int getIndicatorNumber() {
        return indicatorNumber;
    }

    //setter
    public void setIndicatorNumber(int indicatorNumber) {
        this.indicatorNumber = indicatorNumber;
    }
    
    //method to change value of KPI, different for each KPI, hence abstract, example of polymorphism
    public abstract void changeKPI(ArrayList <KPI> kpis, String text, boolean increase);

    //methods to change the number itself
    public void increase(int numbertoincrease){
        setIndicatorNumber(indicatorNumber+numbertoincrease);
    }

    public void decrease(int numbertodecrease){
        setIndicatorNumber(indicatorNumber-numbertodecrease);
    }
}
