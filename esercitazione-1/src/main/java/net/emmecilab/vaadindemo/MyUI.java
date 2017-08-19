package net.emmecilab.vaadindemo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Mauro Cicolella
 *
 */
@SpringUI(path = "/ui") //indica l'endpoint della pagina
@Theme("valo") // tema di default 
public class MyUI extends UI {

    // il codice relativo all'interfaccia va inserito in questo metodo
    @Override
    protected void init(VaadinRequest request) {

        // impostiamo un layout verticale
        VerticalLayout root = new VerticalLayout();

        // una label contiene del testo non editabile
        // la modalità di default è TEXT per cui tutto è interpretato come testo 
        Label label = new Label("<b>Questa è una label con solo testo</b>", ContentMode.TEXT);
        root.addComponent(label);

        // modalità testo preformattato
        Label label2 = new Label("Label con testo preformattato \n", ContentMode.PREFORMATTED);
        root.addComponent(label2);

        // testo contenente tag html
        Label label3 = new Label("<br><i>Label con testo interpretato come html</i>", ContentMode.HTML);
        root.addComponent(label3);

        // aggiungiamo un text field
        TextField text = new TextField("Questo è un text field");
        root.addComponent(text);
               
        // infine impostiamo il layout per la visualizzazione
        setContent(root);
    }

}
