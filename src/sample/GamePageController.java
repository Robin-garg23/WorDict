package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.HashMap;

public class GamePageController {
    private DictionarySaver database;
    @FXML private TextField searchWord;
    @FXML private TextField newWord;
    @FXML private TextField newMeaning;
    @FXML private TextField meaning;

    @FXML
    public void search(MouseEvent event) throws IOException {
        database =new DictionarySaver(new HashMap<>());
        database.deserializeHashMap();
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Search Result");
        if(searchWord.textProperty().get().equals(""))
        {
            errorAlert.setContentText("Please Enter a word to search");
            errorAlert.showAndWait();
        }
        else if(database.getDicList().containsKey(searchWord.textProperty().get().toLowerCase()))
        {
            errorAlert.setContentText(searchWord.textProperty().get() + " is Available in Dictionary");
            errorAlert.showAndWait();
        }
        else {
            errorAlert.setContentText(searchWord.textProperty().get() + " is not Available in Dictionary");
            errorAlert.showAndWait();
        }

    }

    @FXML
    public void newword(MouseEvent event) throws IOException {

        database =new DictionarySaver(new HashMap<>());
        database.deserializeHashMap();
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Dictionary");
        if(newWord.textProperty().get().equals("") || newMeaning.textProperty().get().equals(""))
        {
            errorAlert.setContentText("Please Enter a word/meaning to Add");
            errorAlert.showAndWait();
        }
        else {
            database.addWord(newWord.textProperty().get().toLowerCase(), newMeaning.textProperty().get());
            database.serializeHashMap();
            errorAlert.setContentText("New Word Added to Dictionary");
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void meaning(MouseEvent event) throws IOException {
        database =new DictionarySaver(new HashMap<>());
        database.deserializeHashMap();
        Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
        errorAlert.setHeaderText("Meaning");
        if(meaning.textProperty().get().equals(""))
        {
            errorAlert.setContentText("Please Enter a word to find Meaning");
            errorAlert.showAndWait();
        }
        else if(database.getDicList().containsKey(meaning.textProperty().get().toLowerCase()))
        {
            Text text = new Text(database.getDicList().get(meaning.textProperty().get().toLowerCase()));
            text.setWrappingWidth(400);
            errorAlert.getDialogPane().setContent(text);
            errorAlert.showAndWait();

        }
        else
        {
            errorAlert.setContentText( meaning.textProperty().get() + " is not Available in Dictionary");
            errorAlert.showAndWait();
        }
    }


}
