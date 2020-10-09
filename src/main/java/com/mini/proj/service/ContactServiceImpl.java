package com.mini.proj.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.proj.dao.Contact;
import com.mini.proj.dao.ContactDtlsEntity;
import com.mini.proj.dao.ContactDtlsRepository;
import com.mini.proj.dto.ContactDTO;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDtlsRepository cntctDtlsRepo;

	@Override //// this method is save to contat dtls in db s/w
	public boolean saveContact(Contact cntct) {
		ContactDtlsEntity entityObj = null, savedEntityObj = null;
		entityObj = new ContactDtlsEntity();
		BeanUtils.copyProperties(cntct, entityObj);
		savedEntityObj = cntctDtlsRepo.save(entityObj);
		return savedEntityObj.getCid() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> cntcts = new ArrayList<Contact>();
		Iterator<ContactDtlsEntity> itrCntctDtlsEntity = null;
		List<ContactDtlsEntity> cntctsEntity = cntctDtlsRepo.findAll();
		itrCntctDtlsEntity = cntctsEntity.iterator();
		while (itrCntctDtlsEntity.hasNext()) {
			ContactDtlsEntity entityObj  = itrCntctDtlsEntity.next();
			Contact cntctObj = new Contact();
			BeanUtils.copyProperties(entityObj, cntctObj);
		    cntcts.add(cntctObj);
		}
		return cntcts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Contact cntct = null;
		ContactDtlsEntity cntctEnty = null;
		cntct = new Contact();
		cntctEnty = cntctDtlsRepo.getOne(cid);
		BeanUtils.copyProperties(cntctEnty, cntct);
		System.out.println("=================service"+cntct);
		return cntct;
		
	}

	@Override
	public boolean updatContact(ContactDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		cntctDtlsRepo.deleteById(cid);
		return true;
	}

}
