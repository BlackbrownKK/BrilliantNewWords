package com.example.brilliantnewwords;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HelloApplication extends Application {
    String[] replyQuestions = new String[4];
    boolean[] replyQuestionsBboolean = new boolean[4];
    boolean[] replyAnswersBboolean = new boolean[4];
    String[] replyAnswers = new String[4];
    UtilityForReadFile utility = new UtilityForReadFile();
    int[] randIntNumbers = getRandomOrderArray( );

    @Override
    public void start(Stage stage) throws IOException {

        String[] questions = new String[4];
        String[] answers = new String[4];

        int i = 0;

        Map<String, String> inputVocabularyPaar = utility.startTiTest();
        Set<Map.Entry<String, String>> entrySet = inputVocabularyPaar.entrySet();


        for (Map.Entry<String, String> entry : entrySet) {
            questions[i] = entry.getKey();
            System.out.println(entry.getKey());
            answers[i] = entry.getValue();
            System.out.println(entry.getValue());
            i++;
        }

        Button[] labelsQuestionsButton = new Button[4];
        Button[] labelsAnswersButton = new Button[4];


        for (i = 0; i < 4; i++) {
            labelsQuestionsButton[i] = new Button(questions[i]);
            labelsAnswersButton[i] = new Button(answers[i]);
        }

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10); // Horizontal gap between columns
        root.setVgap(10); // Horizontal gap between columns

        Scene mySceneQuestions = new Scene(root, 600, 600);
        stage.setScene(mySceneQuestions);

        root.add(labelsQuestionsButton[0], 1, 1);
        root.add(labelsAnswersButton[0], 2, randIntNumbers[0]);

        root.add(labelsQuestionsButton[1], 1, 2);
        root.add(labelsAnswersButton[1], 2, randIntNumbers[1]);

        root.add(labelsQuestionsButton[2], 1, 3);
        root.add(labelsAnswersButton[2], 2, randIntNumbers[2]);


        root.add(labelsQuestionsButton[3], 1, 4);
        root.add(labelsAnswersButton[3], 2, randIntNumbers[3]);


        stage.setTitle("Merge the phrases");


        labelsQuestionsButton[0].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyQuestions[0] = labelsQuestionsButton[0].getText();
                replyQuestionsBboolean[0] = true;
                System.out.println(replyQuestions[0]);

            }
        });

        labelsQuestionsButton[1].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyQuestions[1] = labelsQuestionsButton[1].getText();
                replyQuestionsBboolean[1] = true;
                System.out.println(replyQuestions[1]);
            }
        });

        labelsQuestionsButton[2].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyQuestions[2] = labelsQuestionsButton[2].getText();
                replyQuestionsBboolean[2] = true;
                System.out.println(replyQuestions[2]);

            }
        });

        labelsQuestionsButton[3].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyQuestions[3] = labelsQuestionsButton[3].getText();
                replyQuestionsBboolean[3] = true;
                System.out.println(replyQuestions[3]);
            }
        });

        labelsAnswersButton[0].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyAnswers[0] = labelsAnswersButton[0].getText();
                replyAnswersBboolean[0] = true;
                if ( replyQuestionsBboolean[0] && replyAnswersBboolean[0] &&
                        inputVocabularyPaar.get(replyQuestions[0]).equals(replyAnswers[0]) ) {
                    labelsQuestionsButton[0].setText("");
                    labelsAnswersButton[0].setText("");
                }
            }
        });

        labelsAnswersButton[1].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyAnswers[1] = labelsAnswersButton[1].getText();
                replyAnswersBboolean[1] = true;
                if ( replyQuestionsBboolean[1] && replyAnswersBboolean[1] &&
                        inputVocabularyPaar.get(replyQuestions[1]).equals(replyAnswers[1]) ) {
                    labelsQuestionsButton[1].setText("");
                    labelsAnswersButton[1].setText("");
                }
            }
        });


        labelsAnswersButton[2].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyAnswers[2] = labelsAnswersButton[2].getText();
                replyAnswersBboolean[2] = true;
                if ( replyQuestionsBboolean[2] && replyAnswersBboolean[2] &&
                        inputVocabularyPaar.get(replyQuestions[2]).equals(replyAnswers[2]) ) {
                    labelsQuestionsButton[2].setText("");
                    labelsAnswersButton[2].setText("");
                }
            }
        });


        labelsAnswersButton[3].setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                replyAnswers[3] = labelsAnswersButton[3].getText();
                replyAnswersBboolean[3] = true;
                if ( replyQuestionsBboolean[3] && replyAnswersBboolean[3] &&
                        inputVocabularyPaar.get(replyQuestions[3]).equals(replyAnswers[3]) ) {
                    labelsQuestionsButton[3].setText("");
                    labelsAnswersButton[3].setText("");
                }
            }
        });



        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    private int[] getRandomOrderArray( ) {
        int[] numbers = {1, 2, 3, 4};
        Random random = new Random();

        // Shuffle the array using Fisher-Yates algorithm
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap numbers[i] and numbers[j]
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        return numbers;
    }
}

