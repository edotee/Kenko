package testing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by edotee on 05.04.17.
 */
public class XmlHandler {

    private final static String ROUTINE_PATHFILE = "data/exercise.xml";


    public List<exercise.Exercise> readRoutineData() {
        return readRoutineData(ROUTINE_PATHFILE);
    }

    public List<exercise.Exercise> readRoutineData(String filepath) {
        List<exercise.Exercise> result = null;

        File file = new File(filepath);

        try {
            JAXBContext context = JAXBContext.newInstance(ExerciseXmlWrapper.class); //XmlWrapperMonster.class
            Unmarshaller um = context.createUnmarshaller();
            // Reading XML from the file and unmarshalling.
            ExerciseXmlWrapper wrapper = (ExerciseXmlWrapper) um.unmarshal(file);

            result = wrapper.getExercise();
        } catch (Exception e) { // catches ANY exception
            alertWindow("Could not load data",
                    "Could not load data from file:\n" + file.getPath());
        }

        return result;
    }

    public void writeRoutineDataToFile(List<exercise.Exercise> data) {
        writeRoutineDataToFile(data, ROUTINE_PATHFILE);
    }

    /**
     * Saves the current person data to the specified file.
     *
     * @param filepath
     */
    public void writeRoutineDataToFile(List<exercise.Exercise> data, String filepath) {
        File file = new File(filepath);
        try {
            JAXBContext context = JAXBContext.newInstance(ExerciseXmlWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Marshalling and saving XML to the file.
            m.marshal(new ExerciseXmlWrapper(data), file);
        } catch (Exception e) { // catches ANY exception
            alertWindow("Could not save data",
                    "Could not save data to file:\n" + file.getPath());
        }
    }

    private void alertWindow(String header, String content) {
        /*
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
        */
        System.out.println(header + "\n" + content);
    }
}