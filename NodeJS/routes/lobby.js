/**
 * lobby router
 */

 const express = require("express");
 const router = express.Router();
 const lobbyController = require('../controller/lobbyController.js');
 
 router.get('/', lobbyController.load);
 
  module.exports = router;