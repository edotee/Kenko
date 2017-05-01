package refactor;

import exercise.ExerciseUnit;
import javafx.beans.property.SimpleDoubleProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * Created by edotee on 16.03.17.
 * A simple JavaBean that holds all relevant information for 1 set of an old
 * It also has a nested implementation of its own builder.
 */
@XmlType( propOrder = { "repetition", "repetitionUnit", "load", "loadUnit" , "stepping"} )
public class ExerciseSet implements Serializable {

    //TODO Implement repetitionUnit & loadUnit as property
    private final SimpleExerciseProperty primaryValue, secondaryValue;
    private final SimpleDoubleProperty stepping;

    public ExerciseSet() {
        primaryValue = new SimpleExerciseProperty();
        secondaryValue = new SimpleExerciseProperty();
        stepping = new SimpleDoubleProperty(1.0f);
    }

    @Override
    public String toString() {
        String result = "";/*
        if(repetition != null)  result += repetition.get() + " ";
        if(repetitionUnit != null)  result += repetitionUnit.toString() + " ";
        if(load != null)  result += ((load.get() % 1 == 0)? (int) load.get() : load.get()) + " ";
        if(loadUnit != null)  result += loadUnit.toString() + " ";*/
        return result;
    }

    //@XmlElement(name = "REPETITION")
    public int getRepetition() { return (int)this.primaryValue.getValue(); }
    public void setRepetition(int rep) { this.primaryValue.setValue(rep); }
    /*
    public int getRepetition() { return (int)this.primaryValue.valueProperty().get(); }
    public void setRepetition(int rep) { this.primaryValue.valueProperty().set(rep); }
    public SimpleDoubleProperty repetitionProperty() { return this.primaryValue.valueProperty();}
     */

    @XmlElement(name = "repUnit")
    public ExerciseUnit getRepetitionUnit() { return this.primaryValue.getUnit(); }
    public void setRepetitionUnit(ExerciseUnit repetitionUnit) { this.primaryValue.setUnit(repetitionUnit); }

    //@XmlElement(name = "LOAD")
    public double getLoad() { return this.secondaryValue.getValue(); }
    public void setLoad(double load) { this.secondaryValue.setValue(load); }
    //public SimpleDoubleProperty loadProperty() { return this.load; }

    //@XmlElement(name = "LOADUNIT")
    public ExerciseUnit getLoadUnit() { return this.secondaryValue.getUnit(); }
    public void setLoadUnit(ExerciseUnit unit) { this.secondaryValue.setUnit(unit); }

    //@XmlElement(name = "STEPPING")
    public double getStepping() { return this.stepping.get(); }
    public void setStepping(double stepping) { this.stepping.set(stepping); }
    public SimpleDoubleProperty steppingProperty() { return this.stepping; }

}