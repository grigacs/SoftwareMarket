package ui;

import controller.user.UserAction;
import dao.users.UsersDataDao;
import entity.users.UsersEntity;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

@Named
@SessionScoped
public class LoginHelper implements Serializable {
	private static final long serialVersionUID = 1L;

	private UsersEntity user = null;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Date birthDate;
	private boolean sex;



	@Inject
	private UsersDataDao userDAO;
	
	@Inject
	private UserAction userAction;
	
	// valami navigator kellene ida 
	

	public void login() throws IOException {
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			addMsg(FacesMessage.SEVERITY_ERROR, "A felhasználónév és jelszó nem lehet üres!");
			return;
		}
		UsersEntity usr = userDAO.getByName(userName);
		if (usr == null) {
			addMsg(FacesMessage.SEVERITY_ERROR, "Rossz felhasználónév vagy jelszó!");
			return;
		}
		
		if (!password.equalsIgnoreCase(usr.getPassword())) {
			addMsg(FacesMessage.SEVERITY_ERROR, "Rossz felhasználónév vagy jelszó!");
			return;
		}
		user = usr;
		userName = null;
		password = null;
		addMsg(FacesMessage.SEVERITY_INFO, "Üdv, " + user.getUsername() + "!");

		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
	}
	
	public void register() throws IOException {
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			addMsg(FacesMessage.SEVERITY_ERROR, "A felhasználónév és jelszó nem lehet üres!");
			return;
		}
		UsersEntity usr = userDAO.getByName(userName);
		if (usr != null) {
			addMsg(FacesMessage.SEVERITY_ERROR, "A felhasználó már létezik!");
			return;
		}
		
		user = new UsersEntity(firstName,lastName,userName,password,birthDate,"female");
		userAction.setEntity(user);
		userAction.persist();
		userName = null;
		password = null;
	
		addMsg(FacesMessage.SEVERITY_INFO, "Üdv, " + user.getUsername() + "!");

		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");

	}

	public String welcome(){
		return  user.getUsername().toString();
	}
	
	public void logout() throws IOException {
		userName = null;
		password = null;
		user = null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
	}
	
	public boolean isLogined(){
		return user != null;
	}
	
	private void addMsg(Severity severity, String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, msg, msg));
	}

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}

	public UsersDataDao getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UsersDataDao userDAO) {
		this.userDAO = userDAO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	

}
