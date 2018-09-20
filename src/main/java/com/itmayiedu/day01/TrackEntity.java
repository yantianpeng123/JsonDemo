package com.itmayiedu.day01;

import java.util.List;

public class TrackEntity {
   private String  billcode;
   private List<detailEntity> detail;

    public String getBillcode() {
        return billcode;
    }

    public List<detailEntity> getDetail() {
        return detail;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public void setDetail(List<detailEntity> detail) {
        this.detail = detail;
    }
}
