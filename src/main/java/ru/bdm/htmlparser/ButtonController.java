package ru.bdm.htmlparser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class ButtonController {


    @FXML
    Button loadFileButton;
    @FXML
    Label loadFileLabel;
    @FXML
    Button saveFileButton;
    @FXML
    Label saveFileLabel;

    @FXML
    Label statusLabel;

    File fileInput;
    File fileOutput;

    FileChooser fileChooser = new FileChooser();
    {
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt", "*");
        FileChooser.ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("HTML files (*.html, *.htm)", "*.html", "*.htm");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.getExtensionFilters().add(extFilter2);
    }
    FileHtmlParser parser = new FileHtmlParser();

    public void onClickLoadFile() {
        try {
            fileChooser.setTitle("Выберите файл для обработки");
            fileInput = fileChooser.showOpenDialog(null);
            if (fileInput != null) {
                loadFileLabel.setText(fileInput.getCanonicalPath());
            }
        } catch (IOException e) {
            fileInput = null;
            e.printStackTrace();
        }
        statusLabel.setText("");
    }

    public void onClickSaveButton() {
        try {
            fileChooser.setTitle("Выберите файл для результатов");
            fileOutput = fileChooser.showSaveDialog(null);
            if (fileOutput != null) {
                saveFileLabel.setText(fileOutput.getCanonicalPath());
            }
        } catch (IOException e) {
            fileOutput = null;
            e.printStackTrace();
        }
        statusLabel.setText("");
    }

    public void onClickRun() {
        if(fileInput != null && fileOutput != null){
            statusLabel.setText("Обработка...");
            try {
                parser.parseHtml(fileInput, fileOutput);
                statusLabel.setText("Завершено!");
            } catch (IOException e) {
                e.printStackTrace();
                statusLabel.setText("Ошибка! " + e.getMessage());
            }
        } else {
            statusLabel.setText("Укажите файлы!");
        }
    }
}