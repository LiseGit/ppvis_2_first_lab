package application;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
//import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ClassTask_4 extends StackPane{
    //private final String mName = "Задание 4";   //--неизменяемое название
    ClassTask_4(){
        
        Map<String,CheckBox> mCheckBoxValue = new LinkedHashMap<>();   // LinkedHashMap - для хранения элементов в порядае добавления
        
        mCheckBoxValue.put("First",  new CheckBox("First"));
        mCheckBoxValue.put("Second", new CheckBox("Second"));       
        mCheckBoxValue.put("Third",  new CheckBox("Third"));       
        
        TextField textField = new TextField();
        Button btn = new Button();
        btn.setText("Button");
        btn.setMinWidth(80);
        btn.setOnAction((ActionEvent event) -> {
            String text = textField.getText();
            
            if( text.isEmpty() ) { //--чтоб не применять пустое значение
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!!!");
                alert.setHeaderText("Вводиться пустое значение!!!");
                alert.setContentText("Повторите ввод нового значения!");                
                alert.showAndWait();
            }else{                
                if( mCheckBoxValue.get(text) == null ) {    // ключ не найден
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка!!!");
                    alert.setHeaderText("Элемент не найден !!!");
                    alert.setContentText("Повторите ввод нового значения!");
                    alert.showAndWait();
                }else{
                    mCheckBoxValue.get(text).setSelected(true);
                }
            }
            textField.clear();  //--очистка текстового поля
        });

        /*CheckBox  rb1 = new CheckBox ("First");
        rb1.setSelected(true);

        CheckBox  rb2 = new CheckBox ("Second");
        rb2.setSelected(true);
        
        CheckBox  rb3 = new CheckBox ("Third");
        rb3.setSelected(true);*/
       
        HBox hBox = new HBox();     //---комбинируем виджеты по горизонтали
        hBox.setSpacing(5);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);

        mCheckBoxValue.entrySet().stream().forEach((item) -> {
            hBox.getChildren().add(item.getValue());
        });
        /*
        TitledPane  titledContent = new TitledPane (mName, hBox);        
        getChildren().add(titledContent);*/
        getChildren().add(hBox);
    }
}

