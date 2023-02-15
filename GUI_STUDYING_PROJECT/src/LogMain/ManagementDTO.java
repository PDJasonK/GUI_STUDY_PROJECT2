package LogMain;

import java.sql.Date;

public class ManagementDTO {
private int seq;
private String id;
private String password;
private String name;
private String gender;
private String tel;
private String email;
private String point;
private Date createDate;


public String getId() {
   return id;
}
public void setId(String id) {
    this.id = id;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}

public String getTel() {
    return tel;
}
public void setTel(String tel) {
    this.tel = tel;
}

public String getPoint() {
    return point;
}
public void setPoint(String point) {
    this.point = point;
}

@Override
public String toString() {
    return "ManagementDTO [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name + ", gender="
            + gender + ", tel=" + tel + ", email=" + email + ", createDate=" + createDate + ", point=" + point +"]";
   }
}