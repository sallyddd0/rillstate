package com.baekhwa.song.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface CustomerService {

	void list(Model model, int divno);

	void list(Model model, String div);

	ModelAndView list(ModelAndView mv, int divno);

}
