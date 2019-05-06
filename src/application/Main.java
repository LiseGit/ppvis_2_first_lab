/*
 * Первая лабораторная второга семестра курса ППвИС. 
 */

package application;

	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

import application.ClassTask_1;
import application.ClassTask_2;
import application.ClassTask_3;
import application.ClassTask_4;
import application.ClassTask_5;

import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Исходный класс.
 *
 * 
 * @author LiseGit
 */

public class Main extends Application {
	private final
		String mName1 = "Задание 1";   //--неизменяемое название
		String mName2 = "Задание 2";  
		String mName3 = "Задание 3";  
		String mName4 = "Задание 4";  
		String mName5 = "Задание 5"; 
	public int msg;
	List<TitledPane> titledContents = new ArrayList<TitledPane>();
	private Thread taskThread;
	private int i=0;
	
    public void start(Stage primaryStage) {
    	
    	MenuBar menu = new MenuBar();
    	
    	Menu whatToDo = new Menu("What to do");
    	
    	//---------пункты меню----------------
    	MenuItem go = new MenuItem("Go");
    	MenuItem stop = new MenuItem("Stop");
    	//MenuItem goOrStop = new MenuItem("Go/Stop");
    	
        //---------добавляем пункты в меню-------------
    	whatToDo.getItems().addAll(go, stop);
    	//whatToDo.getItems().add(goOrStop);
    	
    	
    	//---------добавляем меню на линию-------------
    	menu.getMenus().add(whatToDo);
    	
        ClassTask_1 task1= new ClassTask_1();
        task1.setAlignment(Pos.TOP_CENTER);
        TitledPane  titledContent1 = new TitledPane (mName1, task1);
        titledContent1.setExpanded(false);
        
        
        ClassTask_2 task2= new ClassTask_2();
        task2.setAlignment(Pos.TOP_CENTER);
        TitledPane  titledContent2 = new TitledPane (mName2, task2);
        titledContent2.setExpanded(false);
        
        ClassTask_3 task3= new ClassTask_3();
        task3.setAlignment(Pos.TOP_CENTER);
        TitledPane  titledContent3 = new TitledPane (mName3, task3);
        titledContent3.setExpanded(false);
        
        ClassTask_4 task4= new ClassTask_4();
        task4.setAlignment(Pos.TOP_CENTER);
        TitledPane  titledContent4 = new TitledPane (mName4, task4);
        titledContent4.setExpanded(false);
        
        ClassTask_5 task5= new ClassTask_5();
        task5.setAlignment(Pos.TOP_CENTER);
        TitledPane  titledContent5 = new TitledPane (mName5, task5);
        titledContent5.setExpanded(false);
       
        
        go.setOnAction((ActionEvent eventGo) -> {                     
            taskThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						
						if(Thread.currentThread().isInterrupted()) {
							break;
						}
						titledContents.get(i).setExpanded(true);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
						if(Thread.currentThread().isInterrupted()) {
							break;
						}
						titledContents.get(i).setExpanded(false);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
						i++;
						if(i>4)
							i=0;
					}
				}
			});
            taskThread.start();
        });
        stop.setOnAction((ActionEvent eventStop) -> {                       
            taskThread.interrupt();
        });
        stop.getOnAction();

        VBox vBox = new VBox();
        titledContents.add(titledContent1);
        titledContents.add(titledContent2);
        titledContents.add(titledContent3);
        titledContents.add(titledContent4);
        titledContents.add(titledContent5);
        vBox.getChildren().add(titledContent1);
        vBox.getChildren().add(titledContent2);
        vBox.getChildren().add(titledContent3);
        vBox.getChildren().add(titledContent4);
        vBox.getChildren().add(titledContent5);
        
        BorderPane root = new BorderPane();
        root.setTop(menu);
        root.setCenter(vBox);
        
        Scene scene = new Scene(root, 730, 450);
        
        primaryStage.setTitle("Лабораторная работа №1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[]args) {
    	launch(args);
    }
    
}
