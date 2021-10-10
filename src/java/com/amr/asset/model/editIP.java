/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amr.asset.model;

/**
 *
 * @author evolu
 */
public class editIP {
        private String ip = "http://192.168.1.10:8080";
        
        public String getIp(){
            return ip;
        }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
