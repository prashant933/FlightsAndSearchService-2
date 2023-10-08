package com.prashant.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airplanes")
@EntityListeners(AuditingEntityListener.class)
public class Airplane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Integer id;
	@Nonnull
	@Column(name = "modelnumber")
	private String modelNumber;
	@Nonnull
	private Integer capacity;
	@CreatedDate
	@Nonnull
	@Column(name = "createdat")
	private LocalDateTime createdAt;
	@LastModifiedDate
	@Nonnull
	@Column(name = "updatedat")
	private LocalDateTime updatedAt;
}
