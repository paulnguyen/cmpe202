

// === OBJECTS/CLOSURE ===

function Account( bal )
{
  this.withdraw = function (amt) { bal = bal - amt }
  this.getbal = function () { return bal ; }
  return this ;
}

var a = new Account( 1000 ) ;
a.withdraw( 20 ) ;
a.withdraw( 30 ) ;
a.getbal() ;

/*
js> a.withdraw( 20 ) ;
js> a.withdraw( 30 ) ;
js> a.getbal() ;
950
*/


