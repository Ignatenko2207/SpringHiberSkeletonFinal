package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "object2" )
public class PojoObject2 {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column( name = "pojo_id" )
	private Integer id;
	
	@Column( name = "text_field" )
	private String textField;
	
	@Column( name = "condition" )
	private Boolean condition;
}
