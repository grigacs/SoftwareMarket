package util.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.logging.Logger;

@FacesConverter(value = "dateConverter")
public class DateConverter implements Converter {

private static final Logger LOGGER = Logger.getLogger(DateConverter.class.getSimpleName());
  private static final String MM_DD_YY = "yy.MM.dd";
  private static final String MM_DD_YYYY = "yyyy.MM.dd";
  private SimpleDateFormat yyyyConvertor; 
  private SimpleDateFormat yyConvertor;

  public DateConverter() {
    yyyyConvertor = new SimpleDateFormat(MM_DD_YYYY);
    yyConvertor = new SimpleDateFormat(MM_DD_YY);
    yyConvertor.setLenient(false);
    yyyyConvertor.setLenient(false); 
  }

  @Override
  public Object getAsObject(FacesContext fc, UIComponent component, String value)             throws ConverterException {

   if( value==null || value.isEmpty()) {
      return new Date();
    }

    Date result = null;

    try {
      if (value.length() > MM_DD_YY.length()) { 
        result = (Date)yyyyConvertor.parseObject(value);
      } else {
        result = (Date)yyConvertor.parseObject(value); 
      }
    }
    catch (ParseException e) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid date         format.","Failed to convert " + value + "");
  throw new ConverterException(message);
    }


    return new java.sql.Date(result.getTime());
  }

  @Override
  public String getAsString(FacesContext fc, UIComponent component, Object date) throws     ConverterException {
    try {
      return yyyyConvertor.format((Date)date);
    }
    catch (NullPointerException e) {
      return null;
    }
  }

}