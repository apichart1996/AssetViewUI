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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author evolu
 */
@ManagedBean
@RequestScoped
public class editadmindeviceBean {
    private String id;
    private String empno;
    
    private String type;
    private String brand;
    private String model;
    private String serialno;
    private String asignto;
    
    private URL url;
    private BufferedReader br = null;
    private String errorMessage;
    
    private List<Equipment> addList = new ArrayList<>();
    editIP ip = new editIP();
    
    public editadmindeviceBean() {
        
        int i;
        id = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empno"); 
        System.out.println("empno : "+id);
        
        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/device/edit/"+id);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("empno : "+id);
            System.out.println("ooo : "+ urlConnection);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            JSONArray data = new JSONArray(br.readLine());
            System.out.println("br.readLine() : "+br.readLine());
            
           for(i=0;i<data.length();i++){
                System.out.println("zz : "+data);
                JSONObject jsonObj  = data.getJSONObject(i);
                empno = jsonObj.get("empno").toString();
                System.out.println(type);
                type = jsonObj.get("type").toString();
                System.out.println(type);
                brand = jsonObj.get("brand").toString();
                System.out.println(brand);
                model = jsonObj.get("model").toString();
                System.out.println(model);
                serialno = jsonObj.get("serialno").toString();
                System.out.println(serialno);
            }
            
        } catch (IOException | JSONException ex) {
            Logger.getLogger(userDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String validatEdit(){
        String line;
        String parameters = "";
        if(!id.equals("")){
            System.out.println("serialno : "+id);
            parameters = parameters + "id=" + id+ "&";
        }
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
        else{
            System.out.println("Please fill in the information");
            setErrorMessage("Please fill in the information");
            return getErrorMessage();
        }
        parameters = parameters.substring(0, parameters.length()-1);
        String x = ip.getIp() + "/AssetviewWS/rest/editdevice?";
        System.out.println(x+parameters);
        
        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/editdevice?"+ parameters);
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
                    return "editadmindetail?faces-redirect=true";
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
     * @return the asignto
     */
    public String getAsignto() {
        return asignto;
    }

    /**
     * @param asignto the asignto to set
     */
    public void setAsignto(String asignto) {
        this.asignto = asignto;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
