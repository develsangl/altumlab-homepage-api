package kr.altumlab.homepage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@Setter @Getter
@MappedSuperclass
public class AuditEntity extends AbstractEntity {
	/**
	 * created on
	 */
	LocalDateTime created;

	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="created_by")
	String createdBy;
	
	/**
	 * updated on
	 */
	@JsonIgnore
	LocalDateTime updated;

//    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="updated_by")
    String updatedBy;

}
