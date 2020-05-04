/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@RequestScoped
public class NavigationBean  implements Serializable{
    public String modulepage(String s){
    return "/module/"+s+"?faces-redirect=true";
    }
    public String secretpage(String s){
    return "/secret/"+s+"?faces-redirect=true";
    }
    public String adminpage(String s){
    return "/admin/"+s+"?faces-redirect=true";
    }
    }