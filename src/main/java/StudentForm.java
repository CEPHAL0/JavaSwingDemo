import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    public JTextField nameField;
    public JTextField ageField;
    public JTextField emailField;
    private JLabel txtName;
    private JLabel txtEmail;
    private JLabel txtContact;
    private JButton saveButton;
    private JButton clearButton;
    private JPanel contentPane;

    private SaveButtonListener saveButtonListener;

    public StudentForm() {
        setTitle("Student Form");
        setSize(1080, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clear();
            }
        });
    }

    public void setSaveButtonActionListener(SaveButtonListener listener){
        this.saveButtonListener = listener;
    }

    private void saveChanges(){
        String name = nameField.getText();
        String age = ageField.getText();
        String email = emailField.getText();

        Student student = new Student(name, age, email);

        if (saveButtonListener != null){
            saveButtonListener.onSaveClicked(student);
        }
    }

    private void clear(){
        nameField.setText("");
        ageField.setText("");
        emailField.setText("");
    }

}
