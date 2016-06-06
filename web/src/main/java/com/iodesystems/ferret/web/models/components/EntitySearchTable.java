package com.iodesystems.ferret.web.models.components;

import com.iodesystems.ferret.data.definition.EntityDefinition;
import com.iodesystems.ferret.data.search.SearchResult;
import com.iodesystems.ferret.web.models.Component;

public class EntitySearchTable implements Component {
    private final EntityDefinition entityDefinition;
    private String query;
    private SearchResult searchResult;

    public EntitySearchTable(EntityDefinition entityDefinition) {
        this.entityDefinition = entityDefinition;
    }

    public EntityDefinition getEntityDefinition() {
        return entityDefinition;
    }

    @Override
    public String getType() {
        return "entities/search_table";
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
