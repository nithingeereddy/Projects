var express = require('express');
var router = express.Router();

var users= [
  {
    email: 'nithin2000reddy@gmail.com', password:'Nithin136'
  }
]
/* GET home page. */
router.get('/', function(req, res, next) {
  res.send("Welcome to Backend Server");
});

router.post('/login', function(req, res) {
     let result = users.find(user => user.email == req.body.email);
     if(result) {
       if(result.password == req.body.password) {
         res.status(200).send( {
           
           message: "Successful login!"
         })
       } else {
           res.status(200).send( {
           message: "password incorrect!"
         })
       }
     } else {
          res.status(200).send( {
          message: "User not Found!"
      })
     }
})

module.exports = router;
