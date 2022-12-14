package com.springmvc.Converter;

import com.springmvc.Dto.BillDto;
import com.springmvc.Entity.BillEntity;

public class BillConverter {
	public static BillDto toDto(BillEntity billEntity) {
		BillDto billDto = new BillDto();
		billDto.setId(billEntity.getId());
		billDto.setId_user(billEntity.getId_user());
		billDto.setEmail(billEntity.getEmail());
		billDto.setPhone(billEntity.getPhone());
		billDto.setFullname(billEntity.getFullname());
		billDto.setAddress(billEntity.getAddress());
		billDto.setTotal(billEntity.getTotal());
		billDto.setQuanty(billEntity.getQuanty());
		billDto.setNote(billEntity.getNote());
		billDto.setSign(billEntity.getSign());
		billDto.setFile(billEntity.getFile());
		billDto.setData(billEntity.getData());
		billDto.setPubkey(billEntity.getPubkey());
		billDto.setStatus(billEntity.getStatus());
		return billDto;
	}

	public static BillEntity toEntity(BillDto billDto) {
		BillEntity billEntity = new BillEntity();
		billEntity.setId_user(billDto.getId_user());
		billEntity.setEmail(billDto.getEmail());
		billEntity.setPhone(billDto.getPhone());
		billEntity.setFullname(billDto.getFullname());
		billEntity.setAddress(billDto.getAddress());
		billEntity.setTotal(billDto.getTotal());
		billEntity.setQuanty(billDto.getQuanty());
		billEntity.setNote(billDto.getNote());
		billEntity.setSign(billDto.getSign());
		billEntity.setFile(billDto.getFile());
		billEntity.setData(billDto.getData());
		billEntity.setPubkey(billDto.getPubkey());
		billEntity.setStatus(billDto.getStatus());
		return billEntity;
	}
}
