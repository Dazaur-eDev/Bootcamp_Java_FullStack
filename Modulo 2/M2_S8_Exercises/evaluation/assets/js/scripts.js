class Cliente {
    constructor(idCliente, nombre, clave, saldo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.clave = clave;
        this.saldo = saldo;
    }
}

const clientes = [
    new Cliente(1, 'Patricio', '1', 100),
    new Cliente(2, 'Daza', '12', 200),
    new Cliente(3, 'Urqueta', '123', 300)
];
// Cambios realizados de prueba
function solicitarNombreUsuario() {
    return prompt('Bienvenido a Banca en Línea.\nIngrese su nombre de usuario. Si desea salir escriba "Salir"');
}

function encontrarClientePorNombre(nombre) {
    return clientes.find(cliente => cliente.nombre === nombre);
}

function solicitarClave() {
    return prompt('Por favor ingrese su clave');
}

function mostrarMenu(cliente) {
    let opcion;
    do {
        opcion = prompt(`Bienvenido a Banca en Línea ${cliente.nombre}, por favor seleccione que desea hacer:
1. Ver saldo
2. Realizar giro
3. Realizar depósito
4. Salir`);
        procesarOpcion(opcion, cliente);
    } while (opcion !== '4');
}

function procesarOpcion(opcion, cliente) {
    switch (opcion) {
        case '1':
            alert(`Su saldo es de: ${cliente.saldo}`);
            break;
        case '2':
            realizarGiro(cliente);
            break;
        case '3':
            realizarDeposito(cliente);
            break;
        case '4':
            alert("Muchas gracias por utilizar Banca en Línea");
            break;
        default:
            alert("Opción no válida, por favor intente de nuevo.");
    }
}

function realizarGiro(cliente) {
    const giro = parseFloat(prompt(`Su saldo actual es de: ${cliente.saldo}.\nPor favor ingrese el valor del giro`));
    if (giro > 0 && giro <= cliente.saldo) {
        cliente.saldo -= giro;
        alert(`Giro realizado, su nuevo saldo es de ${cliente.saldo}`);
    } else {
        alert(`El valor del giro debe ser mayor a 0 y no debe exceder el saldo disponible de su cuenta que es actualmente de ${cliente.saldo}`);
    }
}

function realizarDeposito(cliente) {
    const deposito = parseFloat(prompt(`Su saldo actual es de: ${cliente.saldo}.\nPor favor ingrese el monto que desea depositar`));
    if (deposito > 0) {
        cliente.saldo += deposito;
        alert(`Depósito realizado, su nuevo saldo es de ${cliente.saldo}`);
    } else {
        alert("El valor del depósito debe ser mayor a 0");
    }
}

(function iniciarBancaEnLinea() {
    let continuar = true;
    while (continuar) {
        const nombre_acceso_key = solicitarNombreUsuario();
        if (nombre_acceso_key === "Salir" || nombre_acceso_key === null) {
            alert("Muchas gracias por utilizar Banca en Línea");
            continuar = false;
            break;
        }
<<<<<<< HEAD
    }
    if(usuario_id == -1){
        alert("Su nombre de usuario no existe, por favor re intente con su nombre de usuario");
    }else{
        console.log(clientes[usuario_id].clave)
        var clave_acceso_key = prompt("Bienvenido "+clientes[usuario_id].nombre+", por favor ingrese su clave")
        if (clientes[usuario_id].clave == clave_acceso_key){
            while(menu!=4){
                var menu = prompt("Bienvenido a Banca en Línea "+clientes[usuario_id].nombre  +", por favor seleccione que desea hacer:\n 1. Ver saldo \n 2. Realizar giro \n 3. Realizar depósito \n 4. Salir");
                if(menu==1){
                    alert("Su saldo es de: "+clientes[usuario_id].saldo+"");
                }else if(menu==2){
                    var giro = parseInt(prompt("Su saldo actual es de: "+clientes[usuario_id].saldo+".\nPor favor ingrese el valor del giro"));
                    if(giro>0 && giro<=clientes[usuario_id].saldo){
                        clientes[usuario_id].saldo = clientes[usuario_id].saldo - giro;
                        alert("Giro realizado, su nuevo saldo es de "+clientes[usuario_id].saldo+"");
                    } else{
                        alert("El valor del giro debe ser mayor a 0 y no debe exceder el saldo disponible de su cuenta que es actualmente de "+clientes[usuario_id].saldo+"");
                    }
                }else if(menu==3){
                    var deposito = parseInt(prompt("Su saldo actual es de: "+clientes[usuario_id].saldo+".\nPor favor ingrese el monto que desea depositar"));
                    if(deposito>0){
                        clientes[usuario_id].saldo = clientes[usuario_id].saldo + deposito;
                        alert("Depósito realizado, su nuevo saldo es de "+clientes[usuario_id].saldo+"");
                    } else{
                        alert("El valor del depósito debe ser mayor a 0");
                    }
                }
=======
        const cliente = encontrarClientePorNombre(nombre_acceso_key);
        if (!cliente) {
            alert("Su nombre de usuario no existe, por favor intente nuevamente");
        } else {
            const clave_acceso_key = solicitarClave();
            if (cliente.clave === clave_acceso_key) {
                mostrarMenu(cliente);
            } else {
                alert("Su clave es incorrecta");
>>>>>>> b7c5b442773ab208024ef13992966c06563be864
            }
        }
    }
})();
