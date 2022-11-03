package com.springmvc.Converter;

import com.springmvc.Dto.SlideDto;
import com.springmvc.Entity.SlideEntity;

public class SlideConverter {
	public static SlideDto toDto(SlideEntity slideEntity) {
		SlideDto slideDto = new SlideDto();
		slideDto.setId(slideEntity.getId());
		slideDto.setImg(slideEntity.getImg());
		slideDto.setCaption(slideEntity.getCaption());
		slideDto.setContent(slideEntity.getContent());
		return slideDto;
	}

	public static SlideEntity toEntity(SlideDto slideDto) {
		SlideEntity slideEntity = new SlideEntity();
		slideEntity.setImg(slideDto.getImg());
		slideEntity.setCaption(slideDto.getCaption());
		slideEntity.setContent(slideDto.getContent());
		return slideEntity;
	}
}
