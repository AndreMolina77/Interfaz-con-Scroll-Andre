package andre.maldonado.myapplication

import andre.maldonado.myapplication.R.id.txtCorreo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandamos a llamar a todos los elementos de la vista

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtApellido = findViewById<EditText>(R.id.txtApellido)
        val txtDUI = findViewById<EditText>(R.id.txtDUI)
        val txtNacionalidad = findViewById<EditText>(R.id.txtNacionalidad)
        val txtAltura = findViewById<EditText>(R.id.txtAltura)
        val txtPeso = findViewById<EditText>(R.id.txtPeso)
        val txtEstadoCivil = findViewById<EditText>(R.id.txtEstadoCivil)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtDireccion = findViewById<EditText>(R.id.txtDireccion)
        val txtTipoSangre = findViewById<EditText>(R.id.txtTipoSangre)
        val txtTarjetaCredito = findViewById<EditText>(R.id.txtTarjetaCredito)
        val txtProfesion = findViewById<EditText>(R.id.txtProfesion)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)


        btnGuardar.setOnClickListener {
            // Guardo en una variable todos los valores que escribió el usuario
            val nombre = txtNombre.text.toString()
            val apellido = txtApellido.text.toString()
            val dui = txtDUI.text.toString()
            val nacionalidad = txtNacionalidad.text.toString()
            val altura = txtAltura.text.toString()
            val peso = txtPeso.text.toString()
            val estadoCivil = txtEstadoCivil.text.toString()
            val telefono = txtTelefono.text.toString()
            val direccion = txtDireccion.text.toString()
            val tipoSangre = txtTipoSangre.text.toString()
            val tarjetaCredito = txtTarjetaCredito.text.toString()
            val profesion = txtProfesion.text.toString()
            val edad = txtEdad.text.toString()
            val correo = txtCorreo.text.toString()
            val contrasena = txtContrasena.text.toString()


        var hayErrores = false


        //TODO: 1 - Validar que los campos no estén vacíos
        if (nombre.isEmpty()) {
            txtNombre.error = "El nombre es obligatorio"
            hayErrores = true
        }else{
            txtNombre.error = null
        }

        if (apellido.isEmpty()) {
            txtApellido.error = "El apellido es obligatorio"
            hayErrores = true
        }else {
            txtApellido.error = null
        }

        if (dui.isEmpty()) {
            txtDUI.error = "El DUI es obligatorio"
            hayErrores = true
        }else {
            txtDUI.error = null
        }

        if (nacionalidad.isEmpty()) {
            txtNacionalidad.error = "La nacionalidad es obligatoria"
            hayErrores = true
        }else {
            txtNacionalidad.error = null
        }

        if (altura.isEmpty()) {
            txtAltura.error = "La altura es obligatoria"
            hayErrores = true
        }else {
            txtAltura.error = null
        }

        if (peso.isEmpty()) {
            txtPeso.error = "El peso es obligatorio"
            hayErrores = true
        }else {
            txtPeso.error = null
        }

        if (estadoCivil.isEmpty()) {
            txtEstadoCivil.error = "El estado civil es obligatorio"
            hayErrores = true
        }else {
            txtEstadoCivil.error = null
        }

        if (telefono.isEmpty()) {
            txtTelefono.error = "El telefono es obligatorio"
            hayErrores = true
        }else {
            txtTelefono.error = null
        }

        if (direccion.isEmpty()) {
            txtDireccion.error = "La direccion es obligatoria"
            hayErrores = true
        }else {
            txtDireccion.error = null
        }

        if (tipoSangre.isEmpty()) {
            txtTipoSangre.error = "El tipo de sangre es obligatorio"
            hayErrores = true
        }else {
            txtTipoSangre.error = null
        }

        if (tarjetaCredito.isEmpty()) {
            txtTarjetaCredito.error = "La tarjeta de crédito es obligatoria"
            hayErrores = true
        }else {
            txtTarjetaCredito.error = null
        }

        if (profesion.isEmpty()) {
            txtProfesion.error = "La profesión es obligatoria"
            hayErrores = true
        }else {
            txtProfesion.error = null
        }

        //TODO: 2 - Validar que la edad solo contenga números

        if (!edad.matches(Regex("[0-9]+"))){
            txtEdad.error = "La edad debe contener solo números"
            hayErrores = true
        }

        // TODO: 3 - Validar que el correo

            //Valia que tenga el formato [nombre.apellido123@domninio.extension]
            // Por ejemplo: exequiel.miranda314@gmail.com
            //  Usando: [A-Za-<0-9+_.-] + @ [a-z] + [.] + [a-z] +
            // Ejemplo : [nombre.apellido] @ [dominio] [.] [extension]
            //
            //Si queremos que sea:
            // bryan_mirando@ricaldone.edu.sv, sería usando la misma logica:
            //
            // Usando: [A-Za-z0-9+_.-] + @ [a-z] + [.] + [a-z] + [.] + [a-z] +
            // Ejemplo [nombre_apellido] @ [ricaldone] [.] [edu] [.] [sv]
            //
            // Solo se reemplaza lo que está entre comillas
            if(!correo.matches(Regex("[A-Za-z0-9+_.-]+@[a-z]+[.][a-z]+"))){
                txtCorreo.error = "El correo no tiene el formato correcto"
                hayErrores = true
            }else{
                txtCorreo.error = null
            }

            if (contrasena.length <= 7){
                txtContrasena.error = "La contraseña debe contener al menos 7 caracteres"
                hayErrores = true
            }else{
                txtContrasena.error = null
            }

            if(!dui.matches(Regex("[0-9]{8}-[0-9]"))){
                txtDUI.error = "El DUI no tiene un formato válido. Ej:12345678-9"
                hayErrores = true
            }else{
                txtDUI.error = null
            }

            //if (hayErrores) {
                //Hacer algo si hay errores
            //}else{
                //Si todas las validaciones son correctas, procee a guardar los datos
               // guardarDatos(nombre, correo, edad.toInt(), telefono, dui, contrasena)
                //limpiarCampos()
           // }




        }
    }
}