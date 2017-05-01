package exercise;

import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by edotee on 16.03.17.
 */
public class Exercise<T extends ExerciseSet> implements Serializable {
    private final SimpleStringProperty name;
    private ArrayList<T> sets;

    //Has to exist for XML-unmarshalling
    public Exercise() {
        this.name = new SimpleStringProperty();
        this.sets = new ArrayList();
    }

    public Exercise(String name, T... sets) {
        this.name = new SimpleStringProperty(name);
        this.sets = new ArrayList();
        this.addAll(sets);
    }

    public Exercise(String name, ArrayList<T> sets) {
        this.name = new SimpleStringProperty(name);
        this.sets = new ArrayList();
        this.addAll(sets);
    }

    public void addAll(ArrayList<T> sets) {
        for(T s : sets)
            this.sets.add(s);
    }

    public void addAll(T[] sets) {
        for(T s : sets)
            this.sets.add(s);
    }

    @Override
    public String toString() {
        String result = name.getName();
        for(T s : this.sets)
            result += "\n" + s.toString();

        return (result + "\n");
    }

    //@XmlElement(name = "NAME")
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public SimpleStringProperty nameProperty() { return name; }

    @XmlElement(name = "set") //has to exist, otherwise it's not marshalled
    public ArrayList<T> getSets() { return sets; }
}
