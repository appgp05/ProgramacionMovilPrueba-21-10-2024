const cors = require("cors");
const express = require ("express");
const bodyParser = require("body-parser");
const mysql = require ("mysql2/promise");

const app = express();
const PORT = 3000;

app.use(cors());
app.use(bodyParser.json());

const myPool = mysql.createPool({
    host:"localhost",
    user:"root",
    database:"examen",
    password:"",
    port: 3306
});

(async () =>{
    try{
        const connection = await myPool.getConnection();
        connection.release();
    }catch (err){
        console.error("Error trying to connect to the db", err);
    }
});

app.listen(PORT, () =>{
    console.log(`Server running on ${PORT}`);
});

app.post("/loginUsers", async (req, res) =>{
    
    const {email, password} = req.body;

    try{
        const [users] = await myPool.query("SELECT * FROM user WHERE email = ?", [email]);

        if(users.length === 1){
            if(users[0].password === password){
                res.status(200).json({message: "Loged in correctly", user: users[0]});
            }
        }

    }catch(error){
        console.error("Error trying to login");
    }

});