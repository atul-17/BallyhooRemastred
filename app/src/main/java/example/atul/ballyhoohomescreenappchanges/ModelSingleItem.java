
package example.atul.ballyhoohomescreenappchanges;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSingleItem {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("twin")
    @Expose
    private String twinl;

    public String getTwinl() {
        return twinl;
    }
    public void setTwinl(String twinl) {
        this.twinl = twinl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
