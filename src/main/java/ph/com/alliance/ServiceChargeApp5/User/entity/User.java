package ph.com.alliance.ServiceChargeApp5.User.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId", nullable = false)
	@Getter
	@Setter
	private int userId;
	
	@Column(name="userName", nullable = false)
	@Getter
	@Setter
	private String userName;
	
	@Column(name="userEmail", nullable = false)
	@Getter
	@Setter
	private String userEmail;
	
	@Column(name="userPassword", nullable = false)
	@Getter
	@Setter
	private String userPassword;
	
	@Column(name="userRole", nullable = false)
	@Getter
	@Setter
	private String userRole;
	
	@Column(name="createdAt", nullable = false)
	@Getter
	@Setter
	private String createdAt;
}

//@Data

//public class User {
//	private String userId;
//	private String userName;
//	private String userEmail;
//	private String userPassword;
//	private String userRole;
//	private String createdAt;
//
//
//}
