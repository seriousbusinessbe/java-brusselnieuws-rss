package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat util helper.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class SimpleDateFormatUtil {
    private static final SimpleDateFormat SIMPLE_DATE_MINUTE_SECONDS_FORMAT = new SimpleDateFormat("mm:ss");
    private static final SimpleDateFormat SIMPLE_DATE_SECONDS_FORMAT = new SimpleDateFormat("ss");
    private static final long NUMBER_OF_MILLISECONDS_LESS_THAN_MINUTE=59999;
    
    /**
     * Checks if a number of milliseconds is less than a minute or not.
     * @param timeInMillis
     * @return <code>true</code> when less than a minute, otherwise <code>false</code>
     */
    public static final boolean isLessThanMinute(final long timeInMillis) {
    	return timeInMillis>=0 && timeInMillis<NUMBER_OF_MILLISECONDS_LESS_THAN_MINUTE;
    }
    
    /**
     * Formats milliseconds into a {@link String} date representation of:</br>
     * solely seconds when less than 59999 or minutes and seconds when more.
     * @param timeInMillis
     * @return date representation
     */
    public static final String format(final long timeInMillis) {
    	return (isLessThanMinute(timeInMillis) ? SIMPLE_DATE_SECONDS_FORMAT : SIMPLE_DATE_MINUTE_SECONDS_FORMAT).format(new Date(timeInMillis));
    }

}
