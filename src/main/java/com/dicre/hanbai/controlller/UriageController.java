package com.dicre.hanbai.controlller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dicre.hanbai.model.Shouhin;
import com.dicre.hanbai.model.ShouhinRepository;
import com.dicre.hanbai.model.Uriage;
import com.dicre.hanbai.model.UriageRepository;


@Controller
public class UriageController {

	 @Autowired
	 private ShouhinRepository srepository;

	 @Autowired
	 private UriageRepository urepository;


	@RequestMapping(value="/uriage", method=RequestMethod.GET)
	 public ModelAndView uriage(
			 @RequestParam("sid")Integer sid,
			 ModelAndView mav) {

		Optional<Shouhin> s = srepository.findById(sid);
		List<Uriage> list = urepository.findBySid(sid);

		mav.addObject("shouhin",s.get());
		mav.addObject("list",list);

		mav.setViewName("uriage");
		 return mav;
	 }

	@RequestMapping(value="/uriage", method=RequestMethod.POST)
	 public ModelAndView  uriageAdd(
			 @RequestParam("sid")Integer sid,
			 @RequestParam("kosu")Integer kosu,
			 ModelAndView mav) {

		urepository.save( new Uriage(sid,kosu));

		mav.setViewName("redirect:/uriage?sid=" + sid);

		return mav;
	 }


}
