const path = require('path');

function load (req,res){

    res.sendFile(path.join(__dirname,'../views/lobby.html'));
   
}

module.exports = {
    load
}