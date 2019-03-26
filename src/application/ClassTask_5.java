package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafxapplication1.ClassTask_5.MyTableData;

public class ClassTask_5 extends StackPane{
    private final String mName = "Задание 5";   //--неизменяемое название
    
    public  class MyTableData{  //---класс представляющий строку данных в таблице
        private  StringProperty FirstValue = new SimpleStringProperty();

        public String getFirstValue() {
            return FirstValue.get();
        }
        public void setFirstValue(String value) {
            FirstValue.set(value);
        }
        public StringProperty FirstValueProperty() {
            return FirstValue;
        }
        private StringProperty SecondValue = new SimpleStringProperty();

        public String getSecondValue() {
            return SecondValue.get();
        }
        public void setSecondValue(String value) {
            SecondValue.set(value);
        }
        public StringProperty SecondValueProperty() {
            return SecondValue;
        }
        private MyTableData(String first, String second) {
            setFirstValue(first);
            setSecondValue(second);
        }
     };
    
    ClassTask_5(){
        ObservableList<MyTableData> tableData = FXCollections.observableArrayList();
        TableView<MyTableData> table = new TableView<>(tableData);
        //----инициализация колонок-------------
        TableColumn<MyTableData, String> firstNameCol = new TableColumn("Column 1");
        TableColumn<MyTableData, String> lastNameCol = new TableColumn("Column 2");
        firstNameCol.setCellValueFactory(cellData -> cellData.getValue().FirstValueProperty());
        lastNameCol.setCellValueFactory(cellData -> cellData.getValue().SecondValueProperty());
        table.getColumns().addAll(firstNameCol, lastNameCol);
        //------------текстовое поле---------------------------------------
        TextField textField = new TextField();
        textField.setMinWidth(130);
        //--------------------------первая кнопка-------------------------
        Button btn1 = new Button();
        btn1.setText("Text to Column 1");
        btn1.setMinWidth(120);
        btn1.setOnAction((ActionEvent event) -> {
            String text = textField.getText();            
            if( text.isEmpty() ) { //--чтоб не применять пустое значение
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!!!");
                alert.setHeaderText("Вводиться пустое значение!!!");
                alert.setContentText("Повторите ввод нового значения!");                
                alert.showAndWait();
            }else{                
                tableData.add(new MyTableData(text,null));
                table.setItems(tableData);
                table.getSelectionModel().selectLast();
            }
        });
        //--------------------------вторая кнопка-------------------------
        Button btn2 = new Button();
        btn2.setText("Column 1 to Column 2");
        btn2.setMinWidth(140);
        btn2.setOnAction((ActionEvent event) -> {
            String buf1 = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getFirstValue();
            if( !buf1.isEmpty() ) {
                //String buf2 = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getSecondValue();
                //table.getItems().get(table.getSelectionModel().getSelectedIndex()).setFirstValue(buf2);
                table.getItems().get(table.getSelectionModel().getSelectedIndex()).setFirstValue("");
                table.getItems().get(table.getSelectionModel().getSelectedIndex()).setSecondValue(buf1);
            }
        });
        //--------------------------третья кнопка-------------------------
        Button btn3 = new Button();
        btn3.setText("Column 2 to Column 1");
        btn3.setMinWidth(140);
        btn3.setOnAction((ActionEvent event) -> {
            //String buf1 = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getFirstValue();
            String buf2 = table.getItems().get(table.getSelectionModel().getSelectedIndex()).getSecondValue();
            if( !buf2.isEmpty() ) {
                table.getItems().get(table.getSelectionModel().getSelectedIndex()).setFirstValue(buf2);
                table.getItems().get(table.getSelectionModel().getSelectedIndex()).setSecondValue("");
            }
        });               
        
        HBox hBox = new HBox();     //---комбинируем виджеты по горизонтали
        hBox.setSpacing(5);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn1);
        hBox.getChildren().add(btn2);
        hBox.getChildren().add(btn3);
        hBox.getChildren().add(table);
        
        TitledPane  titledContent = new TitledPane (mName, hBox);        
        getChildren().add(titledContent);
    }
}

