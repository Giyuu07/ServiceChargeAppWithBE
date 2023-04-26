package ph.com.alliance.ServiceChargeApp5.User.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tokens")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String token;
    
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private LocalDateTime expiryDate;

    // additional fields and methods
}