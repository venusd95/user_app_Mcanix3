package com.mcanics.user_app.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_mechanics")
@NoArgsConstructor
public class Mechanic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer mechId;
	    private String firstName;
	    private String lastName;
	    private String mobileNumber;
	    private String email;
	    private String password;
        private String adharNumber;
		public Mechanic(Integer mechId, String firstName, String lastName, String mobileNumber, String email,
				String password, String adharNumber) {
			super();
			this.mechId = mechId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.mobileNumber = mobileNumber;
			this.email = email;
			this.password = password;
			this.adharNumber = adharNumber;
		}
      
		
        
}
