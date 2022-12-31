package lu.atozdigital.api.DTO;

import lu.atozdigital.api.Utils.Env;

public class ArticleDTO {
    private Long id;

    private String name;

    private double price;

    private String picture;

    public Long getId() {
        return id;
    }

    public ArticleDTO(Long id, String name, double price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public ArticleDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
            return Env.getUrlImages()+picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
