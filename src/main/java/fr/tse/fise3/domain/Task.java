package fr.tse.fise3.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "please set a value for the title")
	@NotNull(message = "please set a value for the title")
	private String title;
	@NotNull(message = "please set a value for the nbHoursForecast ")
	@Min(value = 0,message = "the value should be greater then 0")
	@Max(value = 144,message = "the value should be less then 144")
	private Integer nbHoursForecast;
	
	@NotNull(message = "please set a value for the nbHoursReal ")
	@Min(value = 0,message = "the value should be greater then 0")
	@Max(value = 144,message = "the value should be less then 144")
	private Integer nbHoursReal;
	private LocalDate created;

	@ManyToOne
	@Valid
	@NotNull(message = "please set a value for the type")
	private TaskType type;

	@ManyToOne
	@Valid
	@NotNull(message = "please set a value for the status")
	private TaskStatus status;

	@ManyToMany(fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("tasks")
	@NotNull(message = "please set a value for the developers")
	private Set<Developer> developers;

	@OneToMany(mappedBy = "task", cascade = { CascadeType.ALL }, orphanRemoval = true)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonIgnoreProperties("task")
	private Set<ChangeLog> changeLogs;

	public Task() {
		this.developers = new HashSet<Developer>();
	    this.changeLogs = new HashSet<ChangeLog>();
	}

	public void addDeveloper(Developer dev) {
		dev.getTasks().add(this);
		this.developers.add(dev);
	}

	public void addChangeLog(ChangeLog changeLog) {
		changeLog.setTask(this);
		this.changeLogs.add(changeLog);
	}

	public void clearChangeLogs() {
		for (ChangeLog changeLog : this.changeLogs) {
			changeLog.setTask(null);
		}
	}

}
