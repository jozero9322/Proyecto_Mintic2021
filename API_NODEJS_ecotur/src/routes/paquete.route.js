const {Router} = require('express');
const router = Router();

const {getPaquetes,getPaquete,createPaquete,editPaquete,deletePaquete} = require('../controller/paquete.controller');

router.get('/paquetes',getPaquetes);
router.get('/paquete/:codigo',getPaquete);
router.post('/paquete',createPaquete);
router.put('/paquete/:codigo', editPaquete);
router.delete('/paquete/:codigo',deletePaquete);

module.exports = router;