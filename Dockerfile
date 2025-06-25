FROM openjdk:17

WORKDIR /app

COPY . .

# 🔧 Add execute permission for mvnw
RUN chmod +x mvnw

# 🔨 Build the project
RUN ./mvnw package -DskipTests

# 🔄 Run the app (adjust as needed)
CMD ["java", "-jar", "target/LocationVehicle-0.0.1-SNAPSHOT.jar"]
