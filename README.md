# ejercicioExperta

Las herramientas utilizadas en este proyecto son: Selenium WebDriver, TestNG y Eclipse.

En primer lugar, es necesario tener instalado el TestNG en el Eclipse. Se adjunta enlace con instrucciones para instalar el TestNG en el Eclipse: http://toolsqa.com/selenium-webdriver/install-testng/

El proyecto se creo como un proyecto Maven. En el archivo pom.xml esta incluida la dependencia correspondiente a Selenium WebDriver.
Seria necesario actualizar el proyecto para que se descarguen las dependencias. (Clic derecho en el proyecto -> Maven -> Update Project)

Para ejecutar los casos posicionarse sobre /Experta/src/main/java/paquete/TestCases.java y hacer clic derecho -> Run As -> TestNg Test

Test Cases Seleccionados:

Test Case 1: método loginInvalido
Esta funcionalidad consiste en acceder a la pagina de Experta y hacer clic en el botón Ingresar.
Una vez en la página de inicio de sesión se ingresa un usuario y contraseña invalidad y se intenta loguear.
Se verifica que se despliegue el mensaje en el cual se indica que la contraseña es invalida

Test Case 2: método VerificarEnlaceLinkedin
Esta funcionalidad consiste en acceder a la pagina de Experta y hacer clic en el icono de linkedin.
Una vez se abre la nueva pestaña, se verifica que el título de la misma coincida con el esperado
