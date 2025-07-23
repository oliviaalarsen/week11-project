package projects.app;

public class SampleItem {
    private int id;
    private String name;

    // Constructor for inserting a new item (no ID yet)
    public SampleItem(String name) {
        this.name = name;
    }

    // Constructor for retrieving item from the database (with ID)
    public SampleItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // String method for easy output
    @Override
    public String toString() {
        return "SampleItem{id=" + id + ", name='" + name + "'}";
    }
}
