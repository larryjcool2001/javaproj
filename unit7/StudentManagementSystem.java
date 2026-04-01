package unit7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentManagementSystem extends JFrame {

    JTextField idField, nameField, gradeField;
    JComboBox<String> courseBox;
    JTable studentTable;
    DefaultTableModel model;

    public StudentManagementSystem() {

        setTitle("Student Management System");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.add("Students", studentPanel());
        tabs.add("Enrollment", enrollmentPanel());
        tabs.add("Grades", gradePanel());

        add(tabs);

        setVisible(true);
    }

    JPanel studentPanel() {

        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3,2));

        idField = new JTextField();
        nameField = new JTextField();

        form.add(new JLabel("Student ID"));
        form.add(idField);

        form.add(new JLabel("Student Name"));
        form.add(nameField);

        JButton addBtn = new JButton("Add Student");

        form.add(addBtn);

        panel.add(form,BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Grade");

        studentTable = new JTable(model);

        panel.add(new JScrollPane(studentTable),BorderLayout.CENTER);

        addBtn.addActionListener(e -> addStudent());

        return panel;
    }

    JPanel enrollmentPanel() {

        JPanel panel = new JPanel();

        courseBox = new JComboBox<>(new String[]{
                "Mathematics",
                "Programming",
                "Database Systems"
        });

        JButton enrollBtn = new JButton("Enroll Student");

        panel.add(new JLabel("Course"));
        panel.add(courseBox);
        panel.add(enrollBtn);

        enrollBtn.addActionListener(e -> enrollStudent());

        return panel;
    }

    JPanel gradePanel() {

        JPanel panel = new JPanel();

        gradeField = new JTextField(5);

        JButton assignBtn = new JButton("Assign Grade");

        panel.add(new JLabel("Grade"));
        panel.add(gradeField);
        panel.add(assignBtn);

        assignBtn.addActionListener(e -> assignGrade());

        return panel;
    }

    void addStudent() {

        String id = idField.getText();
        String name = nameField.getText();

        if(id.isEmpty() || name.isEmpty()) {

            JOptionPane.showMessageDialog(this,"Please fill all fields");
            return;
        }

        model.addRow(new Object[]{id,name,"None","N/A"});

        idField.setText("");
        nameField.setText("");
    }

    void enrollStudent() {

        int row = studentTable.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(this,"Select a student first");
            return;
        }

        String course = (String) courseBox.getSelectedItem();

        model.setValueAt(course,row,2);
    }

    void assignGrade() {

        int row = studentTable.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(this,"Select a student");
            return;
        }

        String grade = gradeField.getText();

        if(grade.isEmpty()) {

            JOptionPane.showMessageDialog(this,"Enter grade");
            return;
        }

        model.setValueAt(grade,row,3);

        gradeField.setText("");
    }

    public static void main(String[] args) {

        new StudentManagementSystem();
    }
}

