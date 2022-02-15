package com.mcanics.user_app.data.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_users")
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer userId;
	    private String firstName;
	    private String lastName;
	    private String mobileNumber;
	    private String email;
	    private String password;
        private String adharNumber;
      
        
    	public User(Integer userId, String firstName, String lastName, String mobileNumber, String email,
				String password, String adharNumber, Mechanic mechanic) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.mobileNumber = mobileNumber;
			this.email = email;
			this.password = password;
			this.adharNumber = adharNumber;
			this.mechanic = mechanic;
		}
 
    	@OneToOne(cascade=CascadeType.ALL)	
    	@JoinColumn(name="mechanic_id")
    	private Mechanic mechanic;


	


   }
            

