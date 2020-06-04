package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.entity.dto.PincodeDto;
import com.app.entity.dto.ServiceDto;
import com.app.service.APICallService;
import com.app.service.PropReader;
import com.app.util.WebAppConstants;

@RestController
@RequestMapping(path = {"/service"})
public class ServiceController extends AbstractGenericController {
	@Autowired
	private APICallService apiCallService;
	@Autowired
	protected PropReader propReader;
	@GetMapping(path = {"/pincode"})
	public ModelAndView pincodePage(@ModelAttribute PincodeDto pincodeDto, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("service.pincode");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			
			if(!StringUtils.isEmpty(pincodeDto.getPincode())) {
				UriComponents uriComponents= UriComponentsBuilder.fromPath(WebAppConstants.PINCODE_URI)
						.path("/").path(pincodeDto.getDataView()).path("/").path(pincodeDto.getPincode()).build();
				responseEntity = apiCallService.exchange(uriComponents);
				mv.addObject("pincodeJSON", responseEntity.getBody());
			}
		} catch (RestClientException ex) {
			request.setAttribute("HttpStatus", responseEntity.getStatusCode());
			ex.printStackTrace();
			throw new RestClientException(ex.getMessage(), ex);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mv.addObject(pincodeDto);
		return mv;
	}
	
	@GetMapping(path = {"/list"})
	public ModelAndView listServices() {
		ModelAndView mv = new ModelAndView("service.list");
		List<ServiceDto> serviceList = new ArrayList<ServiceDto>();
		ServiceDto service = new ServiceDto();
		serviceList.add(service);
		service.setName("Pincode");
		service.setDesc("Search location details.");
		service.setAction("/service/pincode");
		service.setImageUrl("mbri-map-pin mbr-iconfont mbr-iconfont-btn");
		mv.addObject("serviceList",serviceList);
		return mv;		
	}
}