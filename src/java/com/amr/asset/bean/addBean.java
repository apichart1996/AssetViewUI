/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amr.asset.bean;

import com.amr.asset.model.Equipment;
import com.amr.asset.model.editIP;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author evolu
 */
@ManagedBean
@RequestScoped
public class addBean {
    private String empno;
    private String type = "-";
    private String brand = "-";
    private String model = "-";
    private String serialno = "-";
    
    private URL url;
    private BufferedReader br = null;
    private String errorMessage;
    editIP ip = new editIP();
    private List<Equipment> addList = new ArrayList<>();

    public addBean(){
        empno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empno");
        System.out.println("addBean test empno : "+empno);

    }
    public String validatAdd(){
        String line;
        String parameters = "";
        if(!empno.equals("")){
            System.out.println("empno : "+empno);
            parameters = parameters + "empno=" + empno + "&";
        }
        if(!type.equals("")){
            System.out.println("type : "+type);
            parameters = parameters + "type=" + type+ "&";
        }
        if(!brand.equals("")){
            System.out.println("brand : "+brand);
            parameters = parameters + "brand=" + brand+ "&";
        }
        if(!model.equals("")){
            System.out.println("model : "+model);
            parameters = parameters + "model=" + model+ "&";
        }
        if(!serialno.equals("")){
            System.out.println("serialno : "+serialno);
            parameters = parameters + "serialno=" + serialno+ "&";
        }
        parameters = parameters.substring(0, parameters.length()-1);
        String x = ip.getIp() + "/AssetviewWS/rest/adddevice?";
        System.out.println(x+parameters);
        
        try {
            url = new URL(ip.getIp()+ "/AssetviewWS/rest/adddevice?"+ parameters);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("ooo : "+ urlConnection);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("in : "+in);
            br = new BufferedReader(new InputStreamReader(in));
            System.out.println("br : "+br);
            line = br.readLine();
            while (line != null) {
                System.out.println("br.readLine : "+br.readLine());
                if(line != null){
                    System.out.println("Login success");
                    System.out.println("Line entered : " + line);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                    return "userDetail?faces-redirect=true";
                }
            }             
        } catch (MalformedURLException ex) {
            Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the serialno
     */
    public String getSerialno() {
        return serialno;
    }

    /**
     * @param serialno the serialno to set
     */
    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * @return the br
     */
    public BufferedReader getBr() {
        return br;
    }

    /**
     * @param br the br to set
     */
    public void setBr(BufferedReader br) {
        this.br = br;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the addList
     */
    public List<Equipment> getAddList() {
        return addList;
    }

    /**
     * @param addList the addList to set
     */
    public void setAddList(List<Equipment> addList) {
        this.addList = addList;
    }

    /**
     * @return the empno
     */
    public String getEmpno() {
        return empno;
    }

    /**
     * @param empno the empno to set
     */
    public void setEmpno(String empno) {
        this.empno = empno;
    }
}
