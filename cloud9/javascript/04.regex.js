
// === REGULAR EXPRESSIONS ===

/[aA]{2,}/                        // same as new RegExp("[aA]{2,}") ; -- search for 2 or more lower or upper A's
"aaoo".search(/[aA]{2,}/) ;       // at index 0
"aaoo".search(/[oO]{2,}/) ;       // at index 2
"boo".search(/[aA]{2,}/) ;        // at index -1
"aaoo".replace(/[aA]{2,}/, "b") ; // 'boo'

