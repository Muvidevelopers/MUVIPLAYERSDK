package com.muvi.muviplayersdk.model;

import java.io.Serializable;

/**
 * Created by Muvi on 2/10/2017.
 */
public class DownloadModel implements Serializable{

    String email = "";
    boolean restriction_status = false;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getRestrictionStatus() {
        return restriction_status;
    }

    public void setRestrictionStatus(boolean restriction_status) {
        this.restriction_status = restriction_status;
    }


}
