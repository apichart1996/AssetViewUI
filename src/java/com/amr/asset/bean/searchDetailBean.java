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
public class searchDetailBean {
    private String empno;
    
    private List<String> s = new ArrayList<>();
    private List<Equipment> equipList = new ArrayList<>();
    
    private URL url;
    private BufferedReader br = null;
    private editIP ip = new editIP();
    
    public searchDetailBean() {
        int i;
        empno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empnoSearch"); 

        System.out.println("searchDetailBean : "+empno);
        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/device/detail/"+empno);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("empno : "+empno);
            System.out.println("ooo : "+ urlConnection);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            JSONArray data = new JSONArray(br.readLine());
            System.out.println("br.readLine() : "+br.readLine());
            
           for(i=0;i<data.length();i++){
                System.out.println("zz : "+data);
                JSONObject jsonObj  = data.getJSONObject(i);    
                Equipment equip = new Equipment();
                equip.setType(jsonObj.get("type").toString());
                equip.setBrand(jsonObj.get("brand").toString());
                equip.setModel(jsonObj.get("model").toString());
                equip.setSerialno(jsonObj.get("serialno").toString());
                equipList.add(equip);
            }
            
        } catch (IOException | JSONException ex) {
            Logger.getLogger(userDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * @return the s
     */
    public List<String> getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(List<String> s) {
        this.s = s;
    }

    /**
     * @return the equipList
     */
    public List<Equipment> getEquipList() {
        return equipList;
    }

    /**
     * @param equipList the equipList to set
     */
    public void setEquipList(List<Equipment> equipList) {
        this.equipList = equipList;
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
     * @return the ip
     */
    public editIP getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(editIP ip) {
        this.ip = ip;
    }
    
    
}
