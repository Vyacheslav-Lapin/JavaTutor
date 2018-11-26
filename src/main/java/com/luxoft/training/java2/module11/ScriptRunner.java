package com.luxoft.training.java2.module11;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * java -cp . com.luxoft.training.java2.module11.ScriptRunner "ScriptRunner.getTime()"
 * java -cp . com.luxoft.training.java2.module11.ScriptRunner "2*20"
 */
public class ScriptRunner {

		  static final String SCRIPT = 
				  "a=4; b=2; a*b+a";

		  public static String getTime() {
			  return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
		  }
		  
		  public static void main(String[] args)
		      throws ScriptException {
		    javax.script.ScriptEngineManager mgr = new ScriptEngineManager();
		    javax.script.ScriptEngine scriptEngine = mgr
		        .getEngineByExtension("js");

		    //scriptEngine.getContext().setAttribute("a", result,
		    //    ScriptContext.ENGINE_SCOPE);
		    if (args.length>0) {
		    	String script = args[0];
		    	Object eval = scriptEngine.eval("importPackage(com.luxoft.training.java2.module11);"
		    			+script);
		    	System.out.println("Calculated result: "+eval);
		    }
		  }


}
