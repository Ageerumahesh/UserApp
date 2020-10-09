package com.mini.proj.service;

import java.util.List;

import com.mini.proj.dao.Contact;
import com.mini.proj.dto.ContactDTO;

public interface ContactService {

	public boolean saveContact(Contact dto);

	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	
	public boolean updatContact(ContactDTO dto);
	
	public boolean deleteContact(Integer cid);

	
}
