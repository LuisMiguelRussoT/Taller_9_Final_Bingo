/**
 * login routes
 */

const express = require("express");
const router = express.Router();
const loginController = require('../controller/loginUser');

router.post('/', loginController.consultUserID);

module.exports = router;