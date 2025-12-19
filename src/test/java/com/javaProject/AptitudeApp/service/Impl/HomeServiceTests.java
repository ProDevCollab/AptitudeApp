package com.javaProject.AptitudeApp.service.Impl;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.javaProject.AptitudeApp.dao.ICategoryRepo;
import com.javaProject.AptitudeApp.dao.ITopicRepo;
import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.exception.CategoryNotFoundException;
import com.javaProject.AptitudeApp.model.Category;
import com.javaProject.AptitudeApp.model.Topic;


@ExtendWith(MockitoExtension.class)
public class HomeServiceTests {
	
	@Mock
	private ICategoryRepo categoryRepo;
	@Mock
    private ITopicRepo topicRepo;
	
	@InjectMocks
	private HomeService homeService;
	@InjectMocks
	private TopicService topicService;
	
	@Test
	public void testGetAllCategories() {
		
		Mockito.when(categoryRepo.findAll()).thenReturn(List.of(new Category("Quantitative Aptitude"), new Category("Logical Aptitude")));
		List<CategoryDto> allCats = homeService.getAllCategories();
		
		assertEquals(2, allCats.size());
		assertEquals("Quantitative Aptitude", allCats.get(0).getCategoryName());
		assertEquals("Logical Aptitude", allCats.get(1).getCategoryName());
		
	}
	
	//test for - if no categories found in db
	@Test
	public void testGetAllCategories_NoData(){
		
		Mockito.when(categoryRepo.findAll()).thenReturn(List.of());
		List<CategoryDto> allCats = homeService.getAllCategories();
		
		assertEquals(0, allCats.size());
		
	}	
	
	
	@Test
	public void testGetTopicsByCategory() {
		long categoryId = 2L;
//		Category c = new Category("Logical Aptitude");
		Optional<Category> opCat = Optional.of(new Category("Logical Aptitude"));
		Mockito.when(categoryRepo.findById(categoryId)).thenReturn(opCat); //write test case for exception case as well
		
		Mockito.when(topicRepo.findByCategory(opCat.get())).thenReturn(List.of(new Topic("Clocks", opCat.get(), "clocks"), new Topic("Calendar", opCat.get(), "calendar")));
		
		List<TopicDto> topics = homeService.getTopicsByCategory(categoryId);
		
		assertEquals(2, topics.size());
		assertEquals(null,topics.get(0).getTopicId());
		assertEquals("Clocks",topics.get(0).getTopicName());
		assertEquals(null,topics.get(1).getTopicId());
		assertEquals("Calendar",topics.get(1).getTopicName());
		
	}

	//input missing - no need to test for service b/c when input would be missing 
    //				  it will give be caught at controller level only and will not call service method
	

	//invalid type of input - no need to test for service b/c when input would be missing 
    //				  it will give be caught at controller level only and will not call service method
	
	//invalid input- categoryId not found
	@Test
	public void testGetTopicsByCategory_InvalidId() {
		Long categoryId = 203L;		
		Mockito.when(categoryRepo.findById(categoryId)).thenThrow(new CategoryNotFoundException("Category Not found with id : " + categoryId));
		
		CategoryNotFoundException exp = assertThrows(CategoryNotFoundException.class, () ->	
		homeService.getTopicsByCategory(categoryId));
		
		assertEquals("Category Not found with id : " + categoryId, exp.getMessage());		
		
	}
	
	//empty topic list -when no topic is found in db for that category id
	@Test
	public void testGetTopicsByCategory_NoTopicFound() {
		Long categoryId = 2L;
		Optional<Category> cat = Optional.of(new Category("Logical Aptitude"));
		Mockito.when(categoryRepo.findById(categoryId)).thenReturn(cat);
		Mockito.when(topicRepo.findByCategory(cat.get())).thenReturn(List.of());
		
		List<TopicDto> topics = homeService.getTopicsByCategory(categoryId);
		assertEquals(0,topics.size());	
		
		
	}
	
	
	
	
	
	
	
	
}
