/*
 * Created on Sep 25, 2011
 */
package com.apress.prospring3.ch5.pe;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author clarence
 */
public class PropertyEditorBean {

    private byte[] bytes;                 // ByteArrayPropertyEditor
	
    private Class cls;                    // ClassEditor
    
    private Boolean trueOrFalse;          // CustomBooleanEditor

    private List<String> stringList;      // CustomCollectionEditor
    
    private Date date;                    // CustomDateEditor    
    
    private Float floatValue;             // CustomNumberEditor  
    
    private File file;                    // FileEditor

    private InputStream stream;   // InputStreamEditor

    private Locale locale;                // LocaleEditor
    
    private Pattern pattern;              // PatternEditor

    private Properties properties;        // PropertiesEditor       
    
    private String trimString;            // StringTrimmerEditor
    
    private URL url;                      // URLEditor
    
    private Integer num1;
    
    private int num2;

    public void setCls(Class cls) {
        System.out.println("Setting class: " + cls.getName());
        this.cls = cls;
    }

    public void setFile(File file) {
        System.out.println("Setting file: " + file.getName());
        this.file = file;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setProperties(Properties properties) {
        System.out.println("Loaded " + properties.size() + " properties");
        printProperties(properties);  //added by annbigbig at 2014-03-05 03:12:00
        this.properties = properties;
    }
    
    //added by annbigbig at 2014-03-05 03:12:00
    public void printProperties(Properties properties) {
    	Set<Object> keys = properties.keySet();
    	Iterator<Object> itr = keys.iterator();
    	while(itr.hasNext()){
    		String key = (String)itr.next();
    		String value = properties.getProperty(key);
    		System.out.println("key=" + key + "  value=" + value);
    	}
    }
    

    public void setUrl(URL url) {
        System.out.println("Setting URL: " + url.toExternalForm());
        this.url = url;
    }

    public void setBytes(byte[] bytes) {
        System.out.println("Adding " + bytes.length + " bytes");
        this.bytes = bytes;
    }

	public void setTrueOrFalse(Boolean trueOrFalse) {
		System.out.println("Setting Boolean: " + trueOrFalse);
		this.trueOrFalse = trueOrFalse;
	}

	public void setStringList(List<String> stringList) {
		System.out.println("Setting string list with size: " + stringList.size());
		this.stringList = stringList;
		for (String string: stringList) {
			System.out.println("String member: " + string);
		}
	}

	public void setDate(Date date) {
		System.out.println("Setting date: " + date);
		this.date = date;
	}

	public void setFloatValue(Float floatValue) {
		System.out.println("Setting float value: " + floatValue);
		this.floatValue = floatValue;
	}

	public void setStream(InputStream stream) {
		System.out.println("Setting stream: " + stream);
		this.stream = stream;
	}

	public void setPattern(Pattern pattern) {
		System.out.println("Setting pattern: " + pattern);
		this.pattern = pattern;
	}

	public void setTrimString(String trimString) {
		System.out.println("Setting trim string: " + trimString);
		this.trimString = trimString;
	}

	public void setNum1(Integer num1){
		System.out.println("Setting Integer value:" + num1);
		this.num1 = num1;
	}
	
	public void setNum2(int num2){
		System.out.println("Setting int value:" + num2);
		this.num2 = num2;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:pe/builtin.xml");
		ctx.refresh();

        PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");
    }
}