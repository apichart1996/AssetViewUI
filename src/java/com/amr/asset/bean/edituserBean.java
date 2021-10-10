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
public class edituserBean {
    private String email;
    private String building;
    private String floor;
    private String room;
    private String userName;
    private String nickName;
    private String empNo;
    private String firstName;
    private String lastName;
    private String passWord;
    private String telIn;
    private String telNo;
    private String tableNo;
    private String cfpassWord;
    private String id;
    
    private String empno;
    
    private URL url;
    private BufferedReader br = null;
    private String errorMessage;
    
    private List<Signup> signList = new ArrayList<>();
    editIP ip = new editIP();
    
    public edituserBean(){
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
                id = jsonObj.get("id").toString();
                System.out.println(id);
                email = jsonObj.get("email").toString();
                System.out.println(email);
                building = jsonObj.get("building").toString();
                System.out.println(building);
                floor = jsonObj.get("floor").toString();
                System.out.println(floor);
                room = jsonObj.get("room").toString();
                System.out.println(room);
                userName = jsonObj.get("userName").toString();
                System.out.println(userName);
                telIn = jsonObj.get("telIn").toString();
                System.out.println(telIn);
                passWord = jsonObj.get("passWord").toString();
                System.out.println(passWord);
                firstName = jsonObj.get("firstName").toString();
                System.out.println(firstName);
                lastName = jsonObj.get("lastName").toString();
                System.out.println(lastName);
                empNo = jsonObj.get("empNo").toString();
                System.out.println(empNo);
                nickName = jsonObj.get("nickName").toString();
                System.out.println(nickName);
                telNo = jsonObj.get("telNo").toString();
                System.out.println(telNo);
                tableNo = jsonObj.get("tableNo").toString();
                System.out.println(tableNo);
            }
            

        } catch (MalformedURLException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(signupDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String validatEdit(){
        String line;
        int i;
        String parameters = "";
        if(!id.equals("")){
            System.out.println("id : "+id);
            parameters = parameters + "id=" + id+ "&";
        }
        if(!email.equals("")){
            System.out.println("email : "+email);
            parameters = parameters + "email=" + email+ "&";
        }
        if(!building.equals("")){
            System.out.println("email : "+building);
            parameters = parameters + "building=" + building+ "&";
        }
        if(!floor.equals("")){
            System.out.println("floor : "+floor);
            parameters = parameters + "floor=" + floor+ "&";
        }
        if(!room.equals("")){
            System.out.println("room : "+room);
            parameters = parameters + "room=" + room+ "&";
        }
        if(!userName.equals("")){
            System.out.println("userName : "+userName);
            parameters = parameters + "username=" + userName+ "&";
        }
        if(!nickName.equals("")){
            System.out.println("nickName : "+nickName);
            parameters = parameters + "nickname=" + nickName+ "&";
        }
        if(!empNo.equals("")){
            System.out.println("empNo : "+empNo);
            parameters = parameters + "empno=" + empNo+ "&";
        }
        if(!firstName.equals("")){
            System.out.println("firstName : "+firstName);
            parameters = parameters + "firstname=" + firstName+ "&";
        }
        if(!lastName.equals("")){
            System.out.println("lastName : "+lastName);
            parameters = parameters + "lastname=" + lastName+ "&";
        }
        if(!passWord.equals("")){
            System.out.println("passWord : "+passWord);
            parameters = parameters + "password=" + passWord+ "&";
        }
        if(!telIn.equals("")){
            System.out.println("telIn : "+telIn);
            parameters = parameters + "telin=" + telIn+ "&";
        }
        if(!telNo.equals("")){
            System.out.println("telNo : "+telNo);
            parameters = parameters + "telno=" + telNo+ "&";
        }
        if(!tableNo.equals("")){
            System.out.println("tableNo : "+tableNo);
            parameters = parameters + "tableno=" + tableNo+ "&";
        }
        else{
            System.out.println("Please fill in the information");
            setErrorMessage("Please fill in the information");
            return getErrorMessage();
        }
        parameters = parameters.substring(0, parameters.length()-1);
        String x = ip.getIp() + "/AssetviewWS/rest/edituser?";
        System.out.println(x+parameters);
        
        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/edituser?" + parameters);
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
                    System.out.println("Edit success");
                    System.out.println("Line Edit : " + line);
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empno", line);
                    return "edituserDetail?faces-redirect=true";
                }
            }        

        } catch (MalformedURLException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(signupBean.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        return null;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * @return the floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * @return the telIn
     */
    public String getTelIn() {
        return telIn;
    }

    /**
     * @param telIn the telIn to set
     */
    public void setTelIn(String telIn) {
        this.telIn = telIn;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * @return the cfpassWord
     */
    public String getCfpassWord() {
        return cfpassWord;
    }

    /**
     * @param cfpassWord the cfpassWord to set
     */
    public void setCfpassWord(String cfpassWord) {
        this.cfpassWord = cfpassWord;
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

    /**
     * @return the tableNo
     */
    public String getTableNo() {
        return tableNo;
    }

    /**
     * @param tableNo the tableNo to set
     */
    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }
}
