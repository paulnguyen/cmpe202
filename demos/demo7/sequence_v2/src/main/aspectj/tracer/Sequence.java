
package tracer;

import java.io.*;
import java.util.*;
import java.nio.file.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Sequence {

	private String output_dir = "" ;
	private String dsl = "" ;
	private int current_level = 0 ;
	private String scenario ; 
	private Frame current ;
	private Frame frames ;
	private Stack<Frame> stack = new Stack<Frame>();
	
	public Sequence( String name ) {
		this.output_dir = System.getenv("TRACE_OUTPUT") ;
		frames = new Frame() ;
		this.scenario = name ;
		this.frames.name = this.scenario ;
		current = frames ;
		stack.push(current) ;
	}
	
	// get trace of stack frames 
	public Frame getFrames() { return frames ; }
	
	// push a stack frame
	public void push(String name, String pointcut, String target) { 
		this.current_level++ ; 
		String source = current.name ;
		Frame frame = new Frame() ;
		frame.name = target ;
		frame.level = current_level ;
		frame.source = source ;
		frame.target = target ;
		frame.setPointCut( pointcut ) ;
		current.add(frame) ;
		stack.push(current) ;
		current = frame ;
	}
	
	// save current method argument
	public void addArg( String name, String type, String value) {
		current.addArg( name, type, value);
	}
	
	// pop a stack frame
	public void pop() { 
		this.current_level-- ; 
		current = stack.pop() ;
		String source = current.name ;
	}
	public void pop(String returnString ) { 
		this.current_level-- ; 
		current.returns = returnString ;
		current = stack.pop() ;
		String source = current.name ;
	}
	
	// pretty print stack frames
	public void prettyPrint() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(frames));
	}
	
	// save stack frame as json
	public void saveJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(frames).toString();
		File file = new File( output_dir, "trace.json" ) ;
		if ( file.exists() )
			file.delete() ;
		try {
			String path = output_dir + File.separator + "trace.json" ;
			Files.write( Paths.get(path), json.getBytes());
		} catch ( Exception e ) {
			System.out.println( e ) ;
		}
	}
	
	// create a dummy file
    public static void touch ( String filename ) {
    	String dir = System.getenv("TRACE_OUTPUT") ;
    	System.out.println( "TRACE_OUTPUT = " + dir ) ;
        File file = new File( dir, filename ) ;
        if ( !file.exists() ) {
            try {
                file.createNewFile()  ;
            } catch ( Exception e ) {
                System.out.println( e ) ;
            }
        }
    }
	
    // generate dsl (root stack frame)
    public void generateDSL() {
    	dsl = dsl + frames.name + " {\n" ;
    	frames.nested.forEach((frame) -> {
    		gendsl(frame) ;
        });
    	dsl = dsl + "}\n" ;
    	System.out.println( "DSL:\n" + dsl ) ;
    }
    
	// save diagram dsl
	public void saveDSL() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(frames).toString();
		File file = new File( output_dir, "trace.seq" ) ;
		if ( file.exists() )
			file.delete() ;
		try {
			String path = output_dir + File.separator + "trace.seq" ;
			Files.write( Paths.get(path), dsl.getBytes());
		} catch ( Exception e ) {
			System.out.println( e ) ;
		}
	}
	    
    
    // recursive dsl generator for stack frames
    public void gendsl(Frame stack) {
    	dsl = dsl + stack.target + "." + stack.message + "()" + " {\n" ;
    	stack.nested.forEach((frame) -> {
    		gendsl(frame) ;
        });
    	dsl = dsl + "}\n" ;    	
    }
	
	
}