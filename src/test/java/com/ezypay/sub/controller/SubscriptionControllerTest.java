package com.ezypay.sub.controller;

import com.ezypay.sub.model.Subscription;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionControllerTest {


    @Autowired
    private SubscriptionController subscriptionController;

    private Subscription fakeSubscription;

    @Before
    public void setUp() {
        fakeSubscription = new Subscription();
        fakeSubscription.setAmount("30");
        fakeSubscription.setSubscriptionType("WEEKLY");
        fakeSubscription.setStart(13124141234234L);
        fakeSubscription.setEnd(1312414128888L);
        String actualPayment = "";
        if(fakeSubscription.getSubscriptionType().equals("WEEKLY")){
            actualPayment = "TUESDAY";
        }else if(fakeSubscription.getSubscriptionType().equals("MONTHLY")){
            actualPayment= "20";
        }
        fakeSubscription.setPayment(actualPayment);
    }

    @Test
    public void test_subscribe() {
        Subscription subscription = subscriptionController.saveSubscription(fakeSubscription);
        Assert.assertNotNull(subscription);
    }

}
