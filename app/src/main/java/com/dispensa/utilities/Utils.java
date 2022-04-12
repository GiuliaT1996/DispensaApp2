package com.dispensa.utilities;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Dispensa;
import com.dispensa.dto.DispensaDto;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<DispensaDto> convertDispensa(List<Dispensa> dispensaList) {
        List<DispensaDto> dispense = new ArrayList<>();

        dispensaList.stream().forEach(d ->
                dispense.add(new DispensaDto(d.getName(), d.getQuantity(), d.getSection(), convertDateToData(d.getDataScadenza())))
        );

        return dispense;
    }

    private static String convertDateToData (Temporal.Date data) {
        return data.toDate().getDay() + "-" + data.toDate().getMonth() + "-" + data.toDate().getYear();
    }

    public static String formatData(String oldData) {
        String newData = new String();

        String[] splitted = oldData.split("[\\/\\-]");

        return splitted[2] + "-" + splitted[1] + "-" + splitted[0];
    }

}
