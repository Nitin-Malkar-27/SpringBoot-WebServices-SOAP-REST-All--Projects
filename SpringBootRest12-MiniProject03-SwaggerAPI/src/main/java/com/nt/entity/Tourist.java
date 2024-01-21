package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "REST_TOURIST")
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;

	@Column(length = 20)
	@NonNull
	private String name;

	@Column(length = 20)
	@NonNull
	private String city;

	@Column(length = 20)
	@NonNull
	private String packageType;

	@NonNull
	private Double budget;

}
