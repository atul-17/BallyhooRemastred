package example.atul.ballyhoohomescreenappchanges;

import java.util.List;

/**
 * Created by atul on 1/12/19.
 */
public class ModelOffersUI {

    private ModelSingleItem modelSingleItem;
    private ModelTwoItems modelTwoItems;
    private ModelHomeScreenCollections modelHomeScreenCollectionsList;

    public ModelHomeScreenCollections getModelHomeScreenCollectionsList() {
        return modelHomeScreenCollectionsList;
    }

    public void setModelHomeScreenCollectionsList(ModelHomeScreenCollections modelHomeScreenCollectionsList) {
        this.modelHomeScreenCollectionsList = modelHomeScreenCollectionsList;
    }

    public ModelSingleItem getModelSingleItem() {
        return modelSingleItem;
    }

    public void setModelSingleItem(ModelSingleItem modelSingleItem) {
        this.modelSingleItem = modelSingleItem;
    }

    public ModelTwoItems getModelTwoItems() {
        return modelTwoItems;
    }

    public void setModelTwoItems(ModelTwoItems modelTwoItems) {
        this.modelTwoItems = modelTwoItems;
    }
}
