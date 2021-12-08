if (process.env.NODE_ENV != 'production'){
    require('dotenv').config();
};

//aca estoy usando este link para hacer conexion local y debo cambiar la uri en el archivo .env si quiero usar atlas.
const uri = process.env.DB_URI;

// We use mongoose as a ODM (Object Data Model) to map the data base
const mongoose = require('mongoose');
mongoose.Promise = global.Promise;// con esta promesa lo hago global a mi proyecto

async function conectar(){
/*
// este try - catch lo use cuando tenia la conexion local
    try {
        //aca colóco la conexion - lo que esta en comentario es cuando quiero hacer una conexion con atlas
        
        // await mongoose.connect(uri,{useNewUrlParser:true, useUnifiedTopology:true});
        

        //esta conexion la hago para hacerla de manera local usando promesasa
        await mongoose
        .connect(uri, {
          useNewUrlParser: true,
          useUnifiedTopology:true,
        })
        .then((con) => console.log('DB connection successful'));
    } catch (error) {
        console.log(error);
    }
*/

// este try catch usando atlas
        try {
            await mongoose.connect(uri,{useNewUrlParser:true, useUnifiedTopology:true});
        } catch (error) {
            console.log(error);
        }
}

conectar();
let db = mongoose.connection;

db.once('open', ()=>{
    console.log('Connected to the Atlas Data Base')
});

module.exports = mongoose;