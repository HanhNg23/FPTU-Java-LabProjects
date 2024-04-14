package items;

import java.io.Serializable;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CallRecord implements Serializable {

	@Id @GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date datetime;
	private String fromNumber;
	private String toNumber;
	private int minutes;
	private int seconds;
	private BigDecimal price;
	private static final long serialVersionUID = -706813391935095052L;
	private static final SimpleDateFormat dformat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	
	public CallRecord() {
		
	}

	public CallRecord(String datetime, String fromNumber, String toNumber, int minutes, int seconds)
	throws ParseException{
		this.datetime = dformat.parse(datetime);
		this.fromNumber = fromNumber;
		this.toNumber = toNumber;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public CallRecord(String jsonData) throws ParseException {
		/*Create a call record from a line of the log file (ｊJSON)*/
		String key = null;
		String value;
		HashMap<String, String> map = new HashMap<>();
		
		/*Parse entry into a map*/
		JsonParser parser = Json.createParser(new StringReader(jsonData));
		/*
		while(parser.hasNext()) {
			switch(parser.next()) {
			case "KEY_NAME";
			
			}
		}
		*/
	}
	
	
	
	
}
