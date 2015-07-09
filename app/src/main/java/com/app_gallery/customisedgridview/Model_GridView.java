package com.app_gallery.customisedgridview;

public class Model_GridView
{
    private int     image;
    private String  name;
    private int     price;

    public int getImage()
    {
        return image;
    }
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }

    public void setImage(int to_set)
    {
        image=to_set;
    }
    public void setName(String to_set)
    {
        name =to_set;
    }
    public void setPrice(int to_set)
    {
        price=to_set;
    }
}
