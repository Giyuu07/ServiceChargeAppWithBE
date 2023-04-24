package ph.com.alliance.ServiceChargeApp5.User.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;
import ph.com.alliance.ServiceChargeApp5.Ticket.entity.Ticket;

@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id", nullable = false)
    @Getter
    @Setter
    private int user_id;

    @Column(name="username", nullable = false)
    @Getter
    @Setter
    private String username;

    @Column(name="password", nullable = false)
    @Getter
    @Setter
    private String password;
    
    @Column(name="email", nullable = false)
    @Getter
    @Setter
    private String email;
    
    @Column(name="status", nullable = false)
    @Getter
    @Setter
    private String status;
    
    @Column(name="dateCreated", nullable = false)
    @Getter
    @Setter
    private LocalDateTime dateCreated;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    @Getter
    @Setter
    private Role role;
    
    @OneToMany(mappedBy = "ticket_owner_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ownedTickets = new ArrayList<>();
    
    @OneToMany(mappedBy = "ticket_assignee_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> assignedTickets = new ArrayList<>();
    
    //Tickets management
    public void addOwnedTicket(Ticket ticket) {
        ownedTickets.add(ticket);
        ticket.setTicket_owner_id(this);
    }
    
    public void removeOwnedTicket(Ticket ticket) {
        ownedTickets.remove(ticket);
        ticket.setTicket_owner_id(null);
    }
    
    public void addAssignedTicket(Ticket ticket) {
        assignedTickets.add(ticket);
        ticket.setTicket_assignee_id(this);
    }
    
    public void removeAssignedTicket(Ticket ticket) {
        assignedTickets.remove(ticket);
        ticket.setTicket_assignee_id(null);
    }
    
    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
}




