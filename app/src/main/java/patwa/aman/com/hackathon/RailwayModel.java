package patwa.aman.com.hackathon;

/**
 * Created by dell on 10-02-2019.
 */

public class RailwayModel {

    String address,college,contact,from,name,pass_no,status,sap_id,to,duration,railwayClass;

    public RailwayModel() {
    }

    public RailwayModel(String address, String college, String contact, String from, String name, String pass_no, String status, String sap_id, String to,String duration,String railwayClass) {
        this.address = address;
        this.college = college;
        this.contact = contact;
        this.from = from;
        this.name = name;
        this.pass_no = pass_no;
        this.status = status;
        this.sap_id = sap_id;
        this.to = to;
        this.duration=duration;
        this.railwayClass=railwayClass;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRailwayClass() {
        return railwayClass;
    }

    public void setRailwayClass(String railwayClass) {
        this.railwayClass = railwayClass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass_no() {
        return pass_no;
    }

    public void setPass_no(String pass_no) {
        this.pass_no = pass_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSap_id() {
        return sap_id;
    }

    public void setSap_id(String sap_id) {
        this.sap_id = sap_id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
