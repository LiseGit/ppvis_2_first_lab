package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import application.ClassTask_1;
import application.ClassTask_2;
import application.ClassTask_3;
import application.ClassTask_4;
import application.ClassTask_5;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ClassTask_1 task1= new ClassTask_1();
        task1.setAlignment(Pos.TOP_CENTER);
        
        ClassTask_2 task2= new ClassTask_2();
        task2.setAlignment(Pos.TOP_CENTER);
        
        ClassTask_3 task3= new ClassTask_3();
        task3.setAlignment(Pos.TOP_CENTER);
        
        ClassTask_4 task4= new ClassTask_4();
        task4.setAlignment(Pos.TOP_CENTER);
        
        ClassTask_5 task5= new ClassTask_5();
        task4.setAlignment(Pos.TOP_CENTER);
        
        VBox vBox = new VBox();
        vBox.getChildren().add(task1);
        vBox.getChildren().add(task2);
        vBox.getChildren().add(task3);
        vBox.getChildren().add(task4);
        vBox.getChildren().add(task5);
                
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        
        Scene scene = new Scene(root, 730, 450);
        
        primaryStage.setTitle("Лабораторная работа №1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
