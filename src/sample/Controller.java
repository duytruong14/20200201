package sample;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private ListView<Employee> employeeListView;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private CheckBox isActiveCheckBox;
    @FXML
    private Button clear;
    @FXML
    private Button add;
    @FXML
    private Button delete;




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        employeeListView.getSelectionModel().selectedItemProperty().addListener((
                        ObservableValue < ? extends Worker> ov, Worker old_val, Worker new_val)->
                {
                    Worker selectedItem = employeeListView.getSelectionModel().getSelectedItem();

                    firstNameTextField.setText(((Employee)selectedItem).firstName);
                    lastNameTextField.setText(((Employee)selectedItem).lastName);
                    isActiveCheckBox.setSelected(((Employee)selectedItem).isActive);

                }
        );


        ObservableList<Employee> items = employeeListView.getItems();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.firstName = "Robert";
        employee1.lastName = "Smith";
        employee2.firstName = "Lisa";
        employee2.lastName = "Smith";

        items.add(employee1);
        items.add(employee2);

        for(int i = 0; i < 10; i++)
        {
            Employee employee = new Employee();
            employee.firstName = "Generic";
            employee.lastName = "Employee" + " " + i;
            employee.hire();
            items.add(employee);
        }

        Staff staff1 = new Staff();
        staff1.firstName = "StaffPerson";
        staff1.lastName = " GoodWorker";

        Faculty faculty1 = new Faculty();
        faculty1.firstName = "FacultyPerson";
        faculty1.lastName = " TerribleWorker";

        items.add(staff1);
        items.add(faculty1);
        //clear button
        clear.setOnAction(a -> clearSelection());
        //delete button
        delete.setOnAction(new EventHandler<ActionEvent>() {//Professor Otto taught this method on 02/15/2020
            @Override
            public void handle(ActionEvent event) {
                ObservableList<Employee> allEmp;
                allEmp = employeeListView.getItems();
                ObservableList<Employee> EmpSelected;
                EmpSelected = employeeListView.getSelectionModel().getSelectedItems();
                EmpSelected.forEach(allEmp::remove);
        /*NOTE: line 91-95 was based on a youtube tutorial video URL:https://www.youtube.com/watch?time_continue=1&v=uz2sWCnTq6E&feature=emb_title
       I rewrote and modify it in a a way that will fit the current program and make it easier for me to understand it*/

                //Clear the text field after delete a row
                firstNameTextField.clear();
                lastNameTextField.clear();
                isActiveCheckBox.setSelected(false); // checkbox

            }
        });
        //add button
        add.setOnAction(c ->addInput());

    }
    //clear button function
    public void clearSelection(){
        firstNameTextField.clear();
        lastNameTextField.clear();
        isActiveCheckBox.setSelected(false); // checkbox
        // this will clear both text field and the check box whenever i click the clear button


    }
    //add butoon function
    public void addInput() {
        Employee emp = new Employee();
        emp.firstName=(firstNameTextField.getText());
        emp.lastName=(lastNameTextField.getText());
        //emp.isActive=true;
        boolean check =isActiveCheckBox.isSelected();
        //this will check the status of teh check box
        if(check==true){
            emp.isActive=true;
        }
        else{emp.isActive=false;}


        //Finally, add all input into the rows
        employeeListView.getItems().add(emp);
        //Clear the text field after add a row
        firstNameTextField.clear();
        lastNameTextField.clear();
        isActiveCheckBox.setSelected(false); // checkbox
//final check 2





    }
}