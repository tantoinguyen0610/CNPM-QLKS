package HongThang;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table name="t_book";

public class Book {
	@Id
	private String ID;
	private String name;
	private Date date;
	
	@Override
	public String toString() {
		return "Book [ID=" + ID + ", name=" + name + ", date=" + date + "]";
	}

	public Book() {
		super();
	}
	
	public Book(String iD, String name, Date date) {
		super();
		ID = iD;
		this.name = name;
		this.date = date;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
