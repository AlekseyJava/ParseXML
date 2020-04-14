import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Преобразование данных");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);
        Pane root = new Pane();
        Button btn = new Button();
        btn.setText("Преобразовать данные");
        btn.setTranslateX(75);
        btn.setTranslateY(75);

        btn.setOnAction(event -> {
            btn.setDisable(true);
            System.out.println("hello");
            WorkWithBase workWithBase = new WorkWithBase(); //копируем из базы элементы xml
            workWithBase.extractData();
            btn.setText("Данные преобразованы");
        });

        Scene scene = new Scene(root);
        root.getChildren().addAll(btn);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}