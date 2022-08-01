/**
 * Request body and save the constant user on db 
 */

const modelUser = require("./../models/userStructure");

const create = async (req, res) => {
    try {
        console.log(req.body);
        const {user,password} = req.body;
        const userModel = new modelUser({user,password});
        await userModel.save();
        res.send(userModel);
    } catch (error) {
        console.log(error);

        res.status(500).send(error);
    }
}

module.exports = {
    create,}