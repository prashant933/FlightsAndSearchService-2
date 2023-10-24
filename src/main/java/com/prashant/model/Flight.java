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
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flights")
@EntityListeners(AuditingEntityListener.class)
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Integer id;
	@Nonnull
	@Column(name = "flightnumber")
	private String flightNumber;
	@Nonnull
	@Column(name = "airplaneid")
	private String airplaneId;
	@Nonnull
	@Column(name = "departureairportid")
	private String departureAirportId;
	@Nonnull
	@Column(name = "arrivalairportid")
	private String arrivalAirportId;
	@Nonnull
	@Column(name = "departuretime")
	private LocalDateTime departureTime;
	@Nonnull
	@Column(name = "arrivaltime")
	private LocalDateTime arrivalTime;
	@Nonnull
	private Double price;
	@Nonnull
	@Column(name = "totalseats")
	@Min(0)
	private Integer totalSeats;
	@CreatedDate
	@Nonnull
	@Column(name = "createdat")
	private LocalDateTime createdAt;
	@LastModifiedDate
	@Nonnull
	@Column(name = "updatedat")
	private LocalDateTime updatedAt;
}
