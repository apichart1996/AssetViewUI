package com.amr.asset.bean;

import com.amr.asset.model.editIP;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@RequestScoped
public class LoginBean {
    private String Username;
    private String Password;
    private String errorMessage;
    private String empNo;
    URL url;
    BufferedReader br;
    
    editIP ip = new editIP();
    
    boolean loggedIn = false;
    
    public boolean isLoggedIn(){
        return loggedIn;
    }
    
    public LoginBean(){
        
    }

    public String validatLogin(){
        String line;
        System.out.println("user : " +Username);
        System.out.println("Pass : " +Password);
        try {
            url = new URL(ip.getIp() +"/AssetviewWS/rest/login/"+Username+"/"+Password);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("ooo : "+ urlConnection);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("in : "+in);
            br = new BufferedReader(new InputStreamReader(in));
            System.out.println("br : "+br);
            line = br.readLine();
            
            while (line != null) {
                System.out.println("br.readLine : "+br.readLine());
                
                if("Owner".equals(line)){
                    System.out.println("Hello admin");
                    System.out.println("Login success");
                    System.out.println("Line entered : " + line);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                    return "admindetaildevice?faces-redirect=true";
                }
                else if(line != null){
                    System.out.println("Login success");
                    System.out.println("Line entered : " + line);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                    return "userDetail?faces-redirect=true";
                }
            }
            System.out.println("Loin unsuccessful");
            errorMessage = "incorrect username or password";
            return errorMessage;
            
        } catch (MalformedURLException ex) {
            errorMessage = "invalid username or password";
        } catch (IOException ex) {
            errorMessage = "invalid username or password";
        }
        
        return null;

    }
    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    private void readStream(InputStream in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the empNo
     */
    public String getEmpNo() {
        return empNo;
    }

    /**
     * @param empNo the empNo to set
     */
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
    
    
}
