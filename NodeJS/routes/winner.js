/**
 * winner router
 */

 const express = require("express");
 const router = express.Router();
 const winnerController = require('../controller/winnerController.js');
 
 router.get('/', winnerController.load);
  
 module.exports = router;