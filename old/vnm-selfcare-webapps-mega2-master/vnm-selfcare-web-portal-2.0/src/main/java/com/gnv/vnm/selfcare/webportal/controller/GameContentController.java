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

import com.gnv.vnm.selfcare.core.enums.OperatingSystem;
import com.gnv.vnm.selfcare.core.model.GameCategory;
import com.gnv.vnm.selfcare.core.model.GameContent;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/shop/content/games")
public class GameContentController extends WebPortalBaseController {
	
	@GetMapping(value = "/list")
	public String list(Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("gameBanner", contentManagementService.getPromotedGameContents());
		
		List<GameCategory> categories = contentManagementService.getGameCategories();
//		model.addAttribute("gameCategories", categories);
		
		for (GameCategory cat : categories){
			PageRequest pageRequest = new PageRequest(0, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
			//List<GameContent> games = contentManagementService.getGameContents(cat.getId(), OperatingSystem.ALL, new PageRequest(0, ITEMS_PER_PAGE)).getContent();
			List<GameContent> games = contentManagementService.getGameContents(cat.getId(), OperatingSystem.ALL, pageRequest).getContent();
			model.addAttribute(cat.getCode(), games);
			cat.setItemCount(games.size());
		}
		model.addAttribute("gameCategories", categories);
		
		return ScreenNames.GAMES;
	}
	
	@GetMapping(value = "/more/{categoryId}/{pageNo}")
	public String listByCategory(@PathVariable int categoryId, @PathVariable int pageNo, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("gameBanner", contentManagementService.getPromotedGameContents());
		
//		if (pageNo > 0) pageNo = pageNo - 1;
		PageRequest pageRequest = new PageRequest(pageNo, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
		//Page<GameContent> page = contentManagementService.getGameContents(categoryId, OperatingSystem.ALL, new PageRequest(pageNo, ITEMS_PER_PAGE));
		Page<GameContent> page = contentManagementService.getGameContents(categoryId, OperatingSystem.ALL, pageRequest);
		model.addAttribute("paging", page);
		model.addAttribute("gameList", page.getContent());
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.GAME_LIST_BY_CATEGORY;
	}
	
	@GetMapping(value = "/details/{categoryId}/{id}")
	public String details(@PathVariable int categoryId, @PathVariable int id, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		model.addAttribute("gameDetails", contentManagementService.getGameContentDetailsById(id));
		PageRequest pageRequest = new PageRequest(0, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
		//List<GameContent> relatedGames = contentManagementService.getRelatedGameContents(categoryId, id, new PageRequest(0, ITEMS_PER_PAGE)).getContent();
		List<GameContent> relatedGames = contentManagementService.getRelatedGameContents(categoryId, id, pageRequest).getContent();
		
		model.addAttribute("relatedGames", relatedGames);
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.GAME_DETAILS;
	}
}
