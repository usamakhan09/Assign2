package com.example.project39.Domain;
public class PopularDomain {
    public String title;
    public String descp;
    public String pic;
    public Double fees;
    public int itemincart;

    public PopularDomain(String title,String descp,String pic,Double fees)
    {
        this.title=title;
        this.descp=descp;
        this.pic=pic;
        this.fees=fees;
        this.itemincart=itemincart;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public int getItemincart() {
        return itemincart;
    }

    public void setItemincart(int itemincart) {
        this.itemincart = itemincart;
    }
}
