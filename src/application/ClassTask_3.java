package application;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
//import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ClassTask_3 extends StackPane{
   // private final String mName = "Задание 3";   //--неизменяемое название
    ClassTask_3(){
        ToggleGroup group = new ToggleGroup();
        Map<String,RadioButton> mRadioBoxValue = new LinkedHashMap<>();   // LinkedHashMap - для хранения элементов в порядае добавления
        
        mRadioBoxValue.put("First", new RadioButton("First"));
        mRadioBoxValue.get("First").setToggleGroup(group);
        //mRadioBoxValue.get("First").setSelected(true);
        
        mRadioBoxValue.put("Second", new RadioButton("Second"));
        mRadioBoxValue.get("Second").setToggleGroup(group);
        
        mRadioBoxValue.put("Third", new RadioButton("Third"));
        mRadioBoxValue.get("Third").setToggleGroup(group);
        
        TextField textField = new TextField();
        Button btn = new Button();
        btn.setText("Get text and select RadioBox");
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
                if( mRadioBoxValue.get(text) == null ) {    // ключ не найден
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Ошибка!!!");
                    alert.setHeaderText("Элемент не найден !!!");
                    alert.setContentText("Повторите ввод нового значения!");
                    alert.showAndWait();
                }else{
                    mRadioBoxValue.get(text).setSelected(true);
                }
            }
            textField.clear();  //--очистка текстового поля
        });
       
        
        HBox hBox = new HBox();     //---комбинируем виджеты по горизонтали
        hBox.setSpacing(5);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn);
        
        mRadioBoxValue.entrySet().stream().forEach((item) -> {
            hBox.getChildren().add(item.getValue());
        });
       /* 
        TitledPane  titledContent = new TitledPane (mName, hBox);        
        getChildren().add(titledContent);*/
        getChildren().add(hBox);
    }
}

