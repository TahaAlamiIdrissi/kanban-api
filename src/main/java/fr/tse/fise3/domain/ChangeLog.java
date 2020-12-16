package fr.tse.fise3.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeLog {
	@Id
	private Long id;
	private LocalDateTime occured;
	@ManyToOne
	@JsonIgnoreProperties("changeLogs")
	private Task task;
	@ManyToOne
	private TaskStatus targetStatus;
	@ManyToOne
	private TaskStatus sourceStatus;

}
