
package example.atul.ballyhoohomescreenappchanges;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelHomeScreen {

    @SerializedName("Banner")
    @Expose
    private ModelBanner banner;
    @SerializedName("Discover")
    @Expose
    private List<ModelDiscover> discover = null;
    @SerializedName("Hastag")
    @Expose
    private List<ModelHastag> hastag = null;
    @SerializedName("Offer")
    @Expose
    private List<ModelSingleItem> offer = null;
    @SerializedName("Sponser")
    @Expose
    private List<ModelSponser> sponser = null;

    public ModelBanner getBanner() {
        return banner;
    }

    public void setBanner(ModelBanner banner) {
        this.banner = banner;
    }

    public List<ModelDiscover> getDiscover() {
        return discover;
    }

    public void setDiscover(List<ModelDiscover> discover) {
        this.discover = discover;
    }

    public List<ModelHastag> getHastag() {
        return hastag;
    }

    public void setHastag(List<ModelHastag> hastag) {
        this.hastag = hastag;
    }

    public List<ModelSingleItem> getOffer() {
        return offer;
    }

    public void setOffer(List<ModelSingleItem> offer) {
        this.offer = offer;
    }

    public List<ModelSponser> getSponser() {
        return sponser;
    }

    public void setSponser(List<ModelSponser> sponser) {
        this.sponser = sponser;
    }

}
