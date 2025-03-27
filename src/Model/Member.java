package Model;

import java.sql.Date;

public class Member {
    private String ID;
    private String PWD;
    private String NAME;
    private String GENDER;
    private int AGE;
    private Date BIRTHDAY;
    private String PHONE;
    private Date REGDATE;

    public Member(String ID, String PWD, String NAME, String GENDER, int AGE, Date BIRTHDAY, String PHONE) {
        this.ID = ID;
        this.PWD = PWD;
        this.NAME = NAME;
        this.GENDER = GENDER;
        this.AGE = AGE;
        this.BIRTHDAY = BIRTHDAY;
        this.PHONE = PHONE;
    }
    public Member(String ID, String PWD, String NAME, String GENDER, int AGE, Date BIRTHDAY, String PHONE, Date REGDATE) {
        this.ID = ID;
        this.PWD = PWD;
        this.NAME = NAME;
        this.GENDER = GENDER;
        this.AGE = AGE;
        this.BIRTHDAY = BIRTHDAY;
        this.PHONE = PHONE;
        this.REGDATE = REGDATE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public java.sql.Date getBIRTHDAY() {
        return BIRTHDAY;
    }

    public void setBIRTHDAY(Date BIRTHDAY) {
        this.BIRTHDAY = BIRTHDAY;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public Date getREGDATE() {
        return REGDATE;
    }

    public void setREGDATE(Date REGDATE) {
        this.REGDATE = REGDATE;
    }
}
