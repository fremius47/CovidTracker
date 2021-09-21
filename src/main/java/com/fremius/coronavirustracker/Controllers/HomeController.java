package com.fremius.coronavirustracker.Controllers;

import com.fremius.coronavirustracker.Models.LocationStats;
import com.fremius.coronavirustracker.Services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats=coronaVirusDataService.getAllStats();
        int totalCases=allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases =  allStats.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("TotalReportedCases",totalCases);
        model.addAttribute("TotalNewCases",totalNewCases);

        return "home";
    }

}
