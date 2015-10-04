package com.ohdoking.rainbowdiary.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ohdoking.rainbowdiary.HomeController;
import com.ohdoking.rainbowdiary.model.Diary;
import com.ohdoking.rainbowdiary.service.DiaryService;

@Controller
@RequestMapping("/diary")
public class DiaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);
	Map<Integer, Diary> empData = new HashMap<Integer, Diary>();

	@Autowired
	private DiaryService diaryService;

	@RequestMapping(value = { "/", "/lists" }, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> listDiarys(@RequestParam("userId") String userId,
			@RequestParam("month") Integer month, @RequestParam("year") Integer year) {
		
		
		Date date = new Date(year,month,1,0,0);
		
		
		logger.info(date+" !!");
		
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();

		List<Diary> diaryList = diaryService.listDiarys(date,userId);

		jsonObject.put("success", true);
		jsonObject.put("total_count", diaryList.size());
		jsonObject.put("result_list", diaryList);

		return jsonObject;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST,headers = {"Content-type=application/json"})
	public @ResponseBody Map<String, Object> saveDairy(@RequestBody Diary diary) {

		diary.setTimestamp(new Date());
		
		logger.info("Welcome people! {}.", diary.getId() + "/" + diary.getDiaryContent() + "/" + diary.getFeeling()
				+ "/" + diary.getMemberId() + "/" + diary.getTimestamp() + "/");

		Map<String, Object> jsonObject = new HashMap<String, Object>();
		diaryService.saveDiary(diary);

		jsonObject.put("success", true);

		return jsonObject;
	}

	@RequestMapping("/delete/{diaryId}")
	public @ResponseBody Map<String, Object> deletePeople(@PathVariable("diaryId") Long id) {

		Map<String, Object> jsonObject = new HashMap<String, Object>();

		jsonObject.put("success", true);

		diaryService.deleteDiary(id);

		return jsonObject;
	}
    
    
    

  /*  @RequestMapping("/get/{peopleId}")
    public String getPeople(@PathVariable Long peopleId, Map<String, Object> map) {

           People people = peopleService.getPeople(peopleId);

           
           
           map.put("people", people);

           return "/people/peopleForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePeople(@ModelAttribute("people") People people,
                  BindingResult result) {
 	   
 	   logger.info("Welcome people! {}.", 
 			   people.getName() + "/" +
				   people.getAge() + "/" +
				   people.getSex() + "/" +
				   people.getEtc()
 	   );
 	   	
           peopleService.savePeople(people);

           
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            
           return "redirect:listPeoples";
    }

    @RequestMapping("/delete/{peopleId}")
    public String deletePeople(@PathVariable("peopleId") Long id) {

           peopleService.deletePeople(id);

           
            * redirects to the path relative to the current path
            
           // return "redirect:../listPeoples";

           
            * Note that there is the slash "/" right after "redirect:"
            * So, it redirects to the path relative to the project root path
            
           return "redirect:/people/listPeoples";
    }
    
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public @ResponseBody String savePeopleData(@ModelAttribute("people") People people,
                  BindingResult result) {
 	   
 	   logger.info("Welcome people! {}.", 
 			   people.getName() + "/" +
				   people.getAge() + "/" +
				   people.getSex() + "/" +
				   people.getEtc()
 	   );
 	   	
           peopleService.savePeople(people);

           
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            
           
           
           return "success";
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody List<People> getAllPeoples() {
        logger.info("Start getAllEmployees.");
        List<People> peoples = peopleService.getPeopleAll();
        for(People i : peoples){
            peoples.add(empData.get(i));
        }
        return peoples;
    }*/
}
