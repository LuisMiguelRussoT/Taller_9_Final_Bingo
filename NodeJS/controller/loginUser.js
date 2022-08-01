

const modelUser = require("./../models/userStructure");

const consultUserID = async (req, res, next) => {
    console.log(req.body);

    try {
        const { _id,user, password } = req.body;
        let result = await modelUser.findOne({user})
        if (!result) {
            return res.status(400).json({ message: "user doesnt exist" });
        }

        if (result.password !== password) {
            return res.status(400).json({ message: "password doesnt match" });
        }

       res.status(200).redirect("/lobby?"+user+"#"+result.id);

       
    } catch (error) {
        console.log(error);
        res.status(500).send(error);
    }
};


module.exports = {
    consultUserID,
    }