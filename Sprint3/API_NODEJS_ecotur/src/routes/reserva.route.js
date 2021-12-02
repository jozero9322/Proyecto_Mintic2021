const {Router} = require('express');
const router = Router();

const {getReservas,getReserva,createReserva,editReserva,deleteReserva} = require('../controller/reserva.controller');

router.get('/reservas',getReservas);
router.get('/reserva/:id_reserva',getReserva);
router.post('/reserva',createReserva);
router.put('/reserva/:id_reserva',editReserva);
router.delete('/reserva/:id_reserva',deleteReserva);

module.exports = router;