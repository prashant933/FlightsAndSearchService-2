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
@Table(name = "airports")
@EntityListeners(AuditingEntityListener.class)
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Integer id;
	@Nonnull
	private String name;
	@Nonnull
	@Column(name = "cityid")
	private Integer cityId;
	@CreatedDate
	@Nonnull
	@Column(name = "createdat")
	private LocalDateTime createdAt;
	@LastModifiedDate
	@Nonnull
	@Column(name = "updatedat")
	private LocalDateTime updatedAt;
}
