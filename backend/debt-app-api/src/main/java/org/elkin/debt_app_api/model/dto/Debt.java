package org.elkin.debt_app_api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Getter
@Setter
@NoArgsConstructor
public class Debt {

  private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

  private String id;
  private long amount;
  private String dueDate;

    public Date getDueDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.dueDate);
    }

    public void setDueDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.dueDate = dateFormat.format(date);
    }
}
