/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Home
 */
@Named(value = "imagesView")
@ManagedBean
//@ViewScoped
public class ImagesView implements  Serializable{
     
    private List<String> images;
    private String titulo;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("fundecreb" + i + ".jpg");
        }
        titulo="shufllee";
    }
 
    public List<String> getImages() {
        return images;
    }

    public String getTitulo() {
        return titulo;
    }
    
    
}