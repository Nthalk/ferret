package com.iodesystems.ferret.ui;

import com.iodesystems.ferret.xsd.Ferret;
import com.iodesystems.ferret.xsd.Ui;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.data.Option;

import java.util.HashMap;
import java.util.Map;

public class UiResolver {

    private final Map<String, Ui> userInterfaces;

    public UiResolver(Ferret.Ui userInterfaces) {
        if (userInterfaces != null) {
            this.userInterfaces = Fn.index(userInterfaces.getUi(), Ui::getId);
        } else {
            this.userInterfaces = new HashMap<>();
        }
    }

    public Option<Ui> ui(String id) {
        return Fn.get(userInterfaces, id);
    }

}
