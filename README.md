# Infrastructure Monitoring Dashboard - Java Version 🖥️☕

![Java](https://img.shields.io/badge/java-17+-orange.svg)
![Servlet](https://img.shields.io/badge/servlet-5.0-blue.svg)
![Tomcat](https://img.shields.io/badge/tomcat-10.0+-yellow.svg)
![Status](https://img.shields.io/badge/status-active-success.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## 📖 Descripción

Dashboard de monitoreo de infraestructura en tiempo real construido con **Java Servlets**, **JSP**, y **JavaScript**. Visualiza métricas críticas del sistema (CPU, memoria, disco, red) con alertas automáticas cuando se exceden umbrales definidos.

Este proyecto está construido usando tecnologías Java empresariales estándar, demostrando conocimientos en:
- Java Servlets (Jakarta EE)
- JavaServer Pages (JSP)
- REST API con JSON
- JDBC para persistencia
- Maven para gestión de dependencias
- Apache Tomcat como servidor de aplicaciones

## 🎯 Motivación

Durante mi carrera de **10+ años en operaciones de datacenter y soporte de aplicaciones empresariales**, he trabajado extensivamente con aplicaciones Java en producción, sistemas de monitoreo, y herramientas de gestión de infraestructura. Este proyecto replica esas capacidades en una solución moderna y escalable.

Inspirado en mi experiencia en:
- **Cirion Technologies**: Soporte de aplicaciones empresariales y monitoring de 500+ VMs
- **AXITY**: Gestión de incidentes para aplicaciones web Java
- **INDRA**: Soporte técnico 7x24 para sistemas críticos

## ✨ Características

- ✅ **API REST con Java Servlets** para métricas, histórico y alertas
- ✅ **Respuestas JSON** para integración con frontend JavaScript
- ✅ **Monitoreo en tiempo real** con actualización automática cada 3 segundos
- ✅ **Visualización con Chart.js** (gráficos interactivos)
- ✅ **Sistema de alertas** con umbrales configurables
- ✅ **Dashboard responsive** (móvil y desktop)
- ✅ **Arquitectura MVC** (Model-View-Controller)
- ✅ **Preparado para JDBC** (fácil integración con SQL Server, MySQL, PostgreSQL)

## 🛠️ Stack Técnico

**Backend:**
- Java 17+ (compatible con Java 11+)
- Jakarta Servlet API 5.0
- JavaServer Pages (JSP)
- Gson (Google JSON library)
- Apache Tomcat 10.x

**Frontend:**
- JavaScript ES6+
- Chart.js para visualización
- HTML5 + CSS3
- Lucide Icons

**Build Tools:**
- Maven 3.8+

## 📋 Prerequisitos

Antes de comenzar, asegúrate de tener instalado:

- **JDK 17** o superior ([Download](https://adoptium.net/))
- **Apache Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Apache Tomcat 10.x** ([Download](https://tomcat.apache.org/download-10.cgi))
- Un IDE Java (IntelliJ IDEA, Eclipse, o VS Code con Java Extension Pack)

### Verificar instalación:

```bash
# Verificar Java
java -version
# Debe mostrar: openjdk version "17.x.x" o superior
ini
# Verificar Maven
mvn -version
# Debe mostrar: Apache Maven 3.8.x o superior

# Verificar JAVA_HOME
echo %JAVA_HOME%    # Windows
echo $JAVA_HOME     # Linux/Mac
```

## 🚀 Instalación y Ejecución

### Opción 1: Maven + Tomcat Embedido (Recomendado)

```bash
# 1. Clonar el repositorio
git clone https://github.com/ejpadillam/infrastructure-monitoring-java.git
cd infrastructure-monitoring-java

# 2. Compilar el proyecto
mvn clean package

# 3. Ejecutar con Tomcat embedido
mvn tomcat7:run

# La aplicación estará disponible en:
# http://localhost:8080/monitoring-dashboard
```

### Opción 2: Deploy en Tomcat Standalone

```bash
# 1. Compilar el proyecto
mvn clean package

# 2. Copiar el WAR a Tomcat
cp target/monitoring-dashboard.war $TOMCAT_HOME/webapps/

# 3. Iniciar Tomcat
# Windows:
%TOMCAT_HOME%\bin\startup.bat

# Linux/Mac:
$TOMCAT_HOME/bin/startup.sh

# 4. Acceder a:
# http://localhost:8080/monitoring-dashboard
```

### Opción 3: Usando IDE (IntelliJ IDEA / Eclipse)

**IntelliJ IDEA:**
1. File → Open → Seleccionar carpeta del proyecto
2. Maven se importará automáticamente
3. Run → Edit Configurations → Add Tomcat Server
4. Configurar Tomcat y seleccionar el artifact WAR
5. Run (Shift+F10)

**Eclipse:**
1. File → Import → Existing Maven Projects
2. Right-click proyecto → Run As → Run on Server
3. Seleccionar Tomcat Server
4. Finish

## 📸 Screenshots

### Dashboard Principal
![Dashboard Overview](screenshots/dashboard-main.png)
*Vista principal mostrando métricas en tiempo real*

### API REST Endpoints
![API Response](screenshots/api-json.png)
*Respuesta JSON del servlet de métricas*

### Sistema de Alertas
![Alerts System](screenshots/alerts.png)
*Alertas automáticas cuando se exceden umbrales*

## 💡 Uso

### Acceder al Dashboard

1. Abre tu navegador en `http://localhost:8080/monitoring-dashboard`
2. El dashboard se actualizará automáticamente cada 3 segundos
3. Las alertas aparecerán cuando las métricas excedan umbrales:
   - CPU > 80%: Alerta crítica
   - Memoria > 85%: Alerta de advertencia
   - Disco > 90%: Alerta crítica

### API REST Endpoints

La aplicación expone los siguientes endpoints:

```java
// Obtener métricas actuales
GET /monitoring-dashboard/api/metrics
Response: {
  "cpu": 45,
  "memory": 62,
  "disk": 78,
  "network": 23,
  "timestamp": "2025-01-27T10:30:00"
}

// Obtener histórico (últimas 20 lecturas)
GET /monitoring-dashboard/api/history
Response: [
  {"time": "10:30:00", "cpu": 45, "memory": 62, ...},
  {"time": "10:30:03", "cpu": 47, "memory": 63, ...}
]

// Obtener alertas activas
GET /monitoring-dashboard/api/alerts
Response: [
  {
    "type": "critical",
    "metric": "CPU",
    "value": 85,
    "message": "CPU usage is 85% - Critical!",
    "timestamp": "10:30:05"
  }
]
```

### Ejemplo de uso con curl:

```bash
# Obtener métricas
curl http://localhost:8080/monitoring-dashboard/api/metrics

# Obtener histórico
curl http://localhost:8080/monitoring-dashboard/api/history

# Obtener alertas
curl http://localhost:8080/monitoring-dashboard/api/alerts
```

## 🏗️ Arquitectura del Proyecto

### Patrón MVC (Model-View-Controller)

```
┌─────────────┐
│   Browser   │ (View - JSP + JavaScript)
└──────┬──────┘
       │ HTTP Request
       ▼
┌─────────────────┐
│  Java Servlets  │ (Controller)
│  - MetricsServlet
│  - HistoryServlet
│  - AlertsServlet
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│  Model Classes  │ (Model)
│  - Metric
│  - Alert
└─────────────────┘
```

### Explicación de Componentes:

**Controllers (Servlets):**
- `MetricsServlet.java`: Maneja requests para métricas actuales
- `HistoryServlet.java`: Retorna histórico de métricas
- `AlertsServlet.java`: Gestiona alertas activas

**Models:**
- `Metric.java`: Representa una métrica del sistema
- `Alert.java`: Representa una alerta generada

**Views:**
- `index.jsp`: Página principal del dashboard
- `dashboard.js`: Lógica frontend para actualización dinámica

**Utilities:**
- `MetricsGenerator.java`: Genera métricas simuladas (reemplazable con datos reales)

## 🔧 Configuración Avanzada

### Conectar a Base de Datos Real (SQL Server, MySQL, PostgreSQL)

El proyecto está preparado para integración JDBC. Para conectar a una base de datos:

1. **Agregar dependencia JDBC en `pom.xml`:**

```xml
<!-- SQL Server -->
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>12.2.0.jre11</version>
</dependency>

<!-- MySQL -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```

2. **Configurar conexión en `config.properties`:**

```properties
db.url=jdbc:sqlserver://localhost:1433;databaseName=monitoring
db.username=sa
db.password=YourPassword
db.driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
```

3. **Usar en Servlets:**

```java
// Ejemplo de consulta JDBC
Connection conn = DriverManager.getConnection(dbUrl, username, password);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM metrics ORDER BY timestamp DESC");
```

### Integración con Sistemas Reales de Monitoreo

Para conectar con sistemas reales (en lugar de datos simulados):

```java
// En MetricsGenerator.java, reemplazar:
public static Metric generateMetric() {
    // Datos simulados
    return new Metric(random.nextInt(100), ...);
}

// Con:
public static Metric generateMetric() {
    // Datos reales del sistema usando JMX
    OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
    double cpuLoad = osBean.getSystemLoadAverage();
    
    MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
    long usedMemory = memoryBean.getHeapMemoryUsage().getUsed();
    long maxMemory = memoryBean.getHeapMemoryUsage().getMax();
    
    return new Metric((int)(cpuLoad * 100), 
                     (int)((usedMemory * 100) / maxMemory), ...);
}
```

## 🔮 Roadmap

- [ ] Integración con JDBC para persistencia en SQL Server
- [ ] Autenticación de usuarios (Java Security)
- [ ] Configuración de umbrales personalizada vía UI
- [ ] Notificaciones por email usando JavaMail API
- [ ] Exportación de reportes en PDF (iText library)
- [ ] Métricas de múltiples servidores
- [ ] Integración con JMX para métricas reales del sistema
- [ ] Dockerización de la aplicación

## 📝 Basado en Experiencia Real

Este proyecto está inspirado en mi experiencia profesional:

- **Cirion Technologies (2024)**: Soporte de aplicaciones Java empresariales, troubleshooting de servlets, y gestión de incidentes en producción
- **AXITY (2022-2024)**: Monitoreo de aplicaciones web, SQL Server administration, y resolución de incidentes técnicos
- **INDRA (2021-2022)**: Soporte 7x24 para aplicaciones críticas, Azure Cloud, y sistemas Windows/Linux

## 🤝 Contribuciones

Las contribuciones son bienvenidas! Por favor:

1. Fork el proyecto
2. Crea tu feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push al branch (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles

## 👤 Autor

**Eric Padilla**
- LinkedIn: [eric-padilla-maldonado](https://linkedin.com/in/eric-padilla-maldonado)
- GitHub: [@ejpadillam](https://github.com/ejpadillam)
- Email: erickjpm2012zte@gmail.com

---

⭐ Si este proyecto te resulta útil, considera darle una estrella en GitHub!

## 🔗 Proyectos Relacionados

- [Infrastructure Monitoring Dashboard - Python Version](https://github.com/ejpadillam/infrastructure-monitoring-dashboard) - Misma funcionalidad implementada con Flask
