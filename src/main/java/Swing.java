import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Swing {
    public static void main(String[] args) throws SQLException {
        StudentForm frame = new StudentForm();
        frame.setVisible(true);

        Connection conn = DBConnect.connect();

        frame.setSaveButtonActionListener(new SaveButtonListener() {
            @Override
            public void onSaveClicked(Student student) {

                try{
                    String statement = String.format("INSERT INTO students (name, age, email) VALUES ('%s', '%s', '%s') ", student.name, student.age, student.email);


                    PreparedStatement stmt = conn.prepareStatement(statement);
                    stmt.executeUpdate();

                    System.out.println("Student inserted");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
