package com.zhyzhko.controllers.forms;

import java.util.List;

/**
 * Created by Egor on 12.04.2017.
 */
public class ResponseCollectionCreateForm {
    private List<ResponseCollectionShowForm> showForms;

    public ResponseCollectionCreateForm() {
    }

    public ResponseCollectionCreateForm(List<ResponseCollectionShowForm> showForms) {
        this.showForms = showForms;
    }

    public List<ResponseCollectionShowForm> getShowForms() {
        return showForms;
    }

    public void setShowForms(List<ResponseCollectionShowForm> showForms) {
        this.showForms = showForms;
    }

    @Override
    public String toString() {
        return "ResponseCollectionCreateForm{" +
                "showForms=" + showForms +
                '}';
    }
}
