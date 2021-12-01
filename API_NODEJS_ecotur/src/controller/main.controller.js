const mainCtrl = {}; // vector

// (main) esta es la funcion que va a ser llamada en el main.route.js
mainCtrl.main = (req, res)=>{
    res.json({
        API:"Soy una API"
    });
};


// exporto el vector para ser visible para el que lo importe
module.exports = mainCtrl;