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
public class manageuserBean {
        private List<User> userList = new ArrayList<>();
        private URL url;
        private BufferedReader br = null;
        private String id;
        private String edituser;
        editIP ip = new editIP();
        
        public manageuserBean(){
            int i;
            
            try{
                url = new URL(ip.getIp() + "/AssetviewWS/rest/userall");
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
                    user.setPassWord(jsonObj.get("passWord").toString());
                    user.setUserName(jsonObj.get("userName").toString());
                    userList.add(user);
                    
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | JSONException ex) {
                Logger.getLogger(userdetailallBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public String doDeleteData(){
            System.out.println("delete : " + id);
            System.out.println("test delete");
            
            String line;
            try {
                url = new URL(ip.getIp() + "/AssetviewWS/rest/deleteuser?id="+id);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                System.out.println("ooo : "+ urlConnection);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                System.out.println("in : "+in);
                br = new BufferedReader(new InputStreamReader(in));
                System.out.println("br : "+br);
                line = br.readLine();
                System.out.println("line = "+line);
                while (line == null) {
                    System.out.println("br.readLine : "+br.readLine());
                    if(line == null){
                        System.out.println("Login success");
                        System.out.println("Line entered : " + line);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                        return "manageuser?faces-redirect=true";
                    }
                }             
            } catch (MalformedURLException ex) {
                Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "manageuser?faces-redirect=true";
        }
    
        public String doEditUser(){
            System.out.println("edituser : " + edituser);
            System.out.println("test edituser");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", edituser);
            return "edituseradmin?faces-redirect=true";
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
     * @return the edituser
     */
    public String getEdituser() {
        return edituser;
    }

    /**
     * @param edituser the edituser to set
     */
    public void setEdituser(String edituser) {
        this.edituser = edituser;
    }
}
