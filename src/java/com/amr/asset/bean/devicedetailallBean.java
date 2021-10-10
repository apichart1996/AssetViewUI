/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amr.asset.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author evolu
 */

@ManagedBean
@RequestScoped
public class devicedetailallBean {
        private List<Equipment> equipList = new ArrayList<>();
        private URL url;
        private BufferedReader br = null;
        
        editIP ip = new editIP();
        public devicedetailallBean(){
            int i;
            
            try{
                url = new URL(ip.getIp()+"/AssetviewWS/rest/deviceall");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                System.out.println("ooo : "+ urlConnection);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
                JSONArray data = new JSONArray(br.readLine());
                System.out.println("br.readLine() : "+br.readLine());
                
                for (i = 0; i < data.length(); i++) {
                    JSONObject jsonObj = data.getJSONObject(i);
                    Equipment equip = new Equipment();
                    equip.setId(jsonObj.get("id").toString());
                    equip.setType(jsonObj.get("type").toString());
                    equip.setBrand(jsonObj.get("brand").toString());
                    equip.setModel(jsonObj.get("model").toString());
                    equip.setSerialNo(jsonObj.get("serialNo").toString());
                    equip.setEmpNo(jsonObj.get("empNo").toString());
                    equipList.add(equip);
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            }
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
}
