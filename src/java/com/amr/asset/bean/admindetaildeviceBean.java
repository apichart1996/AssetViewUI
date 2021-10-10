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



@ManagedBean
@RequestScoped
public class admindetaildeviceBean {
    private String empno;
    private String id;
    private String delete;
    private String edituser;
    
    private List<String> s = new ArrayList<>();
    private List<Equipment> equipList = new ArrayList<>();
    
    private URL url;
    private BufferedReader br = null;

    editIP ip = new editIP();
    public admindetaildeviceBean() {
        int i;
        System.out.println("hello userdetailbean");
        empno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empno");
        System.out.println("empno : "+empno);
   
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
                equip.setName(jsonObj.get("name").toString());
                equip.setType(jsonObj.get("type").toString());
                equip.setBrand(jsonObj.get("brand").toString());
                equip.setModel(jsonObj.get("model").toString());
                equip.setSerialno(jsonObj.get("serialno").toString());
                equip.setEmpno(jsonObj.get("empno").toString());
                equip.setId(jsonObj.get("id").toString());
                
                equipList.add(equip);
                

            }
            
        } catch (IOException | JSONException ex) {
            Logger.getLogger(userDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public String doEditData(){
            System.out.println("editdtail : " + id);
            System.out.println("test editdtail");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", id);
            return "editadmindevice?faces-redirect=true";
        } 
        public String doDeleteData(){
            System.out.println("delete : " + empno);
            System.out.println("test delete admin");
            
            String line;
            try {
                url = new URL(ip.getIp() + "/AssetviewWS/rest/deletedevice?id="+empno);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                System.out.println("ooo : "+ urlConnection);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                System.out.println("in : "+in);
                br = new BufferedReader(new InputStreamReader(in));
                System.out.println("br : "+br);
                line = br.readLine();
                System.out.println("line = "+line);
                while (line != null) {
                    System.out.println("br.readLine : "+br.readLine());
                    if(line != null){
                        System.out.println("Login success");
                        System.out.println("Line entered : " + line);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                        return "admindetaildevice?faces-redirect=true";
                    }
                }             
            } catch (MalformedURLException ex) {
                Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "admindetaildevice?faces-redirect=true";
        }
    
        public String doEditUser(){
            System.out.println("edituser : " + empno);
            System.out.println("test edituser");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", empno);
            return "editadmin?faces-redirect=true";
        }
    
    public String getEmpno() {
        return empno;
    }
    public void setEmpno(String empno) {
        this.empno = empno;
    }
    public List<String> getS() {
        return s;
    }
    public void setS(List<String> s) {
        this.s = s;
    }
    public List<Equipment> getEquipList() {
        return equipList;
    }
    public void setUserList(List<Equipment> equipList) {
        this.equipList = equipList;
    }

    /**
     * @return the delete
     */
    public String getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(String delete) {
        this.delete = delete;
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
