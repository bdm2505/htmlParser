module com.example.htmlparser {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens ru.bdm.htmlparser to javafx.fxml;
    exports ru.bdm.htmlparser;
}