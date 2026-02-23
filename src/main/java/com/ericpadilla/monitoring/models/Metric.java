package com.ericpadilla.monitoring.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase modelo que representa una métrica del sistema
 * 
 * Esta clase encapsula los datos de una métrica (CPU, memoria, disco, red)
 * en un momento específico.
 * 
 * @author Eric Padilla
 * @version 1.0
 */
public class Metric {
    
    /*
    ==================== CAMPOS (ATRIBUTOS) ====================
    
    En Java, las variables de instancia se llaman "campos" o "atributos"
    Son privados (private) para encapsulamiento
    */
    
    private int cpu;          // Uso de CPU en porcentaje (0-100)
    private int memory;       // Uso de memoria en porcentaje (0-100)
    private int disk;         // Uso de disco en porcentaje (0-100)
    private int network;      // Tráfico de red en MB/s
    private String timestamp; // Marca de tiempo en formato ISO
    private String time;      // Hora en formato HH:mm:ss
    
    /*
    ¿Qué es private?
    
    private: Solo accesible dentro de esta clase
    public: Accesible desde cualquier parte
    protected: Accesible en subclases
    
    Buena práctica: Campos private + getters/setters public
    */
    
    /*
    ==================== CONSTRUCTORES ====================
    
    Un constructor es un método especial que se ejecuta al crear un objeto
    Mismo nombre que la clase, sin tipo de retorno
    */
    
    /**
     * Constructor vacío (sin parámetros)
     * Requerido por algunas librerías como Gson
     */
    public Metric() {
        // Constructor vacío
        // Gson lo necesita para crear objetos desde JSON
    }
    
    /*
    new Metric() → Llama a este constructor
    Crea un objeto Metric con valores por defecto (0 para int, null para String)
    */
    
    /**
     * Constructor completo con todos los parámetros
     * 
     * @param cpu Uso de CPU (0-100)
     * @param memory Uso de memoria (0-100)
     * @param disk Uso de disco (0-100)
     * @param network Tráfico de red en MB/s
     */
    public Metric(int cpu, int memory, int disk, int network) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.network = network;
        
        /*
        this.cpu = cpu;
        
        ¿Qué es "this"?
        Referencia al objeto actual
        
        this.cpu → El campo de la clase
        cpu → El parámetro del constructor
        
        this.cpu = cpu; significa: "Asigna el valor del parámetro al campo"
        */
        
        // Generar timestamp actual
        LocalDateTime now = LocalDateTime.now();
        
        /*
        LocalDateTime: Clase de Java 8+ para fechas/horas
        
        LocalDateTime.now() → Fecha/hora actual
        Similar a: new Date() en JavaScript, datetime.now() en Python
        */
        
        // Formato ISO: 2025-01-27T10:30:45
        this.timestamp = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
        /*
        DateTimeFormatter: Formatea fechas/horas
        
        ISO_LOCAL_DATE_TIME → 2025-01-27T10:30:45
        
        Otros formatos:
        ISO_DATE → 2025-01-27
        ISO_TIME → 10:30:45
        */
        
        // Formato de tiempo: HH:mm:ss
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.time = now.format(timeFormatter);
        
        /*
        ofPattern("HH:mm:ss") → Patrón personalizado
        
        HH → Hora en formato 24h (00-23)
        mm → Minutos (00-59)
        ss → Segundos (00-59)
        
        Resultado: "10:30:45"
        */
    }
    
    /*
    ==================== GETTERS Y SETTERS ====================
    
    Métodos para acceder y modificar campos privados
    
    Patrón estándar en Java:
    - getter: get + NombreCampo (getCpu)
    - setter: set + NombreCampo (setCpu)
    */
    
    /**
     * Obtiene el valor de uso de CPU
     * @return Porcentaje de uso de CPU (0-100)
     */
    public int getCpu() {
        return cpu;
    }
    
    /*
    Uso:
    Metric metric = new Metric(75, 80, 60, 25);
    int cpuValue = metric.getCpu();  // Retorna 75
    */
    
    /**
     * Establece el valor de uso de CPU
     * @param cpu Nuevo porcentaje de CPU
     */
    public void setCpu(int cpu) {
        this.cpu = cpu;
    }
    
    /*
    Uso:
    metric.setCpu(85);  // Ahora cpu = 85
    */
    
    /**
     * Obtiene el valor de uso de memoria
     * @return Porcentaje de uso de memoria (0-100)
     */
    public int getMemory() {
        return memory;
    }
    
    /**
     * Establece el valor de uso de memoria
     * @param memory Nuevo porcentaje de memoria
     */
    public void setMemory(int memory) {
        this.memory = memory;
    }
    
    /**
     * Obtiene el valor de uso de disco
     * @return Porcentaje de uso de disco (0-100)
     */
    public int getDisk() {
        return disk;
    }
    
    /**
     * Establece el valor de uso de disco
     * @param disk Nuevo porcentaje de disco
     */
    public void setDisk(int disk) {
        this.disk = disk;
    }
    
    /**
     * Obtiene el tráfico de red
     * @return Tráfico de red en MB/s
     */
    public int getNetwork() {
        return network;
    }
    
    /**
     * Establece el tráfico de red
     * @param network Nuevo valor de tráfico en MB/s
     */
    public void setNetwork(int network) {
        this.network = network;
    }
    
    /**
     * Obtiene el timestamp en formato ISO
     * @return Timestamp en formato ISO (2025-01-27T10:30:45)
     */
    public String getTimestamp() {
        return timestamp;
    }
    
    /**
     * Establece el timestamp
     * @param timestamp Nuevo timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Obtiene la hora en formato HH:mm:ss
     * @return Hora en formato HH:mm:ss
     */
    public String getTime() {
        return time;
    }
    
    /**
     * Establece la hora
     * @param time Nueva hora
     */
    public void setTime(String time) {
        this.time = time;
    }
    
    /*
    ==================== MÉTODOS ADICIONALES ====================
    */
    
    /**
     * Convierte el objeto Metric a String para debugging
     * @return Representación en texto del objeto
     */
    @Override
    public String toString() {
        return "Metric{" +
                "cpu=" + cpu +
                ", memory=" + memory +
                ", disk=" + disk +
                ", network=" + network +
                ", timestamp='" + timestamp + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
    
    /*
    @Override: Anotación que indica que estamos sobrescribiendo un método
    
    toString(): Método heredado de Object
    Se llama automáticamente cuando haces:
    System.out.println(metric);
    
    Resultado: 
    Metric{cpu=75, memory=80, disk=60, network=25, timestamp='2025-01-27T10:30:45', time='10:30:45'}
    */
}