package com.rms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rms.dto.MenuDto;
import com.rms.dto.RestaurantDto;
import com.rms.mapper.MenuMapper;
import com.rms.mapper.RestaurantMapper;
import com.rms.model.Menu;
import com.rms.model.MenuType;
import com.rms.model.Restaurant;
import com.rms.service.RestaurantService;

@RequestMapping(value = { "/", "/home" })
@Controller
public class HomeController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantMapper restaurantMapper;
	@Autowired
	private MenuMapper menuMapper;

	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("restaurants", restaurantService.listRestaurant());
		model.setViewName("home");
		return model;
	}

	@GetMapping("menu-list")
	public ModelAndView menuList(@RequestParam(value = "restaurantId") Long restaurantId) {
		ModelAndView model = new ModelAndView();
		Restaurant restaurant = restaurantService.getRestaurant(restaurantId);
		List<MenuType> menuTypes = restaurantService.listMenuType();

		Map<String, List<Menu>> menuMap = new HashMap<>();

		for (MenuType menuType : menuTypes) {
			menuMap.put(menuType.getName(), restaurantService.listMenu(restaurant, menuType));
		}
		model.addObject("restaurant",restaurant);
		model.addObject("menus", menuMap);
		model.setViewName("menuList");
		return model;
	}
	@GetMapping("add-restaurant")
	public String addRestaurant(Model model) {
		model.addAttribute("restaurantTypes", restaurantService.listRestaurantType());
		model.addAttribute("restaurantDto", new RestaurantDto());
		return "newRestaurant";
	}

	@PostMapping("save-restaurant")
	public String saveRestaurant(@Valid @ModelAttribute RestaurantDto restaurantDto, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "newRestaurant";
		}
		Restaurant restaurant = restaurantMapper.restaurantDtoToRestaurant(restaurantDto);
		restaurantService.saveRestaurant(restaurant);
		redirectAttributes.addFlashAttribute("Message", "Added successfully");
		return "redirect:/home/";
	}

	@GetMapping("list-restaurant")
	public String listRestaurant(Model model) {
		model.addAttribute("restaurants", restaurantService.listRestaurant());
		return "restaurantList";
	}

	@GetMapping("add-menu")
	public String addMenu(Model model,
			@RequestParam(value = "restaurantId", required = false, defaultValue = "0") Long restaurantId) {
		model.addAttribute("menuTypes", restaurantService.listMenuType());
		MenuDto menuDto = new MenuDto();
		menuDto.setRestaurantId(restaurantId);
		model.addAttribute("menuDto", menuDto);
		return "newMenu";
	}

	@PostMapping("save-menu")
	public String saveMenu(@Valid @ModelAttribute MenuDto menuDto, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "newMenu";
		}
		Menu menu = menuMapper.menuDtoToMenu(menuDto);
		restaurantService.saveMenu(menu);
		redirectAttributes.addFlashAttribute("Message", "Added successfully");
		return "redirect:/home/";
	}
}
