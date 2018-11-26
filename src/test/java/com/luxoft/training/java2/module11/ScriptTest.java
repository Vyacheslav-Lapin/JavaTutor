package com.luxoft.training.java2.module11;

import java.util.Arrays;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptTest {

		  static class Result {
		    private String[] words;

		    public void setWords(String[] words) {
		      this.words = words;
		    }
		  }

		  static final String SCRIPT = 
				  "var foo = 'Hello World!' ;\n" +
				  "result.setWords(foo.split(' '));";

		  public static void main(String[] args)
		      throws ScriptException {
		    Result result = new Result();
		    javax.script.ScriptEngineManager mgr = new ScriptEngineManager();
		    javax.script.ScriptEngine scripEngine = mgr
		        .getEngineByExtension("js");
		    scripEngine.getContext().setAttribute("result", result,
		        ScriptContext.ENGINE_SCOPE);
		    scripEngine.eval(SCRIPT);
		    System.out.println(Arrays.toString(result.words));
		  }


}
