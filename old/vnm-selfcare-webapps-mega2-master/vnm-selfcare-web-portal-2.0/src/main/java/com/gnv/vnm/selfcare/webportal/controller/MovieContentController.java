/**
 * MovieContentController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gnv.vnm.selfcare.core.model.MovieCategory;
import com.gnv.vnm.selfcare.core.model.MovieContent;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/shop/content/movie")
public class MovieContentController extends WebPortalBaseController {
	
	@GetMapping(value = "/list")
	public String list(Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		List<MovieContent> MovieCategories=contentManagementService.getPromotedMovieContents();
		model.addAttribute("movieBanner",MovieCategories);
		
		List<MovieCategory> categories = contentManagementService.getMovieCategories();
//		model.addAttribute("movieCategories", categories);
		
		for (MovieCategory cat : categories){
			PageRequest pageRequest = new PageRequest(0, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
			//Page<MovieContent> movieList = contentManagementService.getMovieContents(cat.getId(), pageRequest);
			
			//List<MovieContent> movies = contentManagementService.getMovieContents(cat.getId(),new PageRequest(0, ITEMS_PER_PAGE)).getContent();
			List<MovieContent> movies = contentManagementService.getMovieContents(cat.getId(),pageRequest).getContent();
			model.addAttribute(cat.getCode(), movies);
			cat.setItemCount(movies.size());
		}
		model.addAttribute("movieCategories", categories);

		return ScreenNames.MOVIES;
	}
	
	@GetMapping(value = "/more/{categoryId}/{pageNo}")
	public String listByCategory(@PathVariable int categoryId, @PathVariable int pageNo, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("movieBanner", contentManagementService.getPromotedMovieContents());
		
//		if (pageNo > 0) pageNo = pageNo - 1;
		PageRequest pageRequest = new PageRequest(pageNo, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
		//Page<MovieContent> page = contentManagementService.getMovieContents(categoryId, new PageRequest(pageNo, ITEMS_PER_PAGE));
		Page<MovieContent> page = contentManagementService.getMovieContents(categoryId, pageRequest);
		model.addAttribute("paging", page);
		model.addAttribute("movieList", page.getContent());
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.MOVIE_LIST_BY_CATEGORY;
	}
	
	@GetMapping(value = "/details/{categoryId}/{id}")
	public String details(@PathVariable int categoryId, @PathVariable int id, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		model.addAttribute("movieDetails", contentManagementService.getMovieContentDetailsById(id));
		List<MovieContent> relatedMovies = contentManagementService.getRelatedMovieContents(categoryId, id, new PageRequest(0, ITEMS_PER_PAGE)).getContent();
		model.addAttribute("relatedMovies", relatedMovies);
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.MOVIE_DETAILS;
	}
}
