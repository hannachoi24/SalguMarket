package com.ApricotMarket.controller;

import com.ApricotMarket.domain.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class createItemForm {
    private String city;
    private String district;
    private String town;
    private int price;
    private int discount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private Category category;
    private String Description;
    private String name;
    private String image;
    private String pdn;
    private String Location;

    //추가//
    private int discountprice;
    private int originalprice;
}
