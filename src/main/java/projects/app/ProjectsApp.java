package projects.app;

import projects.dao.SampleItemDao;
import java.util.List;


public class ProjectsApp {
public static void main(String[] args) {

     // UPDATE: try to update the item (love note) with ID 1
    SampleItemDao.updateSampleItem(1, "First kiss on the rooftop");

    // DELETE: try to delete the item (love note) with ID 1
    SampleItemDao.deleteSampleItem(1);

    // CREATE: add a brand new item (love note)
    SampleItem myNewNote = new SampleItem("He kissed me on the forehead before sunrise");
    SampleItemDao.insertSampleItem(myNewNote);

    // READ: retrieve and display all items (love notes)
    List<SampleItem> items = SampleItemDao.getAllItems();

    if (items.isEmpty()) {
        System.out.println("No entries found");
    } else {
        System.out.println("Love notes retrieved from the database:");
        for (SampleItem item : items) {
            System.out.println(item.getId() + ": " + item.getName());
        }
    }
}

}
