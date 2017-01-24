
/*

The Elvis operator (?:) allows you to write 
if/else constructs that have a default 
value in extremely short syntax.

*/


String agentStatus = null ;
String status = null ;

// Java Way

agentStatus = "Active";
status = agentStatus != null ? agentStatus : "Inactive";
println status

// Groovy Way

agentStatus = "Active"
status = agentStatus ? agentStatus : "Inactive"
println status

// Groovy Way -- Even Better!

agentStatus = "Active"
status = agentStatus ?: "Inactive"
println status
