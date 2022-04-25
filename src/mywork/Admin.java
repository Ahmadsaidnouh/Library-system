/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mywork;

/**
 *
 * @author Ahmad Nouh
 */
public class Admin {
    private String adminName;
    private String adminPassword;
    public Admin(String adminName, String adminPassword)
    {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }
    
}
