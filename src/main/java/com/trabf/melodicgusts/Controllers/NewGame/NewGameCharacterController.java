package com.trabf.melodicgusts.Controllers.NewGame;

import com.trabf.melodicgusts.Models.Model;
import com.trabf.melodicgusts.Views.UserMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameCharacterController implements Initializable {
    public Button options_btn;
    public Button ready_btn;
    public TextField name_fld;
    public Button confirm_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    public void addListeners() {
        options_btn.setOnAction(event -> onBackModalidade());
        confirm_btn.setOnAction(e -> nameUser());
        ready_btn.setOnAction(event -> onCharacter());
    }

    public void onBackModalidade() {
        Model.getInstance().getViewFactory().getUserMenuOptions().set(UserMenuOptions.NEWGAME_MODALITY);
    }

    public void onCharacter() {
        Model.getInstance().getViewFactory().getUserMenuOptions().set(UserMenuOptions.NEWGAME_MATCH);
    }

    //define o nome do usuario
    private void nameUser() {
        String name = name_fld.getText();
        Model.getInstance().getUser().setName(name);
        System.out.println(Model.getInstance().getUser().getName());
    }
}
