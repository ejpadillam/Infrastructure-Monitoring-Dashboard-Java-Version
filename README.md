# Infrastructure Monitoring Dashboard - Java Version 🖥️☕

![Java](https://img.shields.io/badge/java-17+-orange.svg)
![Servlet](https://img.shields.io/badge/servlet-5.0-blue.svg)
![Tomcat](https://img.shields.io/badge/tomcat-10.0+-yellow.svg)
![Status](https://img.shields.io/badge/status-active-success.svg)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

## 📖 Description

Real-time infrastructure monitoring dashboard built with **Java Servlets**, **JSP**, and **JavaScript**. Visualizes critical system metrics (CPU, memory, disk, network) with automatic alerts when defined thresholds are exceeded.

This project is built using standard enterprise Java technologies, demonstrating expertise in:
- Java Servlets (Jakarta EE)
- JavaServer Pages (JSP)
- REST API with JSON
- JDBC for persistence
- Maven for dependency management
- Apache Tomcat as application server

## 🎯 Motivation

During my **10+ years of career in datacenter operations and enterprise application support**, I have worked extensively with production Java applications, monitoring systems, and infrastructure management tools. This project replicates those capabilities in a modern, scalable solution.

Inspired by my experience at:
- **Cirion Technologies**: Enterprise application support and monitoring of 500+ VMs
- **AXITY**: Incident management for Java web applications
- **INDRA**: 7x24 technical support for critical systems

## ✨ Features

- ✅ **REST API with Java Servlets** for metrics, history, and alerts
- ✅ **JSON responses** for integration with JavaScript frontend
- ✅ **Real-time monitoring** with automatic updates every 3 seconds
- ✅ **Chart.js visualization** (interactive charts)
- ✅ **Alert system** with configurable thresholds
- ✅ **Responsive dashboard** (mobile and desktop)
- ✅ **MVC architecture** (Model-View-Controller)
- ✅ **JDBC ready** (easy integration with SQL Server, MySQL, PostgreSQL)

## 🛠️ Tech Stack

**Backend:**
- Java 17+ (compatible with Java 11+)
- Jakarta Servlet API 5.0
- JavaServer Pages (JSP)
- Gson (Google JSON library)
- Apache Tomcat 10.x

**Frontend:**
- JavaScript ES6+
- Chart.js for visualization
- HTML5 + CSS3
- Lucide Icons

**Build Tools:**
- Maven 3.8+

## 📋 Prerequisites

Before starting, make sure you have installed:

- **JDK 17** or higher ([Download](https://adoptium.net/))
- **Apache Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Apache Tomcat 10.x** ([Download](https://tomcat.apache.org/download-10.cgi))
- A Java IDE (IntelliJ IDEA, Eclipse, or VS Code with Java Extension Pack)

### Verify installation:

```bash
# Verify Java
java -version
# Should show: openjdk version "17.x.x" or higher

# Verify Maven
mvn -version
# Should show: Apache Maven 3.8.x or higher

# Verify JAVA_HOME
echo %JAVA_HOME%    # Windows
echo $JAVA_HOME     # Linux/Mac
```

## 🚀 Installation and Execution

### Option 1: Maven + Embedded Tomcat (Recommended)

```bash
# 1. Clone the repository
git clone https://github.com/ejpadillam/infrastructure-monitoring-java.git
cd infrastructure-monitoring-java

# 2. Build the project
mvn clean package

# 3. Run with embedded Tomcat
mvn tomcat7:run

# The application will be available at:
# http://localhost:8080/monitoring-dashboard
```

### Option 2: Deploy to Standalone Tomcat

```bash
# 1. Build the project
mvn clean package

# 2. Copy WAR to Tomcat
cp target/monitoring-dashboard.war $TOMCAT_HOME/webapps/

# 3. Start Tomcat
# Windows:
%TOMCAT_HOME%\bin\startup.bat

# Linux/Mac:
$TOMCAT_HOME/bin/startup.sh

# 4. Access:
# http://localhost:8080/monitoring-dashboard
```

### Option 3: Using IDE (IntelliJ IDEA / Eclipse)

**IntelliJ IDEA:**
1. File → Open → Select project folder
2. Maven will import automatically
3. Run → Edit Configurations → Add Tomcat Server
4. Configure Tomcat and select WAR artifact
5. Run (Shift+F10)

**Eclipse:**
1. File → Import → Existing Maven Projects
2. Right-click project → Run As → Run on Server
3. Select Tomcat Server
4. Finish

## 📸 Screenshots

### Main Dashboard
![Dashboard Overview](screenshots/dashboard-main.png)
*Main view showing real-time metrics*

### REST API Endpoints
![API Response](screenshots/api-json.png)
*JSON response from metrics servlet*

### Alert System
![Alerts System](screenshots/alerts.png)
*Automatic alerts when thresholds are exceeded*

## 💡 Usage

### Access the Dashboard

1. Open your browser at `http://localhost:8080/monitoring-dashboard`
2. The dashboard will automatically update every 3 seconds
3. Alerts will appear when metrics exceed thresholds:
   - CPU > 80%: Critical alert
   - Memory > 85%: Warning alert
   - Disk > 90%: Critical alert

### REST API Endpoints

The application exposes the following endpoints:

```java
// Get current metrics
GET /monitoring-dashboard/api/metrics
Response: {
  "cpu": 45,
  "memory": 62,
  "disk": 78,
  "network": 23,
  "timestamp": "2025-01-27T10:30:00"
}

// Get history (last 20 readings)
GET /monitoring-dashboard/api/history
Response: [
  {"time": "10:30:00", "cpu": 45, "memory": 62, ...},
  {"time": "10:30:03", "cpu": 47, "memory": 63, ...}
]

// Get active alerts
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

### Example usage with curl:

```bash
# Get metrics
curl http://localhost:8080/monitoring-dashboard/api/metrics

# Get history
curl http://localhost:8080/monitoring-dashboard/api/history

# Get alerts
curl http://localhost:8080/monitoring-dashboard/api/alerts
```

## 🏗️ Project Architecture

### MVC Pattern (Model-View-Controller)

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

### Component Explanation:

**Controllers (Servlets):**
- `MetricsServlet.java`: Handles requests for current metrics
- `HistoryServlet.java`: Returns metrics history
- `AlertsServlet.java`: Manages active alerts

**Models:**
- `Metric.java`: Represents a system metric
- `Alert.java`: Represents a generated alert

**Views:**
- `index.jsp`: Main dashboard page
- `dashboard.js`: Frontend logic for dynamic updates

**Utilities:**
- `MetricsGenerator.java`: Generates simulated metrics (replaceable with real data)

## 🔧 Advanced Configuration

### Connect to Real Database (SQL Server, MySQL, PostgreSQL)

The project is ready for JDBC integration. To connect to a database:

1. **Add JDBC dependency in `pom.xml`:**

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

2. **Configure connection in `config.properties`:**

```properties
db.url=jdbc:sqlserver://localhost:1433;databaseName=monitoring
db.username=sa
db.password=YourPassword
db.driver=com.microsoft.sqlserver.jdbc.SQLServerDriver
```

3. **Use in Servlets:**

```java
// Example JDBC query
Connection conn = DriverManager.getConnection(dbUrl, username, password);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM metrics ORDER BY timestamp DESC");
```

### Integration with Real Monitoring Systems

To connect with real systems (instead of simulated data):

```java
// In MetricsGenerator.java, replace:
public static Metric generateMetric() {
    // Simulated data
    return new Metric(random.nextInt(100), ...);
}

// With:
public static Metric generateMetric() {
    // Real system data using JMX
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

- [ ] JDBC integration for SQL Server persistence
- [ ] User authentication (Java Security)
- [ ] Configurable thresholds via UI
- [ ] Email notifications using JavaMail API
- [ ] PDF report export (iText library)
- [ ] Multi-server metrics
- [ ] JMX integration for real system metrics
- [ ] Docker containerization

## 📝 Based on Real Experience

This project is inspired by my professional experience:

- **Cirion Technologies (2024)**: Enterprise Java application support, servlet troubleshooting, and production incident management
- **AXITY (2022-2024)**: Web application monitoring, SQL Server administration, and technical incident resolution
- **INDRA (2021-2022)**: 7x24 support for critical applications, Azure Cloud, and Windows/Linux systems

## 🤝 Contributions

Contributions are welcome! Please:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is under the MIT License - see the [LICENSE](LICENSE) file for details

## 👤 Author

**Eric Padilla**
- LinkedIn: [eric-padilla-maldonado](https://www.linkedin.com/in/eric-padilla-maldonado/)
- GitHub: [@ejpadillam](https://github.com/ejpadillam)
- Email: erickjpm2012zte@gmail.com

---

⭐ If you find this project useful, consider giving it a star on GitHub!

## 🔗 Related Projects

- [Infrastructure Monitoring Dashboard - Python Version](https://github.com/ejpadillam/infrastructure-monitoring-dashboard) - Same functionality implemented with Flask
