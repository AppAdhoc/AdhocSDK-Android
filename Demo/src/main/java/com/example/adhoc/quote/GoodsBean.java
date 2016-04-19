package com.example.adhoc.quote;

/**
 * Created by dongyuangui on 15-4-22.
 */
public class GoodsBean {
    private String imgName;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    private String goodName;
}
