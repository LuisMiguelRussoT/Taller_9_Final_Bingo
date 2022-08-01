
/**
 * make the data base connection
 */
const mongoose = require('mongoose');

const connectDb = () => {
   
    mongoose.connect('mongodb://localhost:27017/userslogin', (err) => {
        if (!err) console.log('db connected');
        else console.log('de error')
    });
};


module.exports = {
    connectDb
}