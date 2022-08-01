/**
 * main de la app
 */

/**
 * imports
 */

const express = require('express');
const cors = require('cors');
const path = require('path');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const dataBase = require('./db/db.js');
const router = express.Router();
const app = express();
const port = 3000;
const routerRegister = require('./routes/register');
const routerLogin = require('./routes/login');
const routerLobby = require('./routes/lobby');
const routerWinner = require('./routes/winner');

const thing = require('./models/userStructure');

/**
 * Conecte to DB mongoose 
 */
 dataBase.connectDb();

/**
 * Middleware
 */

app.use(express.static('public'));
app.use(cors());
app.use(express.urlencoded({extended:true}));
app.use(express.json());

/**
 * call routes
 */

 router.get('/login',function(req,res){
    res.sendFile(path.join(__dirname+'/views/index.html'));
  });

  app.use('/register',routerRegister);
  app.use('/login',routerLogin);
  app.use('/lobby',routerLobby);
  app.use('/winner',routerWinner);

//add the router
app.use('/', router);

app.listen(process.env.port || port,(req,res)=>{
    console.log(`Now listening on port ${port}`); 
});


