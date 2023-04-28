package ph.com.alliance.ServiceChargeApp5.Ticket.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ph.com.alliance.ServiceChargeApp5.Attachment.entity.Attachment;
import ph.com.alliance.ServiceChargeApp5.User.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id", nullable = false)
	@Getter
	@Setter
	private int ticket_id;

	@Column(name = "ticket_title", nullable = false)
	@Getter
	@Setter
	private String ticket_title;

	@Column(name = "ticket_description", nullable = false)
	@Getter
	@Setter
	private String ticket_description;

	@Column(name = "ticket_status", nullable = false)
	@Getter
	@Setter
	private String ticket_status;

	@Column(name = "date_created", nullable = false)
	@Getter
	@Setter
	private LocalDateTime date_created;

	@Column(name = "date_closed")
	@Getter
	@Setter
	private LocalDateTime date_closed;

	@Column(name = "last_updated")
	@Getter
	@Setter
	private LocalDateTime last_updated;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_owner_id")
	@Getter
	@Setter
	private User ticket_owner_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_assignee_id")
	@Getter
	@Setter
	private User ticket_assignee_id;


	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Attachment> attachments = new ArrayList<>();

}
