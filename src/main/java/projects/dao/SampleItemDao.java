package projects.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projects.app.SampleItem;

public class SampleItemDao {

    // CREATE: insert new item (love note) into the database
    public static void insertSampleItem(SampleItem item) {
        Connection conn = DbConnection.getConnection();
        if (conn != null) {
            try {
                String sql = "INSERT INTO sample_table (name) VALUES (?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, item.getName());
                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Item inserted successfully!");
                }
            } catch (SQLException e) {
                System.out.println("Failed to insert item.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No connection to database.");
        }
    }

    // READ: get all items (love notes) from the database
    public static List<SampleItem> getAllItems() {
        List<SampleItem> items = new ArrayList<>();
        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                String sql = "SELECT * FROM sample_table";
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    SampleItem item = new SampleItem(id, name);
                    items.add(item);
                }

            } catch (SQLException e) {
                System.out.println("Failed to retrieve items.");
                e.printStackTrace();
            }
        }
        return items;
    }

    // UPDATE: change the name of a love note using its ID
    public static void updateSampleItem(int id, String newName) {
        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                String sql = "UPDATE sample_table SET name = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, newName);
                stmt.setInt(2, id);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Love note updated successfully!");
                } else {
                    System.out.println("No record found with that ID.");
                }
            } catch (SQLException e) {
                System.out.println("Failed to update item.");
                e.printStackTrace();
            }
        } else {
            System.out.println("x: No connection to database.");
        }
    }

    // DELETE: remove a love note using its ID
    public static void deleteSampleItem(int id) {
        Connection conn = DbConnection.getConnection();

        if (conn != null) {
            try {
                String sql = "DELETE FROM sample_table WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);

                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Love note deleted successfully.");
                } else {
                    System.out.println("No love note found with that ID.");
                }
            } catch (SQLException e) {
                System.out.println("Failed to delete item.");
                e.printStackTrace();
            }
        } else {
            System.out.println("x: No connection to database.");
        }
    }


}
