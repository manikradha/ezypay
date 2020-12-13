package com.ezypay.sub.controller;

import com.ezypay.sub.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Validator;

@RestController
public class SubscriptionController {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public Validator validator;

    @Value("${display.total.record}")
    private int totalRecords;



    @PostMapping(value = "/web/subscribe")
    public ModelAndView subscribe(@RequestParam(value = "amount", required = false) String amount,
                                    @RequestParam(value = "type", required = false) String type,
                                    @RequestParam(value = "start", required = false) long start,
                                    @RequestParam(value = "end", required = false) long end) {
        ModelAndView mav = new ModelAndView();
        Subscription subscription = new Subscription();
        subscription.setAmount(amount);
        subscription.setSubscriptionType(type);
        subscription.setStart(start);
        subscription.setEnd(end);
        String actualPayment = "";
        if(type.equals("WEEKLY")){
            actualPayment = "TUESDAY";
        }else if(type.equals("MONTHLY")){
            actualPayment= "20";
        }
        subscription.setPayment(actualPayment);
        mav.addObject("subscription",saveSubscription(subscription));
        return mav;
    }

    public Subscription saveSubscription(Subscription subscription){
        elasticsearchOperations.createIndex(Subscription.class, subscription);
        return subscription;
    }

}
