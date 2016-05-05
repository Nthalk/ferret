package com.iodesystems.ferret.data.search;

import com.iodesystems.ferret.data.Entity;
import com.iodesystems.ferret.data.definition.EntityDefinition;
import org.springframework.stereotype.Component;

@Component
public class EntitySearchService {
    public SearchResult search(EntityDefinition entityDefinition,
                               String query,
                               Integer limit,
                               Integer offset) {
        SearchResult searchResult = new SearchResult();
        Entity entity = entityDefinition.create();
        entity.getFields().get(0).setValue("asdf");
        searchResult.getData().add(entity);
        return searchResult;
    }
}
