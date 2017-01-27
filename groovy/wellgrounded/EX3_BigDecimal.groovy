
/* Java Big Decimal - Numeric Literal Construction */

BigDecimal x1 = new BigDecimal(3) ;
BigDecimal y1 = new BigDecimal(0.2) ;
System.out.println(x1.add(y1)) ;

/* Java Big Decimal - String Literal Construction */

BigDecimal x2 = new BigDecimal("3");
BigDecimal y2 = new BigDecimal("0.2");
System.out.println(x2.add(y2));

/* Groovy Automatically Wraps Numeric Types
   and Applies Best Practices
*/

println 3 + 0.2;

