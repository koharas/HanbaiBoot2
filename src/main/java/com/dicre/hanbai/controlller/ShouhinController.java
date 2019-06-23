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


@Controller
public class ShouhinController {

	 @Autowired
	 private ShouhinRepository repository;


	 @RequestMapping(value="/slist", method=RequestMethod.GET)
	 public ModelAndView slist( ModelAndView mav) {

		List<Shouhin> list = repository.findAll();

		mav.addObject("list",list);

		mav.setViewName("slist");

		return mav;
	 }

	 @RequestMapping(value="/slist", method=RequestMethod.POST)
	 public ModelAndView shouhinAdd(
			 @RequestParam("sname")String sname,
			 @RequestParam("tanka")int tanka,
			 ModelAndView mav) {

		 Shouhin shouhin = new Shouhin(sname,tanka);

		 repository.save(shouhin);

		 mav.setViewName("redirect:/slist");

		 return mav;
	 }


	@RequestMapping(value="/del", method=RequestMethod.GET)
	 public ModelAndView del(
			 @RequestParam("sid")Integer sid,
			 ModelAndView mav) {

		Optional<Shouhin> s = repository.findById(sid);

		mav.addObject("shouhin",s.get());

		mav.setViewName("del");
		return mav;
	 }

	 @RequestMapping(value="/del", method=RequestMethod.POST)
	 public ModelAndView shouhinDel(
			 @RequestParam("sid")Integer sid,
			 ModelAndView mav) {

		 Optional<Shouhin> s = repository.findById(sid);
		 repository.delete(s.get());

		 mav.setViewName("redirect:/slist");

		 return mav;
	 }

	@RequestMapping(value="/update", method=RequestMethod.GET)
	 public ModelAndView update(
			 @RequestParam("sid")Integer sid,
			 ModelAndView mav) {

		Optional<Shouhin> s = repository.findById(sid);

		mav.addObject("shouhin",s.get());

		mav.setViewName("update");
		return mav;
	 }

	 @RequestMapping(value="/update", method=RequestMethod.POST)
	 public ModelAndView shouhinUpdate(
			 @RequestParam("sid")Integer sid,
			 @RequestParam("sname")String sname,
			 @RequestParam("tanka")int tanka,
			 ModelAndView mav) {

		 Optional<Shouhin> s = repository.findById(sid);
		 Shouhin shouhin = s.get();

		 shouhin.setSname(sname);
		 shouhin.setTanka(tanka);

		 repository.save(shouhin);

		 mav.setViewName("redirect:/slist");

		 return mav;
	 }



}
