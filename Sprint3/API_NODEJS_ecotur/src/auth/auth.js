const jwt = require('jsonwebtoken');

const verificaToken = (req, res, next) => {
    // next se usa como una ruta intermedia antes de seguir 
    // con la ruta original
    const token = req.body.token;
    if( !token ) {
        return res.status(400).send("Token es requerido");
    }
    try {
        //aca vamos a verificar decodificando el código
        const decodif = jwt.verify(token,process.env.TOKEN_KEY);
        // en el parametro llamado req.userVerf esta la info del token
        // para cuando se quieran verificar.
        req.userVerf = decodif;
    } catch (error) {
        return res.status(400).send("Token inválido");
    }
    return next();
};

module.exports = verificaToken;