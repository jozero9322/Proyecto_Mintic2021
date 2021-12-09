const {Router} = require('express');
const router = Router();
const auth = require('../auth/auth');

const {getReservas,getReserva,createReserva,editReserva,deleteReserva} = require('../controller/reserva.controller');

router.post('/reservas', auth, getReservas);

// Este metodo es para obtener una reserva recibiendo el codigo de la reserva
router.post('/reserva/:id_reserva', auth, getReserva);

// This method creates a new reservation
router.post('/reserva', auth, createReserva);
router.put('/reserva/:id_reserva',editReserva);
router.delete('/reserva/:id_reserva',deleteReserva);

module.exports = router;