package com.mini.proj.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



import lombok.Data;


@Data // provides abstraction of getter, setter , hashcode , toString 
@Entity   //this annotation specifies that the class is an entity and is mapped to a database table.
@Table(name = "contact_dtls")    //   this annotation specifies the name of the database table to be used for mapping.
public class ContactDtlsEntity {
    
	@Id    //The @Id annotation specifies the primary key of an entity
	@GeneratedValue         //@GeneratedValue provides for the specification of generation strategies for the values of primary keys.
	@Column(name = "cntct_id") //Is used to specify the mapped column for a persistent property or field. If no Column annotation is specified, the default values apply.
	private Integer cid;
	@Column(name = "cntct_name") 
	private String cname;
	@Column(name = "cntct_mail") 
	private String cmail;
	@Column(name = "cntct_num") 
	private Long  cnum;
	@Lob
	@Column(name = "cntct_Image")
	private byte[] cimage;

	

}
