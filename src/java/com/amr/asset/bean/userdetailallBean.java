/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amr.asset.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.amr.asset.model.User;
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
public class userdetailallBean {
        private List<User> userList = new ArrayList<>();
        private URL url;
        private BufferedReader br = null;
        editIP ip = new editIP();
        
        public userdetailallBean(){
            int i;
            
            try{
                url = new URL(ip.getIp() +"/AssetviewWS/rest/userall");
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                System.out.println("ooo : "+ urlConnection);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
                JSONArray data = new JSONArray(br.readLine());
                System.out.println("br.readLine() : "+br.readLine());
                
                for (i = 0; i < data.length(); i++) {
                    JSONObject jsonObj = data.getJSONObject(i);
                    User user = new User();
                    user.setId(jsonObj.get("id").toString());
                    user.setEmpNo(jsonObj.get("empNo").toString());
                    user.setFirstName(jsonObj.get("firstName").toString());
                    user.setLastName(jsonObj.get("lastName").toString());
                    user.setNickName(jsonObj.get("nickName").toString());
                    user.setEmail(jsonObj.get("email").toString());
                    user.setTelNo(jsonObj.get("telNo").toString());
                    user.setTelIn(jsonObj.get("telIn").toString());
                    user.setBuilding(jsonObj.get("building").toString());
                    user.setFloor(jsonObj.get("floor").toString());
                    user.setRoom(jsonObj.get("room").toString());
                    user.setTableNo(jsonObj.get("tableNo").toString());
                    userList.add(user);
                    
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            }
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
     * @return the userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * @param userList the userList to set
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
