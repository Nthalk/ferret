package com.iodesystems.ferret.ui;

import com.iodesystems.ferret.xsd.UserInterface;
import com.iodesystems.ferret.xsd.UserInterfaces;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.HashMap;
import java.util.Map;

public class UiResolver {

    private final Map<String, UserInterface> userInterfaces;

    public UiResolver(UserInterfaces userInterfaces) {
        if (userInterfaces != null) {
            this.userInterfaces = Fn.index(userInterfaces.getUi(), UserInterface::getId);
        } else {
            this.userInterfaces = new HashMap<>();
        }
    }

    public Option<UserInterface> ui(String id) {
        return Fn.get(userInterfaces, id);
    }

}
