package parse;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.CalendarComponent;

import java.awt.Component;
import java.awt.List;
import java.io.FileInputStream;


public class ParserICAL {

	public static void main(String[] args) throws Exception {
	
		FileInputStream file = new FileInputStream("ade.ics");
		CalendarBuilder builder = new CalendarBuilder();
		Calendar calendar = builder.build(file);
		
		ComponentList events = calendar.getComponents();

		//System.out.println(calendar.toString());
	}

}
