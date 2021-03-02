package lesson7.homework;

import lesson7.Graph;
import lesson7.IGraph;
import lesson7.Vertex;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        IGraph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Липецк", "Москва");
        graph.addEdges("Липецк", "Воронеж", "Тула");
        graph.addEdges("Рязань", "Москва", "Тамбов");
        graph.addEdges("Тамбов", "Рязань", "Саратов");
        graph.addEdges("Саратов", "Тамбов", "Воронеж");
        graph.addEdges("Калуга", "Москва", "Орел");
        graph.addEdges("Орел", "Курск", "Калуга");
        graph.addEdges("Курск", "Орел", "Воронеж");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        graph.display();
        graph.bestWay("Москва", "Воронеж");
    }
}
