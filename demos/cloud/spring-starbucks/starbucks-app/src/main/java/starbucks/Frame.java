/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks ;

/**
 * Frame Class -- Container for Screens
 */
public class Frame implements IFrame
{
    private IScreen current ;
    private IMenuInvoker menuA = new MenuOption() ;
    private IMenuInvoker menuB = new MenuOption() ;
    private IMenuInvoker menuC = new MenuOption() ;
    private IMenuInvoker menuD = new MenuOption() ;
    private IMenuInvoker menuE = new MenuOption() ;
    private IOrientationStrategy portraitStrategy ;
    private IOrientationStrategy landscapeStrategy ;
    private IOrientationStrategy currentStrategy ;

    /**
     * Return Screen Name
     * @return Screen Name
     */
    public String screen() { return current.name() ; }

    /** Switch to Landscape Strategy */
    public void landscape() { currentStrategy = landscapeStrategy ; }

    /** Switch to Portrait Strategy */
    public void portrait()  { currentStrategy = portraitStrategy ; }  

    /** Nav to Previous Screen */
    public void previousScreen() {
        // add code here
    }

    /** Nav to Next Screen */
    public void nextScreen() {
        // add code here
    }



   /**
     * Helper Debug Dump to STDERR
     * @param str Lines to print
     */
    private void dumpLines(String str) {
          String[] lines = str.split("\r\n|\r|\n");
          for ( int i = 0; i<lines.length; i++ ) {
            System.err.println( i + ": " + lines[i] ) ;
          }
    }

    /**
     * Helper:  Count lines in a String 
     * @param  str Lines to Count
     * @return     Number of Lines Counted
     */
    private int countLines(String str){

        /*
          // this approach doesn't work in cases: "\n\n"
          String lines = str ;
          String[] split = lines.split("\r\n|\r|\n") ;
          return split.length ;
        */

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

    /** 
     * Helper:  Pad lines for a Screen 
     * @param  num Lines to Padd
     * @return     Padded Lines
     */
    private String padLines(int num) {
        String lines = "" ;
        for ( int i = 0; i<num; i++ ) {
            System.err.print(".") ;
            lines += "\n" ;
        }
        System.err.println("") ;
        return lines ;
    }
    
    /**
     * Helper:  Pad Spaces for a Line
     * @param  num Num Spaces to Pad
     * @return     Padded Line
     */
    private String padSpaces(int num) {
        String spaces = "" ;
        for ( int i = 0; i<num; i++ )
            spaces += " " ;           
        return spaces ;     
    }            

    /** Constructor */
    public Frame(IScreen initial)
    {
        current = initial ;

        portraitStrategy = new IOrientationStrategy() 
        {
            /**
             * Display Screen Contents
             * @param s Reference to Screen
             */
            public void display(IScreen s)
            {
                System.out.println( contents(s) ) ;
            }         

                /**
             * Return String / Lines for Frame and Screen
             * @param  s [description]
             * @return   [description]
             */
            public String contents(IScreen s) 
            { 
                String out = "" ;
                out += "===============\n" ;
                int nameLen = s.name().length() ;
                if (nameLen < 14 ) {
                    int pad = (14 - nameLen) / 2 ;
                    out += padSpaces( pad ) ;
                }
                out += s.name() + "\n" ;
                out += "===============\n" ;
                String screen = s.display() + "\n" ;
                int cnt1 = countLines( screen ) ;
                int pad1 = (10 - cnt1) / 2;
                //System.err.println( "cnt1: " + cnt1 ) ;                
                //System.err.println( "pad1: " + pad1 ) ;
                out += padLines( pad1 ) ;
                out += screen  ;
                //dumpLines( out ) ;                
                int cnt2 = countLines( out ) ;
                int pad2 = 13 - cnt2 ;
                //System.err.println( "cnt2: " + cnt2 ) ;                
                //System.err.println( "pad2: " + pad2 ) ;
                //dumpLines( out ) ;
                String padlines = padLines( pad2 ) ;
                out += padlines ;
                out +=  "===============\n" ;
                out +=  "[A][B][C][D][E]\n" ;
                dumpLines( out ) ;
                return out ;             
            }

            /** Select Command A */
            public void selectA() { menuA.invoke() ; }

            /** Select Command B */
            public void selectB() { menuB.invoke() ; }

            /** Select Command C */
            public void selectC() { menuC.invoke() ; }

            /** Select Command D */
            public void selectD() { menuD.invoke() ; }

            /** Select Command E */
            public void selectE() { /** todo **/ }

        } ;

        landscapeStrategy = new IOrientationStrategy() 
        {
            /**
             * Display Screen Contents
             * @param s Reference to Screen
             */
            public void display(IScreen s)
            {
                System.out.println( contents(s) ) ;
            }         

           /**
             * Display Contents of Frame + Screen 
             * @param  s Screen to Display
             * @return   Contents for Screen
             */
            public String contents(IScreen s) 
            { 
                String out = "" ;
                out += "================================\n" ;
                out += "  " + s.name() + "  \n" ;
                out += "================================\n" ;
                out += s.display() + "\n"  ;
                out += "================================\n" ;
                dumpLines( out ) ;
                return out ;
            }

             /** Don't Respond in Landscaope Mode */
            public void selectA() {  }

            /** Don't Respond in Landscaope Mode */
            public void selectB() {  }

            /** Don't Respond in Landscaope Mode */
            public void selectC() {  }

            /** Don't Respond in Landscaope Mode */
            public void selectD() {  }

            /** Don't Respond in Landscaope Mode */
            public void selectE() {  }

       } ;     

        /* set default layout strategy */
        currentStrategy = portraitStrategy ;
    }

    /**
     * Change the Current Screen
     * @param s Screen Object
     */
    public void setCurrentScreen( IScreen s )
    {
        current = s ;
    }

    /**
     * Configure Selections for Command Pattern 
     * @param slot A, B, ... E
     * @param c    Command Object
     */
    public void setMenuItem( String slot, IMenuCommand c )
    {
        if ( "A".equals(slot) ) { menuA.setCommand(c) ;  }
        if ( "B".equals(slot) ) { menuB.setCommand(c) ; }
        if ( "C".equals(slot) ) { menuC.setCommand(c) ; }
        if ( "D".equals(slot) ) { menuD.setCommand(c) ; } 
        if ( "E".equals(slot) ) { menuE.setCommand(c) ; }   
    }

    /** 
     * Send Touch Event
     * @param x X Coord
     * @param y Y Coord
     */
    public void touch(int x, int y)
    {
        if ( current != null )
            current.touch(x,y) ;

    }

    /**
     * Get Contents of the Frame + Screen 
     * @return Frame + Screen Contents
     */
    public String contents() 
    { 
        if ( current != null )
        {
            return currentStrategy.contents( current ) ; 
        } 
        else 
        {
            return "" ;
        }
    }

    /** Display Contents of Frame + Screen */
    public void display()
    {
        if ( current != null )
        {
            currentStrategy.display( current ) ;
        }
    }
 
    /**
     *  Execute a Command 
     * @param c Command
     */
    public void cmd( String c ) 
    {
        if ( "A".equals(c) ) { selectA() ; }
        if ( "B".equals(c) ) { selectB() ; }
        if ( "C".equals(c) ) { selectC() ; }
        if ( "D".equals(c) ) { selectD() ; }        
        if ( "E".equals(c) ) { selectE() ; }        
    }

    /** Select Command A */
    public void selectA() { currentStrategy.selectA() ;  }

    /** Select Command B */
    public void selectB() { currentStrategy.selectB() ;  }

    /** Select Command C */
    public void selectC() { currentStrategy.selectC() ;  }

    /** Select Command D */
    public void selectD() { currentStrategy.selectD() ;  }

    /** Select Command E */
    public void selectE() { /* todo */  }    

}
