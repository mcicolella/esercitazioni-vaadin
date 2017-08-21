package net.emmecilab.vaadindemo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
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

        // aggiungiamo un listener relativo alle modifiche del testo sfruttando la sintassi di Java8
        // ogni volta che digitiamo un nuovo carattere appare una notifica con il testo digitato
        text.addValueChangeListener(event -> Notification.show("Il testo digitato é: " + event.getValue()));
        root.addComponent(text);

        // text area
        TextArea textArea = new TextArea();

        // impostiamo le dimensioni
        textArea.setWidth("50%");
        textArea.setHeight("50%");

        // possiamo abilitare o meno il word wrap ovvero tornare a capo se lo spazio
        // non è sufficiente a contenere il testo sulla riga (true) oppure aggiungere
        // una scrollbar (false)
        textArea.setWordWrap(false);

        root.addComponent(textArea);

        // button
        Button button = new Button("Premi");

        // aggiungiamo un listener per gli eventi generati dalla pressione
        // del pulsante
        button.addClickListener(event
                -> {
            System.out.println("Il tasto è stato premuto");
            Notification.show("Hai premuto il pulsante:" + event.getButton().getCaption());
        });

        root.addComponent(button);
        
        // checkbox
        CheckBox checkBox = new CheckBox("abilita");
        
        // aggiungiamo un listener per catturare lo stato quando viene modificato
        checkBox.addValueChangeListener(event -> Notification.show("Lo stato del checkbox è: " + checkBox.getValue()));
        root.addComponent(checkBox);

        // infine impostiamo il layout per la visualizzazione
        setContent(root);
    }

}
