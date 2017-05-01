package testing;

import exercise.Exercise;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by edotee on 05.04.17.
 */
@XmlRootElement(name = "SET")
public class ExerciseSetXmlWrapper {

    private List<Exercise> exerciseSet;

    //HAS to exist
    public ExerciseSetXmlWrapper() { }

    public ExerciseSetXmlWrapper(List<Exercise> exerciseSet) {
        setExerciseSet(exerciseSet);
    }

    @XmlElement(name = "UNIT")
    public List<Exercise> getExerciseSet() {
        return exerciseSet;
    }

    public void setExerciseSet(List<Exercise> exerciseSet) {
        this.exerciseSet = exerciseSet;
    }
}