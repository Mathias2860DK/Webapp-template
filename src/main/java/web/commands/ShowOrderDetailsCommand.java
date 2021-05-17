package web.commands;

import business.entities.DeliveryInfo;
import business.entities.Material;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.DeliveryInfoFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderDetailsCommand extends CommandProtectedPage {
    public ShowOrderDetailsCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        System.out.println("komemr vi ind her");
        return pageToShow;
    }
}
