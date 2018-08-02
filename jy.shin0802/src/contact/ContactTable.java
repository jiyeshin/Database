package contact;

import java.sql.Date;

public class ContactTable {
 private int num;
 private String name;
 private String phone;
 private String email;
 private Date bday;
 
 
 
@Override
public String toString() {
	return "ContactTable [num=" + num + ", name=" + name + ", phone=" + phone + ", email=" + email + ", bday=" + bday
			+ "]";
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBday() {
	return bday;
}
public void setBday(Date bday) {
	this.bday = bday;
}
 
}
