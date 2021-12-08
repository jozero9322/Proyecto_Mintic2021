const packageCtrl = {};
const modelPackage = require('../model/package.model');

// Get all Packages
packageCtrl.getPaquetes = async (req, res) => {
    try {
        const paquetes = await modelPackage.find({});
        res.status(201).json(paquetes);
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Get only one Package
packageCtrl.getPaquete = async (req, res) => {
    try {
        const paquete = await modelPackage.findOne({codigo:req.params.codigo});
        if (paquete.length == 0){
            res.send("Este paquete no esta en la base de datos");
        } else {
            res.status(201).json(paquete);
        }
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Create a new Package
packageCtrl.createPaquete = async (req, res) => {
    try {
        const paqueteTemp = {
            codigo: req.body.codigo,
            nombre_pac: req.body.nombre_pac,
            descripcion: req.body.descripcion,
            precio: req.body.precio,
            duracion: req.body.duracion,
            salida: req.body.salida,
        }
        let nuevoPaquete = new modelPackage(paqueteTemp);
        await nuevoPaquete.save();
        res.status(201).send("El paquete se ha creado exitosamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Edit an existing Package
packageCtrl.editPaquete = async (req, res) => {
    try {
        const paqueteTemp = {
            codigo: req.body.codigo,
            nombre_pac: req.body.nombre_pac,
            descripcion: req.body.descripcion,
            precio: req.body.precio,
            duracion: req.body.duracion,
            salida: req.body.salida,
        }
        await modelPackage.updateOne({codigo:req.params.codigo},paqueteTemp);
        res.status(201).send("El paquete ha sido actualizado exitosamente");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

// Delete a Package
packageCtrl.deletePaquete = async (req, res) => {
    try {
        await modelPackage.deleteOne({codigo: req.params.codigo});
        res.status(201).send("El paquete ha sido eliminado de la base de datos");
    } catch (error) {
        console.log(error);
        res.status(400).send("Ocurrio un error en la operación");
    }
};

module.exports = packageCtrl;
