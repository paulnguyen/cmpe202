package starbucks ;

public class Utilities {

	public static final int screen_frame_header = 3 ;
    public static final int portrait_screen_width = 15 ;
    public static final int portrait_screen_length = 10 ;

   	public static String center( String input ) {

		int w = 0 ;
    	int l = 0 ;
    	int h = 0 ;
    	String output = "" ;
    	String s = "" ;
    	String padlines = "" ;
        String padspaces = "" ;
    	int cnt1 = 0 ;
    	int cnt2 = 0 ;
    	int pad1 = 0 ;
    	int pad2 = 0 ;

    	h = screen_frame_header ;
    	w = portrait_screen_width ;
    	l = portrait_screen_length ;


    	output = "" ;
        
        System.err.println( "l: " + l ) ;
        System.err.println( "w: " + w ) ;
        System.err.println( "h: " + w ) ;

        s = input + "\n" ;
        System.err.println( "DEBUG: " + s ) ;
        cnt1 = countLines( s ) ;
        pad1 = (l - cnt1) / 2;
        System.err.println( "cnt1: " + cnt1 ) ;
        System.err.println( "pad1: " + pad1 ) ;
        output += padLines( pad1 ) ;
        // Center Screen Contents Start 
        String[] lines = input.split("\n") ;
        System.err.println( "DEBUG: " + lines + " " + lines.length ) ;
        for (int i = 0; i < lines.length; i++) { 
        	String line = lines[i].trim() ;
        	int len = line.length() ;
            System.err.println( "line (before): " + line + " [len = " + len + "]" ) ;
            int pad = 0 ;
	        if (len < w ) {
	            pad = (int) Math.ceil((double)(w-len)/(double)2);
	            padspaces = padSpaces( pad ) ;
	        }
            System.err.println( "line (after): " + padspaces + line  + " [pad = " + pad + "]" ) ;
	        output += padspaces + line + "\n" ;
        }
        // Center Screen Contents End            
        cnt2 = countLines( output ) ;
        pad2 = l - cnt2 ;
        System.err.println( "cnt2: " + cnt2 ) ;
        System.err.println( "pad2: " + pad2 ) ;
        padlines = padLines( pad2 ) ;
        output += padlines ;

        return output ;    	

    }   

    public static void dumpLines(String str) {
          String[] lines = str.split("\r\n|\r|\n");
          for ( int i = 0; i<lines.length; i++ ) {
            System.err.println( i + ": " + lines[i] ) ;
          }
    }

    public static int countLines(String str){

        if (str == null || str.isEmpty()) {
                return 0;
            }

        int lines = 0;
        int pos = 0;
        while ((pos = str.indexOf("\n", pos) + 1) != 0) {
                lines++;
        }

        return lines ;
    }

    public static String padLines(int num) {
        String lines = "" ;
        for ( int i = 0; i<num; i++ ) {
            System.err.print(".") ;
            lines += "\n" ;
        }
        System.err.println("") ;
        return lines ;
    }
    
    public static String padSpaces(int num) {
        String spaces = "" ;
        for ( int i = 0; i<num; i++ )
            spaces += " " ;           
        return spaces ;     
    }            



} 