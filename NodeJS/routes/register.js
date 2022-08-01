/**
 * register router
 */

const express = require("express");
const router = express.Router();
const createController = require('../controller/createUser');

router.post('/', createController.create);

module.exports = router;