package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
//import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ClassTask_1 extends StackPane{
    //private final String mName = "Задание 1";   //--неизменяемое название
    ClassTask_1(){
        TextField textField = new TextField();
        textField.setMinWidth(120);
        
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setMinWidth(120);
        
        Button btn = new Button();
        btn.setText("Add text to ComboBox");
        btn.setMinWidth(120);
        btn.setOnAction((ActionEvent event) -> {                   
            boolean bResInsertNull = textField.getText().isEmpty(); //--чтоб дважды не вызывать проверку на пустоту
            if( bResInsertNull || comboBox.getItems().contains(textField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка вставки!!!");
                
                if( bResInsertNull )
                    alert.setHeaderText("Вводиться пустое значение.");
                else
                    alert.setHeaderText("Такое значение уже есть в ComboBox. Добавление этого значения - НЕВОЗМОЖНО!!!");
                
                alert.setContentText("Повторите ввод нового значения!");                
                alert.showAndWait();
            }else{
                comboBox.getItems().add(textField.getText());
            }
            textField.clear();  //--очистка текстового поля
        });        
        
        HBox hBox = new HBox();     //---комбинируем виджеты по горизонтали
        hBox.setSpacing(5);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        hBox.getChildren().add(comboBox);
       /* TitledPane  titledContent = new TitledPane (mName, hBox);        
        getChildren().add(titledContent);*/
        getChildren().add(hBox);
    }    
}

