package JavaFX_1;

import Files.BasicFile;
import Files.CompareFile;
import Files.FileFactory;
import Files.FileList;
import Files.TUCompareEntry;
import Files.TUEntry;
import ParseThaiLaw.ThaiLawParser;
import comparator.Comparator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Chris
 */
public class Fxml_1Controller implements Initializable {

    @FXML
    Label title;

    @FXML
    TableView<TUEntry> tableView;

    @FXML
    TableColumn<TUEntry, String> thaiCol;

    @FXML
    TableColumn<TUEntry, String> englishCol;

    @FXML
    TableColumn<TUCompareEntry, String> thaiColComp;

    @FXML
    TableColumn<TUCompareEntry, String> englishColComp;
    
    @FXML
    TableColumn<TUCompareEntry, String> fileNameColComp;

    @FXML
    TableView<TUCompareEntry> compareTable;
    
    @FXML
    TextField minMatchLengthField;
    
    @FXML
    Label numMatches;
    
    /**
     * The string that was used to set the current compare table.
     */
    private String currentCompareString;

    /**
     * The minimum length for matching substrings shown in compare table viewer.
     */
    private int minMatchLength;
    /**
     * The file currently being translated.
     */
    BasicFile file1;
    /**
     * The corpus where matches are found.
     */
    FileList corpus;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Default minimum length for matches
        minMatchLength = 5;
        
        // Sets prompt text for minMatchLengthField to equal default minimum match length
        minMatchLengthField.setPromptText(Integer.toString(minMatchLength));
        
        // Sets main file viewer columns
        thaiCol.setCellValueFactory(new PropertyValueFactory<>("thai"));
        thaiCol.setMinWidth(80);
        thaiCol.setCellFactory(tc -> {
            TableCell<TUEntry, String> cell = new TableCell<>();
            Text text = new Text();
            text.setFont(Font.font("Arial"));
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(thaiCol.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
        englishCol.setCellValueFactory(new PropertyValueFactory<>("english"));
        
        // makes main file
        FileFactory ff = new FileFactory();
        String filePath = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/FanSafety.txt";
        file1 = ff.justThaiFilePath(filePath);
        file1.setFileName("Main File");

        // makes corpus (list of files to find matches in)
        corpus = new FileList();
        corpus.addFile(file1);
        String thaiFile1 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/Thai Book 3-AUTO.txt";
        String engFile1 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/Eng Book 3-SQ.txt";
        corpus.addFile((new ThaiLawParser(thaiFile1, engFile1)).makeFile());
        String thaiFile2 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/Thai Book 2.txt";
        String engFile2 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/Eng Book 2-1.txt";
        corpus.addFile((new ThaiLawParser(thaiFile2, engFile2)).makeFile());
        String thaiFile3 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/Thai Book 1TXT2.txt";
        String engFile3 = "/Users/Chris/Desktop/Docs/Documents/Personal/Coding/Non-website design/Thai Parser Project/CAT1/src/CAT1/SampleEnglishLaw1.txt";
        corpus.addFile((new ThaiLawParser(thaiFile3, engFile3)).makeFile());
        

        title.setText(file1.getFileName());

        // binds main file to main table viewer
        
        tableView.setItems(file1.getObservableList());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Sets compare table columns
        thaiColComp = new TableColumn<>("Thai");
        thaiColComp.setCellValueFactory(new PropertyValueFactory<>("thai"));
        thaiColComp.setMinWidth(120);
        thaiColComp.setCellFactory(tc -> {
            TableCell<TUCompareEntry, String> cell = new TableCell<>();
            Text text = new Text();
            text.setFont(Font.font("Arial"));
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(thaiColComp.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });
        englishColComp = new TableColumn<>("English");
        englishColComp.setCellValueFactory(new PropertyValueFactory<>("english"));
        englishColComp.setMinWidth(180);
        compareTable.getColumns().addAll(thaiColComp, englishColComp);
        compareTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // sets initial compare file in compare table to first TU in main file viewer
        setCompareTable(file1.getTUs().get(0).toString());

        /*
            Makes it so when a row is selected in the main table, this renders compareTable with a new CompareFile made from the Thai String from the main table.
         */
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                setCompareTable(newSelection.getThai());
            }
        }
        );

        Font.getFamilies().forEach((s) -> {
            System.out.println(s);
        });
        
    }

    @FXML
    protected void minMatchLengthChanged(ActionEvent event) {
        minMatchLength = Integer.valueOf(minMatchLengthField.getText());
        setCompareTable(currentCompareString);
    }
    
    @FXML
    private void commit(ActionEvent event) {
        System.out.println("commit");
        TUEntry selectedTU = tableView.getSelectionModel().getSelectedItem();
        selectedTU.setCommitted(true);
        
        
        // change the TU to committed
        
        
    }
    
    private void setCompareTable(String text) {
        currentCompareString = text;
        Comparator c = new Comparator(text, corpus, minMatchLength);
        CompareFile cf = c.getCompareFile();
        setNumMatches(cf.getTUs().size());
        compareTable.setItems(cf.getObservableList());
    }
    
    private void setNumMatches(int num) {
        numMatches.setText(String.valueOf(num));
    }
    
    
}