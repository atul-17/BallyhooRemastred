
package example.atul.ballyhoohomescreenappchanges;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelBanner {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("offer")
    @Expose
    private String offer;
    @SerializedName("image")
    @Expose
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
