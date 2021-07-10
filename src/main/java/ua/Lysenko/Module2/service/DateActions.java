package ua.Lysenko.Module2.service;

import ua.Lysenko.Module2.date.Date;

import java.util.List;

public interface DateActions {
    Date dateDifference(Date date1, Date date2);

    Date dateAdd(Date date1, Date date2);

    Date dateSubtract(Date date1, Date date2);

    void dateSort(List<Date> dates);

}
