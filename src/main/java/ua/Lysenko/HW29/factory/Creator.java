package ua.Lysenko.HW29.factory;

import ua.Lysenko.HW29.Request;
import ua.Lysenko.HW29.entity.*;

public interface Creator {
    Shipment create(Request request);
}
