package dao.products;

/**
 * Created by grigacs on 4/21/2016.
 */
public class windowsClass {
    private String  date;
    private String pName;
    private int countNum;

    public windowsClass(String date, String pName, int countNum) {
        this.date = date;
        this.pName = pName;
        this.countNum = countNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
    }
}
