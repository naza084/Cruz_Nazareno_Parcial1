# 🏨 Sistema de Servicios de Hospedaje y Gastronomía

---

## Alumno
**Nombre del alumno**: Nazareno Cruz

## 📄 Descripción del Proyecto

Este proyecto es un sistema de gestión diseñado para servicios de hospedaje y gastronomía, implementando conceptos de Programación Orientada a Objetos (POO) en Java. El objetivo es crear una aplicación que permita gestionar estos servicios, calcular precios finales con promociones, y validar atributos mediante excepciones cuando sea necesario.

### Objetivos
- Implementar un modelo orientado a objetos que refleje la gestión de servicios de hospedaje y gastronomía.
- Aplicar promociones y descuentos de forma dinámica.
- Validar la integridad de los datos utilizando excepciones adecuadas.

## 🛠️ Funcionalidades del Sistema

El sistema ofrece las siguientes funcionalidades:

### 1. Gestión de Hospedaje
- **Tipos de Habitaciones**: Administración de habitaciones estándar y deluxe.
- **Servicios Adicionales**: Opción de agregar servicios de limpieza y desayuno.
- **Aplicación de Descuentos**: Descuentos aplicables según la duración de la estadía.

### 2. Gestión de Gastronomía
- **Menús**: Posibilidad de agregar diferentes tipos de menús para los servicios de alimentación.
- **Cálculo de Precios**: Precios ajustables con descuentos según el tipo de comida y el día de la semana.

### 3. Promociones y Descuentos
- Implementación de promociones para estadías prolongadas.
- Penalizaciones por no cumplir con los requisitos establecidos, como el número mínimo de noches.

### 4. Validaciones
- Manejo de excepciones para situaciones como códigos duplicados, valores inválidos, y violaciones de las restricciones de negocio.

### 5. Cálculo de Precio Final
- Método para calcular el precio final del servicio, que incluye todas las promociones y servicios adicionales seleccionados.

## 📦 Estructura del Proyecto

El proyecto está compuesto por las siguientes clases y subclases:

### 1. **Servicio** (Clase Abstracta)
- **Atributos**:
   - `codigo`: Código del servicio.
   - `nombre`: Nombre del servicio.
   - `precioBase`: Precio base del servicio.
   - `diaServicio`: Dia en el cual se da el servicio.

- **Métodos Abstractos**:
   - `calcularPrecioFinal()`: Método que debe ser implementado en las subclases para calcular el precio final del servicio.

### 2. **Hospedaje** (Subclase de Servicio)
- **Atributos Específicos**:
   - `nombreHospedaje`: Nombre del hospedaje.
   - `precioPorNoche`: Indica el precio por noche.
- **Métodos**:
   - `calcularPrecioTotal()`: Aplica descuento de lunes a viernes si está en promoción..

### 3. **Gastronomía** (Subclase de Servicio)
- **Atributos Específicos**:
   - `nombreGastronomia`: Tipo de menú seleccionado (desayuno, almuerzo, cena).
   - `precio`: Precio del servicio de Gastronomia.
   - `diaSemDesc`: Indica el dia de la semana en la que se aplica el descuento.
- **Métodos**:
   - `calcularPrecioFinal()`: Aplica el porcentaje de descuento si está en promoción..

