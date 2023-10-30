package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.LocationStates;
import com.example.demo.services.CoronaVirusDataServiceRepository;
import com.example.demo.services.CoronaVirusDataServices;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private CoronaVirusDataServices crnService;

    @Autowired
    private CoronaVirusDataServiceRepository repository;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStates> allStates = crnService.getAllstates();
        int totalDeathsReported = allStates.stream().mapToInt(LocationStates::getLatestTotalDeaths).sum();
        model.addAttribute("LocationStates", allStates);
        model.addAttribute("totalDeathsReported", totalDeathsReported);
        return "home";
    }

    @RequestMapping(path = "/chart", produces = "application/json")
    @ResponseBody
    public List<LocationStates> chart(Model model) {
        List<LocationStates> allStates = crnService.getAllstates();
        int totalDeathsReported = allStates.stream().mapToInt(LocationStates::getLatestTotalDeaths).sum();
        model.addAttribute("LocationStates", allStates);
        model.addAttribute("totalDeathsReported", totalDeathsReported);
        return allStates;
    }

    @RequestMapping(path = "/chart/{id}", produces = "application/json")
    @ResponseBody
    public Optional<LocationStates> chartByCountryID(@PathVariable("id") int countryId, Model model) {
        Optional<LocationStates> locationStates = repository.findById(countryId);
        return locationStates;
    }

    @RequestMapping(path = "/chart/country={name}", produces = "application/json")
    @ResponseBody
    public List<LocationStates> chartByCountryName(@PathVariable("name") String countryName, Model model) {
        System.out.println("Here View Chart Data by Country Name...");
        List<LocationStates> locationStates = repository.findByCountry(countryName);
        return locationStates;
    }
    
  


    @RequestMapping(path = "/chart/top={count}", produces = "application/json")
    @ResponseBody
    public List<LocationStates> chartByCountryTop(@PathVariable("count") int count, Model model) {
        System.out.println("Here View Chart Data by Country Name...");
        List<LocationStates> locationStates = repository.findTopByLatestTotalDeaths(count);
        return locationStates;
    }

  
    @RequestMapping(value="/viewChart",method = RequestMethod.GET)

    public ModelAndView viewChart() {

    return new ModelAndView("ViewChart").addObject("myURL", new String("http://localhost:8082/Chart"));
    }

   

    @GetMapping("/viewChart/{id}")
    public String viewChartByCountry(@PathVariable("id") int id, Model model) {
        model.addAttribute("countryId", id);
        model.addAttribute("myURL", "http://localhost:8082/Chart/" + id);
        return "ViewChart";
    }

    @GetMapping("/viewChart/country={name}")
    public String viewChartByCountryName(@RequestParam String name, Model model) {
        model.addAttribute("myURL", "http://localhost:8082/Chart/country?" + name);
        return "viewChart";
    }
}
