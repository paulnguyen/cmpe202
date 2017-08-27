
try {
    setTimeout( function() {
        throw new Error("DANGER ZONE!");
    }, 2000) ;
} catch (e) {
    console.log("I caught the error!");
}

