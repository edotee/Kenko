import exercise.Exercise;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author edotee
 */
@XmlRootElement(name = "routine")
public class ExerciseXmlWrapper {

    private List<Exercise> exercise;

    //HAS to exist
    public ExerciseXmlWrapper() { }

    public ExerciseXmlWrapper(List<exercise.Exercise> exercise) {
        setExercise(exercise);
    }

    //@XmlElement(name = "EXERCISE")
    public List<Exercise> getExercise() { return exercise; }
    public void setExercise(List<Exercise> exercise) { this.exercise = exercise; }
}