package ua.Lysenko.Module2.service.impl;

import ua.Lysenko.Module2.date.Date;

import java.util.List;

public class DateActionsImpl implements ua.Lysenko.Module2.service.DateActions {
    @Override
    public Date dateDifference(Date date1, Date date2) {
        Date resultDate = new Date();
        long difference = Math.abs(date2.getSecondsAbs() - date1.getSecondsAbs());
        resultDate.setSecondsAbs(difference);
        resultDate.setDateFromSecondsAbs();
        return resultDate;
    }

    @Override
    public Date dateAdd(Date date1, Date date2) {
        Date resultDate = new Date();
        resultDate.setSecondsAbs(date1.getSecondsAbs() + date2.getSecondsAbs());
        resultDate.setDateFromSecondsAbs();
        return resultDate;
    }

    @Override
    public Date dateSubtract(Date date1, Date date2) {
        Date resultDate = new Date();
        resultDate.setSecondsAbs(date1.getSecondsAbs() - date2.getSecondsAbs());
        resultDate.setDateFromSecondsAbs();
        return resultDate;
    }

    @Override
    public void dateSort(List<Date> dates) {
        dates.sort((d1, d2) -> (int) (d1.getSecondsAbs() - d2.getSecondsAbs()));
    }
}
