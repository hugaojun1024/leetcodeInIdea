package com.algorithm.others;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-04-23-[下午 4:20]-周二
 */
public class PrintXY extends Application{

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // 绘制 x 轴
        Line xAxis = new Line(50, 250, 550, 250);
        xAxis.setStroke(Color.BLACK);
        root.getChildren().add(xAxis);

        // 绘制 y 轴
        Line yAxis = new Line(300, 50, 300, 450);
        yAxis.setStroke(Color.BLACK);
        root.getChildren().add(yAxis);

        // 绘制点 (3, 4) 在 xy 坐标系中的位置
        Circle point = new Circle();
        point.setCenterX(300 + 3 * 50); // x 轴从 50 开始，每单位长度占据 50 个像素
        point.setCenterY(250 - 4 * 50); // y 轴从 250 开始，每单位长度占据 50 个像素
        point.setRadius(5); // 设置点的半径
        point.setFill(Color.RED); // 设置点的颜色
        root.getChildren().add(point);

        // 创建场景并显示
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("XY Coordinate System");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
