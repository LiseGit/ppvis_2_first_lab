package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class ClassTask_2 extends StackPane {
  //  private final String mName = "Задание 2";   //--неизменяемое название
    ClassTask_2(){
        TextField textField = new TextField();
        Button btn1 = new Button();
        Button btn2 = new Button();
        btn1.setText("Button 1");
        btn1.setMinWidth(80);
        btn1.setOnAction((ActionEvent event) -> {
            if( textField.getText().isEmpty() ) { //--чтоб не применять пустое значение
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка вставки!!!");
                alert.setHeaderText("Вводиться пустое значение!!!");
                alert.setContentText("Повторите ввод нового значения!");                
                alert.showAndWait();
            }else{
                btn2.setText(textField.getText());
            }
            textField.clear();  //--очистка текстового поля
        });
        
        btn2.setText("Button 2");
        btn2.setMinWidth(80);
        btn2.setOnAction((ActionEvent event) -> {
            String buf = btn2.getText();
            btn2.setText(btn1.getText());
            btn1.setText(buf);
        });
        
        HBox hBox = new HBox();     //---комбинируем виджеты по горизонтали
        hBox.setSpacing(5);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(btn1);
        hBox.getChildren().add(btn2);
        /*TitledPane  titledContent = new TitledPane (mName, hBox);
        getChildren().add(titledContent);*/
        getChildren().add(hBox);
    }
}
