/**
 * Basic schema fot the object user
 */

 const mongoose = require('mongoose');
 const userSchema = new mongoose.Schema({

    user: {
      type: String,
      trim: true,
      required: [true, "User is required"],
      lowercase: true,
      unique: true
    },
    password: {
      type: String,
      required: [true, "Password is required"],
      trim: true,
    }
   });
   
  
  module.exports = mongoose.model('User', userSchema);
   



 