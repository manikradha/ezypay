package com.ezypay.sub.model;

import com.ezypay.sub.utils.Constant;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Objects;


@Document(indexName = Constant.SUBSCRIPTION)
public class Subscription {
    @Id
    private String subscriptionNo;
    @Field(type = FieldType.keyword)
    private  String subscriptionType;
    @Field(type = FieldType.keyword)
    private String payment;
    @Field(type = FieldType.keyword)
    private Long start;
    @Field(type = FieldType.keyword)
    private Long end;
    @Field(type = FieldType.keyword)
    private String amount;

    public String getSubscriptionNo() {
        return subscriptionNo;
    }

    public void setSubscriptionNo(String subscriptionNo) {
        this.subscriptionNo = subscriptionNo;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(subscriptionNo, that.subscriptionNo) &&
                Objects.equals(subscriptionType, that.subscriptionType) &&
                Objects.equals(payment, that.payment) &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(subscriptionNo, subscriptionType, payment, start, end, amount);
    }
}
