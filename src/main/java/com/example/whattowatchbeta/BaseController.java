package com.example.whattowatchbeta;

import com.example.whattowatchbeta.IMDB.IMDBMovieEntityRepository;
import com.example.whattowatchbeta.IMDB.IMDBMovieService;
import com.example.whattowatchbeta.IMDB.Model.IMDBMovieEntity;
import com.example.whattowatchbeta.IMDB.Model.imdbBaseModels.AdvancedSearchData;
import com.example.whattowatchbeta.Mail.MailService;
import com.example.whattowatchbeta.OTT.OTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class BaseController {
//These endpoints is to trigger service layer job for testing purpose only
    @Autowired
    private OTTService ottService;

    @Autowired
    private IMDBMovieService imdbMovieService;

    @Autowired
    private IMDBMovieEntityRepository imdbMovieEntityRepository;

    @RequestMapping("/home")
    public String none1(){
        return  "What to watch is watching watch you watch";
    }

    @RequestMapping("/scheduledOTTCheckService")
    public String none(){
        ottService.scheduledOTTCheckService();
        return "started";
    }
    @RequestMapping("/addNewMoviesIMDB")
    public String none2(){
        try {
            imdbMovieService.scheduledAddNewService();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "movie service started";
    }


    @RequestMapping("/show")

    public List<IMDBMovieEntity> getALlMovies(){
        return imdbMovieEntityRepository.findAll();
    }

    @Autowired
    MailService mailService;
    @RequestMapping("/mail")
    public void none3(){
        mailService.getOTTDetails();
    }


    @RequestMapping("/htmlMail")

    public void sendHtmlMain(){
        mailService.getOTTDetails();
    }

}
