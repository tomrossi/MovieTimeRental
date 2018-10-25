package movietime.core.user;

import movietime.core.card.RentalCard;
import movietime.core.ordermanager.Order;

public abstract class AbsUser implements User {

	private int id_user; 
	private String name; 
	private String surname;
	private String address;
	private String phone;
	private String e_mail;
	private String username;
	private String password;
	private String admin; 
	private Order myOrder;
	private RentalCard rentalcard;

	
	public AbsUser(int id_user, String name, String surname, String address, String phone, String e_mail,
			String username, String password, String admin) {
		this.id_user = id_user;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.e_mail = e_mail;
		this.username = username;
		this.password = password;
		this.admin = admin;
		myOrder = new Order();

	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id_user;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}

	@Override
	public String getE_mail() {
		// TODO Auto-generated method stub
		return e_mail;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public RentalCard getRentalcard() {
		// TODO Auto-generated method stub
		return rentalcard;
	}

	@Override
	public String getAdmin() {
		// TODO Auto-generated method stub
		return admin;
	}

	@Override
	public Order getMyOrder() {
		// TODO Auto-generated method stub
		return myOrder;
	}

	@Override
	public void setRentalCard(RentalCard card) {
		this.rentalcard = card;

	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setMyOrder(Order myOrder) {
		this.myOrder = myOrder;
	}

	public void setRentalcard(RentalCard rentalcard) {
		this.rentalcard = rentalcard;
	}

}
