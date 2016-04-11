package com.iodesystems.ferret.data;

import com.iodesystems.fn.Option;

import java.util.Collection;

public interface Kind {

    Collection<Field> getFields();

    Option<Field> getField(String name);
}
