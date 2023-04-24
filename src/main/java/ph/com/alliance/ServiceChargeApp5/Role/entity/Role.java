package ph.com.alliance.ServiceChargeApp5.Role.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;

import javax.persistence.Column;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;


@AllArgsConstructor
@NoArgsConstructor
@Table(name="roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Role {
    @Id
    @Column(name="role_id", nullable = false)
    @Getter
    @Setter
    private int role_id;

    @Column(name="role_name", nullable = false)
    @Getter
    @Setter
    private String role_name;

    @Column(name="role_desc")
    @Getter
    @Setter
    private String role_desc;
    
    @OneToMany(mappedBy = "role")
    private List<User> users;
    
}


