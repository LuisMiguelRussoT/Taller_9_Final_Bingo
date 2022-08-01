const path = require('path');

function load (req,res){

    res.sendFile(path.join(__dirname,'../views/winner.html'));
   
}

module.exports = {
    load
}