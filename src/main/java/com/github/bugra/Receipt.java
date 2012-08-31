package com.github.bugra;

import java.math.BigInteger;

/*
 * @bugra
 * Model 
 */
public class Receipt {
    private String name;
    private String text;
    private BigInteger id;
    
    public Receipt(){
    	
    }
    public Receipt(String name, String text, BigInteger id) {
    	this.name = name;
    	this.text = text;
    	this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public BigInteger getId(){
    	return id;
    }
    public void setId(BigInteger id){
    	this.id = id;
    }
    public String toString() {
        return("Name="+this.name + "has a receipt: " +  this.text + "with id:" + this.id);
    }
}
