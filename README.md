# Practica-de-laboratorio-08-Agenda-Telefonica-con-MVC-y-DAO-con-Archivos-Binarios
Práctica de laboratorio 08: Agenda Telefónica con MVC y DAO con Archivos Binarios

**1.	Agenda Telefónica Archivos**
Se pidió crear una aplicación que registre un usuario y sus teléfonos y que estos se queden archivados en archivos binarios y no en la memoria RAM.
Se crearon 9 paquetes para esta aplicación: 

	ec.edu.ups.controlador
	ec.edu.ups.dao
	ec.edu.ups.fondo
	ec.edu.ups.iconos
	ec.edu.ups.idao
	ec.edu.ups.idioma
	ec.edu.ups.modelo
	ec.edu.ups.vista
  
**2.	ec.edu.ups.modelo**
en este paquete se crearon 2 clases:

	Telefono.java
	Usuario.java
  
**3.	Telefono.java**
En esta clase se instanciaron los siguientes atributos:

	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	private Usuario usuario;

se instanciaron sus getters y su setters. También se crearon los métodos hash code y equals para el código del teléfono.  

**4.	Usuario.java** 
En esta clase se importo el paquete:

	java.util.Objects;
  
se instanciaron los siguientes atributos para la clase usuario: 

	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
  
se crearon sus getters y sus setters, también se creo el método hash code y equals. 
Se creo un método actualizarDatos:

	este método recibe en sus parámetros el nombre, apellido y correo del usuario al momento que quiere actualizar los datos del usuario.  

**5.	ec.edu.ups.idao**
en este paquete se crearon dos interfaces: 

	ITelefono.java
	IUsuario.java
  
**6.	ITelefono.java**
En esta interfaz se importaron los siguientes paquetes:

	ec.edu.ups.modelo.Telefono;
	ec.edu.ups.modelo.Usuario;
	java.util.List;
  
en esta interfaz se crearon los siguientes métodos: 

	void create(Telefono telefono);
	Telefono read(int codigo);
	void update(Telefono telefono);
	void delete(int codigo);   
	List<Telefono> listaTelefonosUsuario(Usuario usuarioControlador); 
	List<Telefono> todosTelefonosGeneral();
	int getCodigoActual();
  
**7.	IUsuario.java**
En esta interfaz se importaron los siguientes paquetes: 

	ec.edu.ups.modelo.Usuario;
en esta interfaz se crearon los siguientes métodos: 

	void create(Usuario usuario);
	Usuario read(String credenciales);
	void update(Usuario usuario);
	Usuario buscarCedula(String cedula);
	Usuario buscarCorreo(String correo);
  
**8.	ec.edu.ups.dao**
En este paquete se crearon dos clases las cuales heredan de las interfaces DAO

	TelefonoDao.java
	UsuarioDao.java
  
**9.	TelefonoDao.java**
En esta clase se importan los siguientes métodos:

	ec.edu.ups.idao.ITelefono;
	ec.edu.ups.modelo.Telefono;
	ec.edu.ups.modelo.Usuario;
	java.io.FileNotFoundException;
	java.io.IOException;
	java.io.RandomAccessFile;
	java.util.ArrayList;
	java.util.List;
  
esta clase implementa los métodos de la interfaz ITelefono, también se instancian los siguientes atributos: 

	RandomAccessFile archivo;
	int codigo;
	int tamanioRegistro;
	UsuarioDao usuarioDao;
	Telefono telefonoInterno;
	Usuario usuarioInterno;
	String eliminar25Bytes;
	String eliminar10Bytes;
  
Constructor:

	TelefonoDao: este constructor recibe en sus parámetros un objeto de tipo UsuarioDao. Al momento que se llama al constructor se crea una nuevo RandomAccessFile que ya tiene predeterminado su ruta y la manera en la que se va a abrir el archivo de texto. Se instancian los tamaños de algunos de los atributos que se van a utilizar en esta clase. Por último, todo esto este envuelto en un try/catch para que el programa no se finalice si es que ocurre un error.  
Métodos:

	Créate: este método recibe en sus parámetros un objeto de tipo Teléfono. Este método lo que hace es posicionarse en la ultima posición del archivo y empezar a crear un nuevo teléfono con los datos que recibe. 
	Read: este método recibe en sus parámetros un código de teléfono. Primero se instancia un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Empezamos a saltar de dato en dato y preguntamos si es que el código que tenemos existe en archivo de teléfonos, si es que lo encuentra retornamos ese teléfono.
	Update: este método recibe en sus parámetros un objeto de tipo Teléfono. Primero se instancia un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Empezamos a saltar de dato en dato y preguntamos si es que el código que tenemos es igual a el teléfono en el archivo, si es que es similar solamente sobre escribimos los nuevos datos sobre los datos antiguos.
	Delete: este método recibe en sus parámetros el código de un teléfono. Primero se instancia un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Empezamos a saltar de dato en dato y preguntamos si es que el código que tenemos es igual a el teléfono en el archivo, si es que es similar mandamos a sobrescribir los datos con espacios vacíos de esta manera deja de existir el teléfono en el archivo. 
	todosTelefonosGeneral: en este método primero instanciamos un nuevo ArrayList() y un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Empezamos a saltar de dato en dato y preguntamos si es que el código no es igual a 0 entonces extraemos todos los datos de ese teléfono y los agregamos a ArrayList. Por utlimo una vez terminado el while retornamos ese ArrayList que contiene todos los teléfonos del archivo. 
	getCodigoActual: este método lo que hace es conseguir el ultimo código del archivo y sumarle un valor mas, por último, retorna ese valor para asignarlo al siguiente teléfono que se va a registrar. 
	listaTelefonosUsuario: este método recibe en sus parámetros un objeto de tipo Usuario. Primero instanciamos un nuevo ArrayList() y un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Como sabemos que al momento de crear un teléfono se agrega un objeto de tipo usuario al teléfono solamente recorremos el archivo y preguntamos si es que la cedula del usuario que tenemos es igual a la cedula del usuario en el archivo. Si es que es igual agregamos los datos del teléfono en el ArrayList, por ultimo, retornamos esa lista con los datos.  

**10.	UsuarioDao.java**
En esta clase se importan los siguientes métodos: 

	ec.edu.ups.idao.IUsuario;
	ec.edu.ups.modelo.Usuario;
	java.io.FileNotFoundException;
	java.io.IOException;
	java.io.RandomAccessFile;
  
esta clase implementa los métodos de la interfaz IUsuario, también se instancian los siguientes atributos:

	RandomAccessFile archivo;
	Usuario usuarioInterno;
	int tamanioRegistro;
  
constructor:

	UsuarioDao: este constructor recibe en sus parámetros un objeto de tipo Usuario. Este constructor al ser llamado instancia un nuevo RandoAccessFile la cual ya tiene predeterminada su ruta y la forma en la que va a abrir el archivo. Se instancian los tamaños de algunos de los atributos que se van a utilizar en esta clase. Por último, todo esto este envuelto en un try/catch para que el programa no se finalice si es que ocurre un error. 
  
Métodos:

	Créate: este método recibe en sus parámetros un objeto de tipos Usurario. Este método lo que hace es posicionarse en la ultima posición del archivo y empieza a crear un nuevo usuario con los datos que tiene. 
	Read: este método recibe en sus parámetros el correo y la contraseña ingresada por el usuario. Primero se instancia un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Luego preguntamos si es que los datos que ingreso el usuario son igual a los datos que se encuentran en el archivo. Si es que es similar retornamos los datos de ese usuario. 
	Update: este método recibe en sus parámetros un objeto de tipos usuario. Primero se instancia un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. En cada recorrido preguntamos si es que la cedula que ingreso el usuario es similar a la cedula que se encuentra en el archivo. Si es que es similar empezamos a sobre escribir los nuevos datos sobre los viejos datos. 
	buscarCedula: este método recibe en sus parámetros la cedula del usuario. Primero se instancia un nuevo Usuario y un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Recorremos los usuarios del archivo y preguntamos si es que la cedula que ingreso usuario es igual a la cedula del archivo. Si es que es igual retornamos es usuario y sus datos.
	buscarCorreo: este método recibe en sus parámetros el correo del usuario. Primero se instancia un nuevo Usuario y un entero para que empiece desde la posición inicial del archivo y con un while recorremos el archivo. Recorremos los usuarios del archivo y preguntamos si es el correo que ingreso usuario es igual al correo del archivo. Si es que es igual retornamos es usuario y sus datos.  
  
**11.	ec.edu.ups.controlador**
en este paquete se crearon dos clases para que interactúan con los GUI. 

	ControladorTelefono
	controladorUsuario
  
**12.	 ComtroladorTelefono**
En esta clase se imprtaron los siguientes paquetes:

	ec.edu.ups.dao.TelefonoDao;
	ec.edu.ups.dao.UsuarioDao;
	ec.edu.ups.modelo.Telefono;
	ec.edu.ups.modelo.Usuario;
	java.util.List;
  
 esta clase tiene instanciado los siguientes atributos: 
 
	TelefonoDao telefonoDao;
	UsuarioDao usuarioDao;
	Telefono telefono;
	Usuario usuario;
  
En esta clase se crearon 8 métodos: 

	crearNuevoTelefono: este método recibe en sus parámetros todos los atributos de un teléfono. Este método lo que hace es agarrar los atributos en sus parámetros y sumarle los espacios para que cada teléfono tenga un espacio de 97 bits. Por último, crea un nuevo teléfono con los datos, lo asigna en el setUsuario y llama al DAO para que cree el nuevo teléfono. 
	VerTelefono: este método recibe en sus parámetros el código del teléfono. Este método llama al telefonoDao y manda que lea el código del teléfono. Una vez que encuentra el teléfono lo retorna al GUI. 
	Actualizar: este método recibe en sus parámetros todos los atributos de un teléfono. Este método lo que hace es agarrar los atributos en sus parámetros y sumarle los espacios para que cada teléfono tenga un espacio de 97 bits. Por último, crea un nuevo teléfono con los datos, lo asigna en el setUsuario y llama al DAO para que cree el nuevo teléfono.
	Eliminar: este método recibe en sus parámetros el código de un Teléfono. Este método llama al telfonoDao y manda a eliminar el teléfono con el código que tiene en sus parámetros.
	verTelefonosGeneral: este método lo que hace es llamar al telefonoDao y que liste todos los teléfonos que existen dentro de un archivo 
	verTelefonosUsuario: este método lo que hace es llamar la telfonoDao y que liste todos los teléfonos bajo ese usuario.
	verTelefonosUsuarioBusqueda: este método recibe en sus parámetros dos objetos de tipo String. Primero se instancia un nuevo objeto de tipo usuario. Luego se crea una condición en la cual verifica que tipo de búsqueda Eligio el usuario. Si es que es un tipo de búsqueda por cedula llama al telfonoDao.buscarCedula, caso contrario llama al TelefonDao.buscarCorreo. pide al DAO que encuentro ese usuario y retorna la lista de teléfono que tiene ese usuario. 
	getCosdigoSiguiente: este metodo lo único lo que hace es conseguir el siguiente código para signarlos al nuevo teléfono que se esta registrando. 
  
**13.	controladorUsuario**
esta clase implementa los siguientes paquetes: 

	ec.edu.ups.dao.TelefonoDao;
	ec.edu.ups.dao.UsuarioDao;
	ec.edu.ups.idao.IUsuario;
	ec.edu.ups.modelo.Telefono;
	ec.edu.ups.modelo.Usuario;
  
esta clase instancia los siguientes atributos: 

	IUsuario usuarioDao;
	Usuario usuario;
Esta clase tiene 5 métodos: 

	Registrar: este método recibe todos los atributos de un usuario en su parámetro. Este método lo que hace es agarrar los atributos en sus parámetros y sumarle los espacios para que cada usuario tenga un espacio de 188 bits. Por ultimo, instancia un nuevo usuario con los atributos del parámetro y llama al DAO a que cree un nuevo usuario. 
	actualizarDatos: este método recibe todos los atributos de un usuario en su parámetro. Este método lo que hace es agarrar los atributos en sus parámetros y sumarle los espacios para que cada usuario tenga un espacio de 188 bits. Este método llama a los Setters de la clase Usuario y ingresa los datos directamente en los setters. Por último, llama al DAO a que actualice el usuario con los datos del parámetro.
	inicioSesion: este método recibe en sus parámetros el correo y la contraseña del GUI VistaIncioSesion. Este método lo que hace primero es completar el tamaño de los objetos para que puedan compararse con el archivo de datos. una vez completado eso llama al usuarioDao a que comprueba si existen esas credenciales. Por último, si es que existe retorna ese usuario si es que no existe retorna null. 
	verUsuario: este método solamente retorna el usuario.
	cargarDatosUsuario: este método recibe en sus parámetros 2 objetos de tipos String. Primero se instancia un nuevo objeto de tipo Usuario, luego se crea una condición en la cual pregunta por que tipo de búsqueda se va a encontrar los datos. si es que es por cedula se llama al usaurioDao.buscarCedula sino se llama a usuariosDao.buscarCorreo. 
  
**14.	ec.edu.ups.fondo**
aquí solamente se agregan las imágenes para el fondo al momento de visualizar el GUI

**15.	ec.edu.ups.iconos**
este paquete solamente contiene los iconos para mejor visualización al mi=omento de correr la aplicación.

**16.	ec.edu.ups.idioma**
este paquete tiene dos clases de tipo properties.

	Mensajes_en_UK.properties
	Mensajes_es_ES.properties
  
Estas clases los único que hacen es cambiar los labels del GUI y cambiar de idioma. En este caso se hicieron dos clases uno para el idioma de español y el otro para el idioma de ingles. 

**17.	ec.edu.ups.vista**
en este paquete se crearon todas las interfaces que se van a utilizar para que el usuario opere la aplicación:

	VistaDirectorioGeneral
	VistaEditarUsuario
	VistaInicioSesion
	VistaMiDirectorio
	VistaPrincipalApp
	VistaRegistrar
  
**18.	VistaPrincipalApp**
En esta interfaz se importaron los siguientes paquetes:

	ec.edu.ups.controlador.ControladorTelefono;
	ec.edu.ups.controlador.ControladorUsuario;
	ec.edu.ups.dao.TelefonoDao;
	ec.edu.ups.dao.UsuarioDao;
	ec.edu.ups.modelo.Usuario;
	java.awt.Dimension;
	java.awt.Toolkit;
	java.util.Locale;
	java.util.ResourceBundle;
	javax.swing.JLabel;
	javax.swing.JMenuItem;
  
se insntanciaron los siguientes atributos para el funcionamiento de la aplicación:

	VistaInicioSesion inicioSesion;
	VistaDirectorioGeneral directorioGeneral;
	VistaMiDirectorio miDirectorio;
	VistaRegistrar resgistrar;
	VistaEditarUsuario editarUsuario;
  
Dao

	Usuario usuario;
	TelefonoDao daoTelefono;
	UsuarioDao daoUsuario;
  
Controlador

	ControladorTelefono controladorTelefono;
	ControladorUsuario controladorUsuario;
	Locale localizacion;
	ResourceBundle mensajes;
  
En su constructor se inicializan todos los objetos tales como DAO, localización, vistas, y se agregan todas las vistas al panel. 
Se crearon dos métodos para el uso de la aplicación: 

	cambiarIdiomaVistaPrincipal: esta sirve para cambiar el idioma de los labels.
	Ocultar: este método sirve para ocultar las demás vistas 
  
Se crearon 9 itemTabs para el uso de la aplicación:

	mnIniciarSesionActionPerformed: este ítem tab visualiza la interfaz de inicioSesion y oculta las demás ventanas.
	mnRegistrarseActionPerformed: este ítem tab visualiza la interfaz de registrar y oculta las demás ventanas.
	mnCerrarSesionActionPerformed: este ítem tab desactiva los ítems tabs: mnMisTelefonos, mnCerrarSesion, mnEditarMisDatos y activa los ítems tabs: mnIniciarSesion, mnRegistrarse. Por último, cambia el lebel del fondo por la palabra “BIENVENIDO “
	mnDirectorioGeneralActionPerformed: este ítem tab visualiza la interfaz directorioGeneral y oculta las demás ventanas.
	mnSalirActionPerformed: finaliza la aplicación.
	mnMisTelefonosActionPerformed: este ítem tab visualiza la interfaz miDirectorio y oculta las demás ventanas. 
	mnEditarMisDatosActionPerformed: este ítem tab visualiza la interfaz editarUsuario y oculta las demás ventanas. 
	mnEspañolActionPerformed: este ítem tab configura el idioma de la aplicación al lenguaje de español
	mnInglesActionPerformed: este ítem tab configura el idioma de la aplicación al lenguaje de ingles
  
**19.	VistaInicioSesion**
Esta interfaz importa los siguiente paquetes: 

	ec.edu.ups.controlador.ControladorTelefono;
	ec.edu.ups.controlador.ControladorUsuario;
	ec.edu.ups.modelo.Usuario;
	javax.swing.JLabel;
	javax.swing.JMenuItem;
	javax.swing.JOptionPane;
  
tambien se instancian los siguientes atributos: 

	ControladorTelefono controladorTelefono;
	ControladorUsuario controladorUsuario;
	VistaPrincipalApp vistaPrincipal;
  
También se creo un action event que hace los siguiente: 

	btIniciarActionPerformed: este action evento lo que hace es comprobar si es que el correo y contraseña que ingreso el usuario existen en el archivo de datos. si es que existe activa unos action tabs y si es que no aparece un option panel informando que se ingreso mal los datos. 
  
**20.	VistaRegistrar**
en esta interfaz se importan los siguientes paquetes: 

	ec.edu.ups.controlador.ControladorTelefono;
	ec.edu.ups.controlador.ControladorUsuario;
	java.util.ResourceBundle;
	javax.swing.JOptionPane;
  
también se instancian los siguientes atributos: 

	ControladorTelefono controladorTelefono;
	ControladorUsuario controladorUsuario;
  
En esta interfaz se creo un Action Event:

	btRegistrarActionPerformed: este action event lo que hace es recibir todos los datos ingresado en los cajones de texto y pasa esos datos al controlador para que cree un nuevo usuario. Al final esconde esa vista y borra los datos de los textbox. 
  
También se tiene un método aparte para el cambio de lenguaje de los labeles, cambiarIdiomaVistaRegistrar().

**21.	VistaMiDirectorio**
Esta interfaz importa los siguientes paquetes:

	ec.edu.ups.controlador.ControladorTelefono;
	ec.edu.ups.controlador.ControladorUsuario;
	ec.edu.ups.modelo.Telefono;
	java.text.ParseException;
	java.util.List;
	java.util.logging.Level;
	java.util.logging.Logger;
	javax.swing.DefaultListModel;
	javax.swing.JFormattedTextField;
	javax.swing.JOptionPane;
	javax.swing.table.DefaultTableModel;
	javax.swing.text.MaskFormatter;
  
se instanciaron los siguientes atributos:

	ControladorTelefono controladorTelefono;
	ControladorUsuario controladorUsuario;

Se crearon 3 métodos para el uso de esta interfaz:

	Limpiar: este método lo único que hace es borrar los datos de los textbox.
	ActualizarTabla: este método lo que hace es actualiza la vista de la tabla cada vez que se agrega un teléfono nuevo o si es que se elimina, etc. 
	editarDatos: este método lo que hace es cambiar el formato del FormatedTextBox ya que al cambiar opción en el option panel se debe cambiar los datos que se ingresan en el formated textbox.  
	Desactivar: este método lo que hace es desactivar algunos botones y activar solamente uno. 
  
Se crearon 7 action events con los siguientes métodos:

	btAgregarActionPerformed: este action event lo que hace primero es comprobar que todos los campos estén completos, una vez comprobado esto llama al controlador teléfono y manda a crear un nuevo teléfono con los datos ingresados en los textBox. 
	btActualizarActionPerformed: este action event lo que hace primero es comprobar que todos los campos estén completos, una vez comprobado esto llama al controlador teléfono y manda a actualizar el teléfono con los datos ingresados en los textBox.
	btBuscarActionPerformed: este action event lo que hace es recibir el código ingresado en la caja de texto y lo busca en la tabla. Si es que lo encuentra automáticamente se señala los datos en la tabla si es que no nos muestra una option panel informándonos que no se ha encontrado el dato. 
	tblDirectorioMouseClicked: este mouse cliked lo que hace es sacar los datos del teléfono seleccionado en la tabla y llama al método editarDatos. Este método auto completar los datos en los textbox. 
	cmbTipoActionPerformed: este método lo que hace es cambiar el formato del Formated text box.
	btCancelarActionPerformed: este método lo que hace es desactivar algunos botones y limpiar los textbox. 
	btEliminarActionPerformed:  este action event lo que hace primero es comprobar que todos los campos estén completos, una vez comprobado esto llama al controlador teléfono y manda a eliminar un teléfono con los datos ingresados en los textBox.
  
**22.	VistaDirectorioGeneral**
En esta interfaz se importaron los siguientes paquetes: 

	import ec.edu.ups.controlador.ControladorTelefono;
	import ec.edu.ups.controlador.ControladorUsuario;
	import ec.edu.ups.modelo.Telefono;
	import ec.edu.ups.modelo.Usuario;
	import java.util.List;
	import javax.swing.DefaultListModel;
	import javax.swing.JOptionPane;
	import javax.swing.table.DefaultTableModel;
  
también se instanciaron los siguientes atributos:

	    private ControladorTelefono controladorTelefono;
	    private ControladorUsuario controladorUsuario;
      
Se creo un metodo para esta interfaz:

	ActualizarTabla: este metodo lo único que hace es actualizar la vista de la tabla cada vez que el usuario hace una acción en la interfaz. 
  
Se crearon dos action events para esta interfaz: 

	btBuscarActionPerformed: este action event lo que hace es busacr al usuario y sus teléfono por cedula o por correo. 
	btListarTodosActionPerformed: este action event lo que hace es actualizar la vista.
  
**23.	VistaEditarUsuario**
En esta interfaz se importaron los siguientes paquetes: 

	import ec.edu.ups.controlador.ControladorTelefono;
	import ec.edu.ups.controlador.ControladorUsuario;
	import ec.edu.ups.modelo.Usuario;
	import javax.swing.JOptionPane;
  
también se instanciaron los siguientes atributos: 

	ControladorTelefono controladorTelefono;
	ControladorUsuario controladorUsuario;
	VistaPrincipalApp vistaPrincipal;
  
Se creo un método para que cargue los datos del usuario cada vez que se ingrese a esta interfaz. También se creo un action event en esta interfaz:

	btGuardarDatosActionPerformed: este action event primero comprueba que todos los campos estén completos. Una vez comprobado llama al controlador usuario para que actualiza los datos obtenidos de los textbox. 
	
	
	
	
	
	
	
	
