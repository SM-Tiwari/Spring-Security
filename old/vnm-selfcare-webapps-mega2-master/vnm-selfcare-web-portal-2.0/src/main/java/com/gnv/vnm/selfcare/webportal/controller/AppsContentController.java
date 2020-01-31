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
import com.gnv.vnm.selfcare.core.model.AppsCategory;
import com.gnv.vnm.selfcare.core.model.AppsContent;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/shop/content/apps")
public class AppsContentController extends WebPortalBaseController {
	
//	private static final Logger logger = LoggerFactory.getLogger(AppsContentController.class);
	
	@GetMapping(value = "/list")
	public String list(Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("appsBanner", contentManagementService.getPromotedAppsContents());
		
		List<AppsCategory> categories = contentManagementService.getAppsCategories();
//		model.addAttribute("appsCategories", categories);
		
		for (AppsCategory cat : categories){
			PageRequest pageRequest = new PageRequest(0, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
			//List<AppsContent> apps = contentManagementService.getAppsContents(cat.getId(), OperatingSystem.ALL, new PageRequest(0, ITEMS_PER_PAGE)).getContent();
			List<AppsContent> apps = contentManagementService.getAppsContents(cat.getId(), OperatingSystem.ALL,pageRequest).getContent();
			
			model.addAttribute(cat.getCode(), apps);
			cat.setItemCount(apps.size());
		}
		
		model.addAttribute("appsCategories", categories);
		return ScreenNames.APPS;
	}
	
	@GetMapping(value = "/more/{categoryId}/{pageNo}")
	public String listByCategory(@PathVariable int categoryId, @PathVariable int pageNo, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("appsBanner", contentManagementService.getPromotedAppsContents());
		PageRequest pageRequest = new PageRequest(pageNo, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
		//Page<AppsContent> page = contentManagementService.getAppsContents(categoryId, OperatingSystem.ALL, new PageRequest(pageNo, ITEMS_PER_PAGE));
		Page<AppsContent> page = contentManagementService.getAppsContents(categoryId, OperatingSystem.ALL, pageRequest);
		
		model.addAttribute("paging", page);
		model.addAttribute("appsList", page.getContent());
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.APPS_LIST_BY_CATEGORY;
	}
	
	@GetMapping(value = "/details/{categoryId}/{id}")
	public String details(@PathVariable int categoryId, @PathVariable int id, Model model, Principal authUser, Locale locale, HttpServletRequest request){
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		AppsContent apps = contentManagementService.getAppsContentDetailsById(id);
//		LoggingUtil.debug(logger, "#details --- app_details in controller= " + apps);
		
		model.addAttribute("appsDetails", apps);
		PageRequest pageRequest = new PageRequest(0, ITEMS_PER_PAGE, new Sort(Direction.ASC, "code"));
		//List<AppsContent> relatedApps = contentManagementService.getRelatedAppsContents(categoryId, id, new PageRequest(0, ITEMS_PER_PAGE)).getContent();
		List<AppsContent> relatedApps = contentManagementService.getRelatedAppsContents(categoryId, id, pageRequest).getContent();
		
		model.addAttribute("relatedApps", relatedApps);
		model.addAttribute("categoryId", categoryId);
		
		return ScreenNames.APPS_DETAILS;
	}
}
