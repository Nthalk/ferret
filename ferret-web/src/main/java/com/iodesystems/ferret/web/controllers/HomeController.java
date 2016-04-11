package com.iodesystems.ferret.web.controllers;

import com.iodesystems.ferret.data.Entity;
import com.iodesystems.ferret.data.exceptions.InvalidKindException;
import com.iodesystems.ferret.logic.data.FieldReference;
import com.iodesystems.ferret.logic.operations.EqualsOperation;
import com.iodesystems.ferret.logic.operations.NotOperation;
import com.iodesystems.ferret.web.models.Page;
import com.iodesystems.ferret.web.models.components.Section;
import com.iodesystems.ferret.web.models.components.Text;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.definition.FieldDefinition;
import com.iodesystems.ferret.data.exceptions.InvalidStateException;
import com.iodesystems.ferret.data.storage.KindStorage;
import com.iodesystems.ferret.flow.Flow;
import com.iodesystems.ferret.flow.State;
import com.iodesystems.ferret.flow.Test;
import com.iodesystems.ferret.logic.constants.StringConstant;
import com.iodesystems.ferret.logic.data.VariableGet;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    KindStorage kindStorage;

    @RequestMapping("/")
    public String home(@ModelAttribute Page page) {
        page.setTitle("Home");
        Section section = new Section();
        section.setTitle("News");
        section.getComponents().add(new Text("Welcome home!"));
        page.getComponents().add(section);

        EntityDefinition assets = new EntityDefinition();
        assets.setName("asset");
        FieldDefinition assetStatus = new FieldDefinition();
        assetStatus.setName("status");
        assets.getFieldDefinitions().add(assetStatus);
        FieldDefinition assetName = new FieldDefinition();
        assetName.setName("name");
        assets.getFieldDefinitions().add(assetName);


        Flow flow = new Flow("status");
        State unknown = new State("unknown");
        unknown.getTransitions().put(
            new Test(new NotOperation(new EqualsOperation(
                new FieldReference(new VariableGet(Test.TARGET), "name"),
                new StringConstant("asdf")))),
            new State("not asdf"));
        flow.setInitialState(unknown);

        Entity entity = assets.create();
        try {
            State state = flow.currentState(entity);
            state = flow.transitionState(entity, kindStorage);
            System.out.println();
        } catch (InvalidKindException e) {
            e.printStackTrace();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        } catch (EvaluationException e) {
            e.printStackTrace();
        }

        return "home";
    }
}
