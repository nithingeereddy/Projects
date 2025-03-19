package com.automate.DataEx.Model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
public class CustomerData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiptNo;
    private String name;
    private String date;
    private String location;
    private String tax;
    private String total;

    public CustomerData(String receiptNo, String name, String date, String location, String tax, String total) {
        this.receiptNo = receiptNo;
        this.name = name;
        this.date = date;
        this.location = location;
        this.tax = tax;
        this.total = total;
    }
}
