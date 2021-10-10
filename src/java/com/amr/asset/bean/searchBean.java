package com.amr.asset.bean;

import com.amr.asset.model.User;
import com.amr.asset.model.Equipment;
import com.amr.asset.model.SearchResult;
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
public class searchBean {
    private String search;
    private String empno;
    private String firstName;
    private List<SearchResult> searchResult = new ArrayList<>();
    private String errorMessage;
    
    //search
    private String sempNo;
    private String semail;
    private String sserial;
    private String stype;
    private String sbrand;
    
    
    private URL url;
    private BufferedReader br = null;
    
    private List<User> userList = new ArrayList<>();
    private List<Equipment> equipList = new ArrayList<>();
    editIP ip = new editIP();
    
    public searchBean(){
        
    }
    
    public String validatSearch(){
        int i;
        String line;
        String parameters = "";
        if(!sempNo.equals("")){
            System.out.println("sempNo : "+sempNo);
            parameters = parameters + "empno=" + sempNo+ "&";
        }
        if(!semail.equals("")){
            System.out.println("semail : "+semail);
            parameters = parameters + "username=" + semail+ "&";
        }
        if(!sserial.equals("")){
            System.out.println("sserial : "+sserial);
            parameters = parameters + "serialno=" + sserial+ "&";
        }
        if(!stype.equals("0")){
            System.out.println("stype : "+stype);
            parameters = parameters + "type=" + stype+ "&";
        }
        if(!sbrand.equals("0")){
            System.out.println("sbrand : "+sbrand);
                    parameters = parameters + "brand=" + sbrand+ "&";
        }
        parameters = parameters.substring(0, parameters.length()-1);
        String x = ip.getIp() + "/AssetviewWS/rest/search?";
        System.out.println(x+parameters);

        try {
            url = new URL(ip.getIp() + "/AssetviewWS/rest/search?"+ parameters);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            System.out.println("ooo : "+ urlConnection);
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("in : "+in);
            br = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            System.out.println("br : "+br);
            JSONArray data = new JSONArray(br.readLine());
            line = br.readLine();
            System.out.println("line : "+line);

                for(i=0;i<data.length();i++){
                    System.out.println("zz : "+data);
                    JSONObject jsonObj  = data.getJSONObject(i);
                    SearchResult result = new SearchResult();
                    result.setName(jsonObj.get("name").toString());
                    result.setNickName(jsonObj.get("nickName").toString());
                    result.setEmpNo(jsonObj.get("empNo").toString());
                    searchResult.add(result);
                }

        } catch (MalformedURLException ex) {
            errorMessage = "Data not found";
        } catch (IOException ex) {
            errorMessage = "Data not found";
        } catch (JSONException ex) {
            Logger.getLogger(searchBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e) {
            errorMessage = "Data not found";
        }
        
        return null;
    }

    public String doSearchDetail(){
        System.out.println("SearchDetail : " + empno);
        System.out.println("test 1");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empnoSearch", empno);
        return "searchDetail?faces-redirect=true";
    } 
    
    /**
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(String search) {
        this.search = search;
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
     * @return the searchResult
     */
    public List<SearchResult> getSearchResult() {
        return searchResult;
    }

    /**
     * @param searchResult the searchResult to set
     */
    public void setSearchResult(List<SearchResult> searchResult) {
        this.searchResult = searchResult;
    }

    /**
     * @return the sempNo
     */
    public String getSempNo() {
        return sempNo;
    }

    /**
     * @param sempNo the sempNo to set
     */
    public void setSempNo(String sempNo) {
        this.sempNo = sempNo;
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
     * @return the sserial
     */
    public String getSserial() {
        return sserial;
    }

    /**
     * @param sserial the sserial to set
     */
    public void setSserial(String sserial) {
        this.sserial = sserial;
    }

    /**
     * @return the stype
     */
    public String getStype() {
        return stype;
    }

    /**
     * @param stype the stype to set
     */
    public void setStype(String stype) {
        this.stype = stype;
    }

    /**
     * @return the sbrand
     */
    public String getSbrand() {
        return sbrand;
    }

    /**
     * @param sbrand the sbrand to set
     */
    public void setSbrand(String sbrand) {
        this.sbrand = sbrand;
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
     * @return the semail
     */
    public String getSemail() {
        return semail;
    }

    /**
     * @param semail the semail to set
     */
    public void setSemail(String semail) {
        this.semail = semail;
    }
    
    
}
