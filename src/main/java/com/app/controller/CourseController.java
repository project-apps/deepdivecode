package com.app.controller;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.dto.DirectoryNode;
import com.app.exception.CourseContentNotFoundException;
import com.app.service.CourseServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = {"/course"})
public class CourseController extends AbstractGenericController{

	@Autowired
	protected CourseServiceImpl courseService;

	@GetMapping("/{course}")
	public ModelAndView home(@PathVariable(required = true) String course, HttpServletRequest request) {
		ModelAndView mv = new  ModelAndView("course.page");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			responseEntity = courseService.courseHomePage(course);
			mv.addObject("courseContent", responseEntity.getBody());
			request.setAttribute("course", course);
		}catch (RestClientException ex) {
			request.setAttribute("HttpStatus", responseEntity.getStatusCode());
			ex.printStackTrace();
			throw new RestClientException(ex.getMessage(), ex);
		}
		return mv;		
	}

	/*
	 * @GetMapping(path = {"/index/{course}"},produces =
	 * {MediaType.APPLICATION_JSON_VALUE} ) public String
	 * listCourseContent(@PathVariable String course, HttpServletRequest request) {
	 * ResponseEntity<String> responseEntity = new
	 * ResponseEntity<String>(HttpStatus.NOT_FOUND); try { responseEntity =
	 * courseService.listCourseContent(course); }catch (RestClientException ex) {
	 * request.setAttribute("HttpStatus", responseEntity.getStatusCode());
	 * ex.printStackTrace(); throw new
	 * CourseContentNotFoundException(ex.getMessage(), ex); } return
	 * responseEntity.getBody(); }
	 */

	@GetMapping("/{course}/{page}")
	public ModelAndView getFileContent(@PathVariable(required = true) String course, @PathVariable String page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("course.page");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			responseEntity = courseService.getFileContent(getFileUri(course, page));
			mv.addObject("courseContent", responseEntity.getBody());
			request.setAttribute("course", course);
			mv.addObject("pageTitle", page);
		} catch (RestClientException ex) {
			request.setAttribute("HttpStatus", responseEntity.getStatusCode());
			logger.error(ex.getMessage());
			ex.printStackTrace();
			throw new CourseContentNotFoundException(ex.getMessage(), ex);
		} catch (IOException e) { logger.error(e.getMessage()); e.printStackTrace(); }

		return mv;
	}
	@PostMapping("/{course}/{page}")
	public ModelAndView loadFileContent(@PathVariable(required = true) String course, @PathVariable String page, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("course.content");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		try {
			responseEntity = courseService.getFileContent(getFileUri(course, page));
			mv.addObject("courseContent", responseEntity.getBody());
			request.setAttribute("course", course);
			mv.addObject("pageTitle", page);
		} catch (RestClientException ex) {
			request.setAttribute("HttpStatus", responseEntity.getStatusCode());
			ex.printStackTrace();
			throw new CourseContentNotFoundException(ex.getMessage(), ex);
		} catch (IOException e) { e.printStackTrace(); }

		return mv;
	}

	@GetMapping("/links/{course}")
	public DirectoryNode getCourseLinks(@PathVariable(required = true) String course, HttpServletRequest request) {
		DirectoryNode dirNode = courseService.listCourseContent(course);
		return dirNode;
	}

	private String getFileUri(String course, String fileUri) throws IOException {
		fileUri =  fileUri.replaceAll("_", "/");
		return course+"/"+fileUri;
	}
}
