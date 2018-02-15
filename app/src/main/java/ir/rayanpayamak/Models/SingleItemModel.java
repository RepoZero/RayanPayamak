package ir.rayanpayamak.Models;

/**
 * Created by cloner on 7/15/17.
 */

public class SingleItemModel {


    private String name;
    private String img_url;
    private String url;
    private String description;


    public SingleItemModel() {
    }

    public SingleItemModel(String name,String img_url, String url) {
        this.name = name;
        this.img_url=img_url;
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }
    public String getImage_url() {
        return img_url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
