package org.project.model.customUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter extends PropertyEditorSupport {
    Logger logger = LogManager.getLogger(this.getClass());
    @Override
    public void setAsText(String value) {
        try {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(value, df);
            setValue(localDate);
        }
        catch (Exception e){
            logger.error(e);
        }

    }

}