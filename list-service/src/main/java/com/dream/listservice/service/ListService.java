package com.dream.listservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dream.listservice.dto.ListDto;

@Service
public interface ListService {
	
	public List<ListDto> selectAll();

}
