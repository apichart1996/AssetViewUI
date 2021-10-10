package com.amr.asset.bean;

import com.amr.asset.model.Signup;
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
public class edituserdetailBean {
    private String empno;
    
    private URL url;
    private BufferedReader br = null;
    private String errorMessage;
    
    private List<Signup> signList = new ArrayList<>();
    editIP ip = new editIP();
    
    public edituserdetailBean(){
        int i;
        System.out.println("hello signupDetailBean");
        empno = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empno");
        System.out.println("signupDetailBean empno = "+empno);
        
        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/user/detail/"+empno);
            System.out.println("url : "+url);
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
                Signup  sign = new Signup();
//                sign.setId(jsonObj.get("id").toString());
                sign.setEmail(jsonObj.get("email").toString());
                sign.setBuilding(jsonObj.get("building").toString());
                sign.setFloor(jsonObj.get("floor").toString());
                sign.setRoom(jsonObj.get("room").toString());
                sign.setUserName(jsonObj.get("userName").toString());
                sign.setTelIn(jsonObj.get("telIn").toString());
                sign.setFirstName(jsonObj.get("firstName").toString());
                sign.setLastName(jsonObj.get("lastName").toString());
                sign.setEmpNo(jsonObj.get("empNo").toString());
                sign.setNickName(jsonObj.get("nickName").toString());
                sign.setTelNo(jsonObj.get("telNo").toString());
                sign.setTableNo(jsonObj.get("tableNo").toString());
                signList.add(sign); 
            }
            

        } catch (MalformedURLException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(signupDetailBean.class.getName()).log(Level.SEVERE, null, ex);
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
     * @return the signList
     */
    public List<Signup> getSignList() {
        return signList;
    }

    /**
     * @param signList the signList to set
     */
    public void setSignList(List<Signup> signList) {
        this.signList = signList;
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
